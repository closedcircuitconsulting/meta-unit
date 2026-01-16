SUMMARY = "Pubd kube"
DESCRIPTION = "A kube for running a multi-container application (pubsub) that runs rootless"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

SRC_URI = "\
    file://pubd.kube \
    file://pubsubd.yml \
"

RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " add-user-svc"

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
