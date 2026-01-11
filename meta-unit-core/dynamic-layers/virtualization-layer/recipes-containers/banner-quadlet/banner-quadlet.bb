SUMMARY = "Banner quadlet"
DESCRIPTION = "A quadlet for a banner container that runs rootless"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=a0e6886d263a557228f8d3c5bef21837"

SRC_URI = "\
    file://banner.container \
    file://LICENSE \
"

RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " add-user-svc"

S = "${UNPACKDIR}"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -m 0644 ${UNPACKDIR}/banner.container ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/systemd/banner.container
}

FILES:${PN} = "/home/${ROOTLESS_USER_NAME}/.config/containers/systemd/banner.container"
