SUMMARY = "Install a copy of config.txt to rootfs"
LICENSE = "MIT"

DEPENDS = "rpi-config"

inherit allarch

do_install() {
    install -d ${D}${sysconfdir}/rpi
    install -m 0644 ${DEPLOY_DIR_IMAGE}/${BOOTFILES_DIR_NAME}/config.txt ${D}${sysconfdir}/rpi/config.txt
}

FILES:${PN} = "${sysconfdir}/rpi/config.txt"

# Ensure rpi-config's do_deploy runs before rootfs installation
do_install[depends] += "rpi-config:do_deploy"
