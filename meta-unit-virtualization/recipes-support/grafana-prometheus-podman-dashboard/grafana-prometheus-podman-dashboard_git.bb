SUMMARY = "Podman exporter grafana dashboard"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e647d8f671db610bae37c03003d77b7e"

SRC_URI = "git://git.closedcircuitconsulting.com/grafana-prometheus-podman-dashboard;branch=main;protocol=https"

SRCREV = "ae0f243eda1b57ca73ef5c87032287fe8cf46ae3"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -m 0644 ${S}/podman.json ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/dashboards/podman-exporter.json
}

FILES:${PN} = "/home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/dashboards/podman-exporter.json"
