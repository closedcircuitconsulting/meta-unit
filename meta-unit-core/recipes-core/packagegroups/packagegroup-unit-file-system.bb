SUMMARY = "Unit file system packages"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS:${PN}:append = " fuse3"
