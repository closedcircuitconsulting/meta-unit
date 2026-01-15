SUMMARY = "Unit quadlet packages"

inherit packagegroup

RDEPENDS:${PN}:append = " banner"
RDEPENDS:${PN}:append = " registry-quadlet"
