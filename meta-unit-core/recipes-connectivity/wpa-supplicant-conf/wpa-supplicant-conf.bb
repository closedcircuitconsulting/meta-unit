SUMMARY = "Wi-Fi Protected Access (WPA) configuration"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

SRC_URI = "\
    file://wpa_supplicant.conf-wlan0 \
"

S = "${UNPACKDIR}"

WIFI_SSID ??= ""
WIFI_PSK ??= ""

python () {
    if not d.getVar('WIFI_SSID') or not d.getVar('WIFI_PSK'):
        bb.fatal("WIFI_SSID and WIFI_PSK must be set")
}

do_install() {
    install -d ${D}${sysconfdir}/wpa_supplicant
    install -m 0600 ${UNPACKDIR}/wpa_supplicant.conf-wlan0 ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf

    # Do variable substitution for wifi info
    sed -i 's|@@WIFI_SSID@@|${WIFI_SSID}|g' ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
    sed -i 's|@@WIFI_PSK@@|${WIFI_PSK}|g' ${D}${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf
}

FILES:${PN} = "\
    ${sysconfdir}/wpa_supplicant/wpa_supplicant-wlan0.conf \
"

# Exclude wifi info from sstate and stamps
do_install[vardepsexclude] += "WIFI_SSID"
do_install[vardepsexclude] += "WIFI_PSK"
do_install[nostamp] = "1"
