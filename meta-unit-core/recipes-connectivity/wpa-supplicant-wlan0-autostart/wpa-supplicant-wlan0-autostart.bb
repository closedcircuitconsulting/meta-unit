SUMMARY = "Wi-Fi Protected Access (WPA) service auto-enable"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

do_install() {
    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants
    ln -sf ${systemd_system_unitdir}/wpa_supplicant@.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service
}

FILES:${PN} = "\
    ${sysconfdir}/systemd/system/multi-user.target.wants/wpa_supplicant@wlan0.service \
"

RDEPENDS:${PN} = "\
    wpa-supplicant \
    wpa-supplicant-conf \
"
