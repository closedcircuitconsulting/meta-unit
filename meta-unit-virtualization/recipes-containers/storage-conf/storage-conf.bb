SUMMARY = "Container storage configuration for rootless containers"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_VIRTUALIZATION_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SRC_URI = "file://storage.conf"

RDEPENDS:${PN} = "add-user-svc"

ROOTLESS_USER_NAME ?= "svc"

S = "${UNPACKDIR}"

do_install() {
    install -D -m 0644 ${S}/storage.conf ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/storage.conf
}

FILES:${PN} = "/home/${ROOTLESS_USER_NAME}/.config/containers/storage.conf"
