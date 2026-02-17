SUMMARY = "Initramfs module for Plymouth boot splash"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

RDEPENDS:${PN} = "\
    plymouth \
    plymouth-initrd \
    plymouth-themes \
    initramfs-framework-base \
"

SRC_URI = "file://plymouth"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}/init.d
    install -m 0755 ${UNPACKDIR}/plymouth ${D}/init.d/03-plymouth
}

FILES:${PN} = "/init.d/03-plymouth"
