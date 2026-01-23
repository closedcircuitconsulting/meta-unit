SUMMARY = "Grafana provisionining support files"

inherit packagegroup

RDEPENDS:${PN}:append = " prometheus-node-exporter-dashboard"
