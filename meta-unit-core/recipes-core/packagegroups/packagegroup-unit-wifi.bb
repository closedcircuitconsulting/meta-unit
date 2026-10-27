SUMMARY = "Unit wifi packages"

inherit packagegroup

RDEPENDS:${PN}:append = " wpa-supplicant-wlan0-autostart"

RDEPENDS:${PN}:append:pine64-pinephone-braveheart = " kernel-module-rtw88-8723cs"
RDEPENDS:${PN}:append:pine64-pinephone-braveheart = " linux-firmware-rtl8703"
