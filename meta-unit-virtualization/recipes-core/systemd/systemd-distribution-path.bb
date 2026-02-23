SUMMARY = "Systemd path unit to wait for TLS key and cert generation for distribution"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_VIRTUALIZATION_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

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
