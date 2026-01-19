SUMMARY = "Prometheus quadlet"
DESCRIPTION = "A quadlet for a prometheus container that runs rootless"
LICENSE  = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "\
    file://prometheus.container \
    file://LICENSE \
    file://prometheus.yml \
"

RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " add-user-svc"

S = "${UNPACKDIR}"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -p -m 0644 ${UNPACKDIR}/prometheus.container ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/systemd/prometheus.container
    install -D -p -m 0644 ${UNPACKDIR}/prometheus.yml ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/prometheus/prometheus.yml
}

FILES:${PN} = "\
    /home/${ROOTLESS_USER_NAME}/.config/containers/systemd/prometheus.container \
    /home/${ROOTLESS_USER_NAME}/.config/containers/prometheus/prometheus.yml \
"
