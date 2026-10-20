SUMMARY = "Unit debugging packages"

PACKAGE_ARCH = "${TUNE_PKGARCH}"

inherit packagegroup

RDEPENDS:${PN}:append = " gdbserver"
RDEPENDS:${PN}:append = " devmem2"
