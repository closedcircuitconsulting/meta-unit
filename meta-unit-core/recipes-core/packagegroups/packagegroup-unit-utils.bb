SUMMARY = "Unit utility packages"

inherit packagegroup

RDEPENDS:${PN}:append = " jq"
RDEPENDS:${PN}:append = " tree"
