SUMMARY = "Unit touch input packages"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN}:append = " evtest"
RDEPENDS:${PN}:append = " libinput-bin"
