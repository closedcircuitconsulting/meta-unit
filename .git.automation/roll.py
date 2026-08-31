# /// script
# requires-python = ">=3.13"
# dependencies = [
#     "gitpython>=3.1.57",
#     "ruamel-yaml>=0.19.1",
# ]
# ///

import argparse
import logging
import sys
from pathlib import Path

from git.cmd import Git
from ruamel.yaml import YAML
from ruamel.yaml.scalarstring import PlainScalarString

BRANCH_FILE_NAMES = [
    "2.18.yml",
    "main.yml",
    "wrynose.yml",
]

logger = logging.getLogger(__name__)


def get_latest_commit(
    remote: str,
    branch: str,
) -> str:
    # ls-remote returns a string like:
    #   26d8b36a72acf1458a2520e4e9f4d654a4ba77e4	refs/heads/master
    # the commit needs to get split out
    output = str(Git().execute(["git", "ls-remote", f"{remote}", f"{branch}"]))
    commit = output.split()[0]
    return commit


def build_argparse_namespace() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description="Roll 3rd-party layer commits")
    parser.add_argument(
        "--level",
        type=str,
        default="NOTSET",
        choices=logging.getLevelNamesMapping().keys(),
        help="Logging level",
    )
    return parser.parse_args()


def main() -> None:
    argparse_namespace = build_argparse_namespace()

    # Configure logging
    if argparse_namespace.level == "NOTSET":
        # Globally suppress logging
        logging.disable(logging.CRITICAL)
    else:
        logging.basicConfig(
            stream=sys.stderr,
            level=logging.getLevelNamesMapping()[argparse_namespace.level],
            format="%(asctime)s [%(levelname)s] %(name)s: %(message)s",
        )

    yaml = YAML()
    yaml.preserve_quotes = True
    script_path = Path(__file__).resolve()
    script_dir = script_path.parent
    layers_directory = script_dir / "../meta-unit-kas/include/layers"
    for layer_directory in layers_directory.iterdir():
        if layer_directory.is_dir():
            remote_file_path = layer_directory / "remote.yml"
            if remote_file_path.exists():
                with open(remote_file_path, "r") as remote_file:
                    remote_data = yaml.load(remote_file)
                    remote = str(remote_data["repos"][f"{layer_directory.name}"]["url"])
                for layer_conf in layer_directory.iterdir():
                    if layer_conf.is_file() and layer_conf.name in BRANCH_FILE_NAMES:
                        with open(layer_conf, "r") as branch_file:
                            branch_data = yaml.load(branch_file)
                            branch = str(
                                branch_data["repos"][f"{layer_directory.name}"][
                                    "branch"
                                ]
                            )
                            commit = str(
                                branch_data["repos"][f"{layer_directory.name}"][
                                    "commit"
                                ]
                            )
                            latest_commit = get_latest_commit(remote, branch)

                        logger.debug("Current commit: %s", commit)
                        logger.debug("Latest commit: %s", latest_commit)
                        if commit != latest_commit:
                            logger.info(
                                "Updating %s %s: %s -> %s",
                                layer_directory.name,
                                branch,
                                commit,
                                latest_commit,
                            )
                            branch_data["repos"][f"{layer_directory.name}"][
                               "commit"
                            ] = PlainScalarString(latest_commit)
                            with open(layer_conf, "w") as f:
                               yaml.dump(branch_data, f)


if __name__ == "__main__":
    main()
