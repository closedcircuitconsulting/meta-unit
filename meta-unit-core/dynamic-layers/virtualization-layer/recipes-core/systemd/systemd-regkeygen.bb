SUMMARY = "Systemd service for generating TLS key and cert for distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

inherit systemd

SRC_URI = "\
    file://regkeygen.service \
    file://regkeygen.sh \
"

RDEPENDS:${PN}:append = " add-user-svc"
RDEPENDS:${PN}:append = " openssl"

S = "${UNPACKDIR}"

SYSTEMD_USER = "svc"
SYSTEMD_USER_UNITDIR = "/home/${SYSTEMD_USER}/.config/systemd/user"
USER_BINDIR = "/home/${SYSTEMD_USER}/bin"

do_install() {
    install -D -p -m0644 ${UNPACKDIR}/regkeygen.service ${D}${SYSTEMD_USER_UNITDIR}/regkeygen.service
    install -D -p -m0755 ${UNPACKDIR}/regkeygen.sh ${D}${USER_BINDIR}/regkeygen.sh
    
    # Auto-enable systemd unit by creating the appropriate symlink
    install -d ${D}${SYSTEMD_USER_UNITDIR}/default.target.wants
    ln -sf ${SYSTEMD_USER_UNITDIR}/regkeygen.service ${D}${SYSTEMD_USER_UNITDIR}/default.target.wants/regkeygen.service
}

FILES:${PN} = "\
    ${SYSTEMD_USER_UNITDIR}/regkeygen.service \
    ${SYSTEMD_USER_UNITDIR}/default.target.wants/regkeygen.service \
    ${USER_BINDIR}/regkeygen.sh \
"
