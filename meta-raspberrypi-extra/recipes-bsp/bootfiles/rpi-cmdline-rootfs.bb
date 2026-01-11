SUMMARY = "Install a copy of cmdline.txt to rootfs"
LICENSE = "MIT"

DEPENDS = "rpi-cmdline"

inherit allarch

do_install() {
    install -d ${D}${sysconfdir}/rpi
    install -m 0644 ${DEPLOY_DIR_IMAGE}/${BOOTFILES_DIR_NAME}/cmdline.txt ${D}${sysconfdir}/rpi/cmdline.txt
}

FILES:${PN} = "${sysconfdir}/rpi/cmdline.txt"

# Ensure rpi-cmdline's do_deploy runs before rootfs installation
do_install[depends] += "rpi-cmdline:do_deploy"
