SUMMARY = "Unit quadlet packages"

inherit packagegroup

RDEPENDS:${PN}:append = " banner"
RDEPENDS:${PN}:append = " distribution"
RDEPENDS:${PN}:append = " prometheus"
RDEPENDS:${PN}:append = " prometheus-podman-exporter-rootful"
RDEPENDS:${PN}:append = " prometheus-podman-exporter-rootless"
RDEPENDS:${PN}:append = " prometheus-node-exporter"
RDEPENDS:${PN}:append = " grafana"
