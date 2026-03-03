SUMMARY = "Initramfs module for settle after showing plymouth boot splash"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

RDEPENDS:${PN} = "\
    initramfs-framework-base \
    initramfs-module-plymouth \
"

SRC_URI = "file://plymouthsettle"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}/init.d
    install -m 0755 ${UNPACKDIR}/plymouthsettle ${D}/init.d/04-plymouthsettle
}

FILES:${PN} = "/init.d/04-plymouthsettle"
