SUMMARY = "Plymouth drop-in service configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

RDEPENDS:${PN} = "\
    plymouth \
    systemd-weston-signal \
"

SRC_URI = "\
    file://weston.conf \
"

S = "${UNPACKDIR}"

do_install() {
    install -d ${D}${systemd_system_unitdir}/plymouth-quit.service.d
    install -m 0644 ${S}/weston.conf ${D}${systemd_system_unitdir}/plymouth-quit.service.d/weston.conf
}

FILES:${PN} = "\
    ${systemd_system_unitdir}/plymouth-quit.service.d/weston.conf \
"
