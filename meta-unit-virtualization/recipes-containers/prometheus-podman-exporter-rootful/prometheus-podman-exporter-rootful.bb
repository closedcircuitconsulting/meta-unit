SUMMARY = "Prometheus podman exporter quadlet"
DESCRIPTION = "A quadlet for a prometheus podman exporter container that runs rootful"
LICENSE  = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "\
    file://prometheus-podman-exporter.container \
    file://LICENSE \
    file://prometheus-target.yml \
"

RDEPENDS:${PN}:append = " podman"

S = "${UNPACKDIR}"

do_install() {
    install -D -p -m 0644 ${UNPACKDIR}/prometheus-podman-exporter.container ${D}${sysconfdir}/containers/systemd/prometheus-podman-exporter.container
    install -D -m 0644 ${UNPACKDIR}/prometheus-target.yml ${D}${sysconfdir}/prometheus/targets.d/podman-rootful.yml
}

FILES:${PN} = "\
    ${sysconfdir}/containers/systemd/prometheus-podman-exporter.container \
    ${sysconfdir}/prometheus/targets.d/podman-rootful.yml \
"
