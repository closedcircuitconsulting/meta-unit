SUMMARY = "Install a copy of rpi u-boot boot script to rootfs"
LICENSE = "MIT"

DEPENDS = "rpi-u-boot-scr"

inherit allarch

do_install() {
    install -d ${D}${sysconfdir}/rpi
    install -m 0644 ${DEPLOY_DIR_IMAGE}/boot.scr ${D}${sysconfdir}/rpi/boot.scr
}

FILES:${PN} = "${sysconfdir}/rpi/boot.scr"

# Ensure rpi-u-boot-scr's do_deploy runs before rootfs installation
do_install[depends] += "rpi-u-boot-scr:do_deploy"
