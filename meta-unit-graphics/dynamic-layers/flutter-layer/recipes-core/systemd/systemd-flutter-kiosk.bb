SUMMARY = "Systemd service for launching kiosk application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_GRAPHICS_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

inherit systemd

require conf/include/flutter-version.inc

SRC_URI = "\
    file://kiosk.service \
    file://kiosk.path \
"

RDEPENDS:${PN}:append = " flutter-sample-no-material"
RDEPENDS:${PN}:append = " ivi-homescreen"
RDEPENDS:${PN}:append = " weston"
RDEPENDS:${PN}:append = " weston-init"
RDEPENDS:${PN}:append = " add-user-kiosk"
RDEPENDS:${PN}:append = " systemd-weston-signal"

S = "${UNPACKDIR}"

SYSTEMD_USER = "kiosk"
SYSTEMD_USER_UNITDIR = "/home/${SYSTEMD_USER}/.config/systemd/user"

do_install() {
    install -D -m0644 ${S}/kiosk.path ${D}${SYSTEMD_USER_UNITDIR}/kiosk.path
    install -D -m0644 ${S}/kiosk.service ${D}${SYSTEMD_USER_UNITDIR}/kiosk.service

    # Variable substitution.
    sed -i 's|@@FLUTTER_SDK_TAG@@|${FLUTTER_SDK_TAG}|g' ${D}${SYSTEMD_USER_UNITDIR}/kiosk.service
    sed -i 's|@@KIOSK_APPLICATION_NAME@@|flutter_sample_no_material|g' ${D}${SYSTEMD_USER_UNITDIR}/kiosk.service
    
    # Auto-enable systemd unit by creating the appropriate symlink
    install -d ${D}${SYSTEMD_USER_UNITDIR}/default.target.wants
    ln -sf ${SYSTEMD_USER_UNITDIR}/kiosk.path ${D}${SYSTEMD_USER_UNITDIR}/default.target.wants/kiosk.path
    ln -sf ${SYSTEMD_USER_UNITDIR}/kiosk.service ${D}${SYSTEMD_USER_UNITDIR}/default.target.wants/kiosk.service
}

FILES:${PN} = "\
    ${SYSTEMD_USER_UNITDIR}/kiosk.path \
    ${SYSTEMD_USER_UNITDIR}/kiosk.service \
    ${SYSTEMD_USER_UNITDIR}/default.target.wants/kiosk.path \
    ${SYSTEMD_USER_UNITDIR}/default.target.wants/kiosk.service \
"
