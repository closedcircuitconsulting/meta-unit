SUMMARY = "Unit networking packages"

inherit packagegroup

RDEPENDS:${PN}:append = " curl"
RDEPENDS:${PN}:append = " openssh"
RDEPENDS:${PN}:append = " openssh-client-ca-pubkey"
RDEPENDS:${PN}:append = " socat"
