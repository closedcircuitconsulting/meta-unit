SUMMARY = "Unit quadlet packages"

inherit packagegroup

RDEPENDS:${PN}:append = " banner-quadlet"
RDEPENDS:${PN}:append = " registry-quadlet"
