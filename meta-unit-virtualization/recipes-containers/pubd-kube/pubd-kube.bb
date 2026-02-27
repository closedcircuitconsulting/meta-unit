SUMMARY = "Pubd kube"
DESCRIPTION = "A kube for running a multi-container application (pubsub) that runs rootless"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_VIRTUALIZATION_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SRC_URI = "\
    file://pubd.kube \
    file://pubsubd.yml \
"

RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " add-user-svc"
RDEPENDS:${PN}:append = " pubd"
RDEPENDS:${PN}:append = " load-ip-tables-module"

S = "${UNPACKDIR}"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -m 0644 ${UNPACKDIR}/pubd.kube ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/systemd/pubd.kube
    install -D -m 0644 ${UNPACKDIR}/pubsubd.yml ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/kube/pubsubd.yml
}

FILES:${PN} = "\
    /home/${ROOTLESS_USER_NAME}/.config/containers/systemd/pubd.kube \
    /home/${ROOTLESS_USER_NAME}/.config/containers/kube/pubsubd.yml \
"
