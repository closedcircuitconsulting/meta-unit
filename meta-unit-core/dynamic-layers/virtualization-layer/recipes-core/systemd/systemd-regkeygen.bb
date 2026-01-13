SUMMARY = "Systemd service for generating TLS key and cert for local registry"
SECTION = "core"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SYSTEMD_SERVICE:${PN} = "regkeygen.service"

SRC_URI = "\
    file://regkeygen.service \
    file://regkeygen.sh \
"

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
