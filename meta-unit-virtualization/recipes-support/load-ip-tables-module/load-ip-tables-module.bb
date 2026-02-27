SUMMARY = "Modules load drop-in configuration for ip tables module"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_VIRTUALIZATION_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SRC_URI = "file://ip_tables.conf"

S = "${UNPACKDIR}"

do_install() {
    install -D -m 0644 ${S}/ip_tables.conf ${D}${sysconfdir}/modules-load.d/ip_tables.conf
}

FILES:${PN} = "${sysconfdir}/modules-load.d/ip_tables.conf"
