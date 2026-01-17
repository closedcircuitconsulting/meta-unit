SUMMARY = "Systemd bootchart config drop-in"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_PROFILING_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SRC_URI = "file://unit.conf"

S = "${UNPACKDIR}"

do_install() {
    install -D -p -m0644 ${UNPACKDIR}/unit.conf ${D}${sysconfdir}/systemd/bootchart.conf.d/unit.conf
}

FILES:${PN} = "${sysconfdir}/systemd/bootchart.conf.d/unit.conf"
