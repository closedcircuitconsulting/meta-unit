do_install:append() {
    # Assumes that .profile is already installed.
    # Podman uses these (if defined) for overriding
    # default configuration file locations. This is
    # explained here:
    #   https://github.com/containers/podman/blob/main/docs/tutorials/rootless_tutorial.md#user-configuration-files
    # In addition it is needed for user journals to
    # function properly.
    cat >> ${D}/home/${USER_TO_ADD_NAME}/.profile << 'EOF'
export XDG_RUNTIME_DIR=/run/user/$(id -u)
export XDG_CONFIG_HOME=$HOME/.config
EOF
}
