SUMMARY = "Grafana prometheus data source drop-in"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

SRC_URI = "file://datasource.yml"

ROOTLESS_USER_NAME ?= "svc"

S = "${UNPACKDIR}"

do_install() {
    install -D -m 0644 ${S}/datasource.yml ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/datasources/prometheus.yml
}

FILES:${PN} = "/home/${ROOTLESS_USER_NAME}/.config/containers/grafana/provisioning/datasources/prometheus.yml"
