SUMMARY = "Systemd journal persistent storage drop-in configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

SRC_URI = "file://journald-persistent-storage.conf"

RDEPENDS:${PN}:append = " systemd"

S = "${UNPACKDIR}"

do_install:append() {
    install -D -m 0644 ${UNPACKDIR}/journald-persistent-storage.conf ${D}${sysconfdir}/systemd/journald.conf.d/journald-persistent-storage.conf
}

FILES:${PN} = "\
    ${sysconfdir}/systemd/journald.conf.d/journald-persistent-storage.conf \
"
