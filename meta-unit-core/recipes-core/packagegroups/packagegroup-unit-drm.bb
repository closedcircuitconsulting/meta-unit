SUMMARY = "Unit DRM packages"

inherit packagegroup

RDEPENDS:${PN}:append = " libdrm-tests"
