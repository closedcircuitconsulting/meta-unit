SUMMARY = "Pubd protobuf files"
DESCRIPTION = "Protobuf files for pubd application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SRC_URI = "git://git.closedcircuitconsulting.com/pubd;branch=main;protocol=https"

SRCREV = "53dbe597ae5b46812fc98d1da059e08a7e73047c"

PV = "0.1.0"

RDEPENDS:${PN}:append = " add-user-svc"

S = "${UNPACKDIR}/${PN}-${PV}"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -m 0644 ${S}/proto/countah.proto ${D}/home/${ROOTLESS_USER_NAME}/.config/proto/pubd/countah.proto
}

FILES:${PN} = "/home/${ROOTLESS_USER_NAME}/.config/proto/pubd/countah.proto"
