SUMMARY = "Grafana provisioning dashboards"

inherit packagegroup

RDEPENDS:${PN}:append = " prometheus-node-exporter-dashboard"
RDEPENDS:${PN}:append = " grafana-prometheus-podman-dashboard"
