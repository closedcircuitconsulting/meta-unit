SUMMARY = "Unit kiosk"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN}:append = " systemd-flutter-kiosk"
