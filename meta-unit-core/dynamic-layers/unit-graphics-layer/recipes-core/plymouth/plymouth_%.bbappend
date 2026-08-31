# Using yocto's initramfs framework to generate initramfs instead
RDEPENDS:${PN}-initrd:remove = "dracut"

PACKAGECONFIG:append = " drm"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://plymouthd.conf"

do_install:append() {
    install -d ${D}${sysconfdir}/plymouth
    install -m 0644 ${UNPACKDIR}/plymouthd.conf ${D}${sysconfdir}/plymouth/
}
