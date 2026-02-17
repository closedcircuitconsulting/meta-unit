SUMMARY = "Systemd service for notifying kiosk user that weston is ready"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_GRAPHICS_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SYSTEMD_SERVICE:${PN} = "weston-ready.service"

SRC_URI = "\
    file://weston-ready.service \
"

RDEPENDS:${PN} = "\
    add-user-kiosk \
    weston \
"

S = "${UNPACKDIR}"

do_install() {
    install -D -p -m0644 ${S}/weston-ready.service ${D}${systemd_system_unitdir}/weston-ready.service
}

inherit systemd

FILES:${PN} = "\
    ${systemd_system_unitdir}/weston-ready.service \
"
