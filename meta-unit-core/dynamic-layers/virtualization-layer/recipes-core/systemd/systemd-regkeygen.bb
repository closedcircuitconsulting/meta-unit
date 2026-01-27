SUMMARY = "Systemd service for generating TLS key and cert for distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

SYSTEMD_SERVICE:${PN} = "regkeygen.service"

SRC_URI = "\
    file://regkeygen.service \
    file://regkeygen.sh \
"

RDEPENDS:${PN}:append = " add-user-svc"

S = "${UNPACKDIR}"

do_install() {
    install -D -p -m0644 ${UNPACKDIR}/regkeygen.service ${D}${systemd_system_unitdir}/regkeygen.service
    install -D -p -m0755 ${UNPACKDIR}/regkeygen.sh ${D}${bindir}/regkeygen.sh
}

inherit systemd

FILES:${PN} = "\
    ${systemd_system_unitdir} \
    ${bindir} \
"

RDEPENDS:${PN} = "\
    openssl \
    ca-certificates \
"
