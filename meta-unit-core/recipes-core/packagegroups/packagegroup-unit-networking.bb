SUMMARY = "Unit networking packages"

inherit packagegroup

RDEPENDS:${PN}:append = " curl"
RDEPENDS:${PN}:append = " openssh"
