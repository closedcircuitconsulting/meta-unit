SUMMARY = "Systemd path unit to wait for TLS key and cert generation for distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

inherit systemd

SRC_URI = "\
    file://distribution.path \
"

RDEPENDS:${PN}:append = " add-user-svc"
RDEPENDS:${PN}:append = " systemd-regkeygen"

S = "${UNPACKDIR}"

SYSTEMD_USER = "svc"
SYSTEMD_USER_UNITDIR = "/home/${SYSTEMD_USER}/.config/systemd/user"

do_install() {
    install -D -p -m0644 ${UNPACKDIR}/distribution.path ${D}${SYSTEMD_USER_UNITDIR}/distribution.path
    
    # Auto-enable systemd unit by creating the appropriate symlink
    install -d ${D}${SYSTEMD_USER_UNITDIR}/default.target.wants
    ln -sf ${SYSTEMD_USER_UNITDIR}/distribution.path ${D}${SYSTEMD_USER_UNITDIR}/default.target.wants/distribution.path
}

FILES:${PN} = "\
    ${SYSTEMD_USER_UNITDIR}/distribution.path \
    ${SYSTEMD_USER_UNITDIR}/default.target.wants/distribution.path \
"
