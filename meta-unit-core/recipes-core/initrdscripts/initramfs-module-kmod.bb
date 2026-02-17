SUMMARY = "Initramfs module for loading kernel modules"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

RDEPENDS:${PN} = "initramfs-framework-base"

SRC_URI = "file://kmod"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}/init.d
    install -m 0755 ${UNPACKDIR}/kmod ${D}/init.d/01-kmod
}

FILES:${PN} = "/init.d/01-kmod"
