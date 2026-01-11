do_install:append() {
    # If linger is not enabled then rootless podman 
    # commands will complain with number of warnings.
    # Enabling linger does two effects for systemd user units:
    #   1. Units are automatically started after a reboot
    #   2. Units are not automatically stopped after a log out
    install -d ${D}${localstatedir}/lib/systemd/linger
    touch ${D}${localstatedir}/lib/systemd/linger/${USER_TO_ADD_NAME}
}

FILES:${PN}:append = " ${localstatedir}/lib/systemd/linger/${USER_TO_ADD_NAME}"
