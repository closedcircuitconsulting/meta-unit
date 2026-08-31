# Automation
## Roll
Use the [roll.py](roll.py) script to update 3rd-party layers to their latest revisions in the working tree.

### Check types
```bash
uvx --with-requirements roll.py ty check roll.py
```

### Lint
```bash
uvx ruff check --fix roll.py
```

### Format
```bash
uvx ruff format roll.py
```

### Run
Run with no output.
```bash
uv run roll.py
```

Run with info output.
```bash
uv run roll.py --level INFO
```

Run with debug output.
```bash
uv run roll.py --level DEBUG
```
