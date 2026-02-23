SUMMARY = "Grafana prometheus data source drop-in"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_VIRTUALIZATION_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SRC_URI = "file://datasource.yml"

ROOTLESS_USER_NAME ?= "svc"

S = "${UNPACKDIR}"

do_install() {
    install -D -m 0644 ${S}/datasource.yml ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/datasources/prometheus.yml
}

FILES:${PN} = "/home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/datasources/prometheus.yml"
