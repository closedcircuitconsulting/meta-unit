SUMMARY = "Grafana quadlet"
DESCRIPTION = "A quadlet for a grafana container that runs rootless"
LICENSE = "AGPL-3.0-only"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=eb1e647870add0502f8f010b19de32af"

SRC_URI = "\
    file://grafana.container \
    file://dashboard.yml \
    file://LICENSE \
"

RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " add-user-svc"
RDEPENDS:${PN}:append = " packagegroup-grafana-dashboards"
RDEPENDS:${PN}:append = " packagegroup-grafana-datasources"

S = "${UNPACKDIR}"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -p -m 0644 ${UNPACKDIR}/grafana.container ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/systemd/grafana.container
    install -D -p -m 0644 ${UNPACKDIR}/dashboard.yml ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/dashboards/dashboard.yml
}

FILES:${PN} = "\
    /home/${ROOTLESS_USER_NAME}/.config/containers/systemd/grafana.container \
    /home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/dashboards/dashboard.yml \
"
