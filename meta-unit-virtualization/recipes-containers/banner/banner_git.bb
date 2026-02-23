SUMMARY = "Banner application files"
DESCRIPTION = "Supporting files for a banner container that runs rootless"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SRC_URI = "\
    git://git.closedcircuitconsulting.com/banner-rs;branch=main;protocol=https \
"

SRCREV = "1176c69b629cb3ba045a2854ddb2a06a6f518cc3"

PV = "0.1.0"

RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " add-user-svc"

S = "${UNPACKDIR}/${PN}-${PV}"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -m 0644 ${S}/banner.container ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/systemd/banner.container
}

FILES:${PN} = "\
    /home/${ROOTLESS_USER_NAME}/.config/containers/systemd/banner.container \
"
