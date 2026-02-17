SUMMARY = "Unit kiosk"

inherit packagegroup

RDEPENDS:${PN}:append = " u-boot-splash"
RDEPENDS:${PN}:append = " plymouth-quit-conf"
