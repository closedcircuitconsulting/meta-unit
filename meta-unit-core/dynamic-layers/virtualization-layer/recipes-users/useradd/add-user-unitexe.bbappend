do_install:append() {
    # If linger is not enabled then rootless podman 
    # commands will complain with number of warnings.
    install -d ${D}${localstatedir}/lib/systemd/linger
    touch ${D}${localstatedir}/lib/systemd/linger/${USER_TO_ADD_NAME}

    # Note: Use of .profile here assumes busybox shell.
    # Podman uses these (if defined) for overriding
    # default configuration file locations. This is
    # explained here:
    #   https://github.com/containers/podman/blob/main/docs/tutorials/rootless_tutorial.md#user-configuration-files
    cat > ${D}/home/${USER_TO_ADD_NAME}/.profile << 'EOF'
export XDG_RUNTIME_DIR=/run/user/$(id -u)
export XDG_CONFIG_HOME=$HOME/.config
EOF
}

FILES:${PN}:append = " ${localstatedir}/lib/systemd/linger/${USER_TO_ADD_NAME}"
