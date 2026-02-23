SUMMARY = "Prometheus node exporter quadlet"
DESCRIPTION = "A quadlet for a prometheus node exporter container that runs rootless"
LICENSE  = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "\
    file://prometheus-node-exporter.container \
    file://LICENSE \
    file://prometheus-target.yml \
"

RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " add-user-svc"

S = "${UNPACKDIR}"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -p -m 0644 ${UNPACKDIR}/prometheus-node-exporter.container ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/systemd/prometheus-node-exporter.container
    install -D -m 0644 ${UNPACKDIR}/prometheus-target.yml ${D}${sysconfdir}/prometheus/targets.d/node-exporter.yml
}

FILES:${PN} = "\
    /home/${ROOTLESS_USER_NAME}/.config/containers/systemd/prometheus-node-exporter.container \
    ${sysconfdir}/prometheus/targets.d/node-exporter.yml \
"
