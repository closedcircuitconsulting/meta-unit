SUMMARY = "Systemd service for generating TLS key and cert for distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_VIRTUALIZATION_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

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
