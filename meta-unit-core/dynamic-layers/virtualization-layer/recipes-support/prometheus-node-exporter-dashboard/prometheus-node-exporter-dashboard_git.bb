SUMMARY = "Node exporter grafana dashboard"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab0ea9d34dd9846f799c0fc52e5c58a"

SRC_URI = "git://github.com/rfmoz/grafana-dashboards;branch=master;protocol=https"

SRCREV = "0ea0f0652e41f73bd41b82769baa32912184152b"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -m 0644 ${S}/prometheus/node-exporter-full.json ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/dashboards/prometheus-node-exporter.json
}

FILES:${PN} = "/home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/dashboards/prometheus-node-exporter.json"
