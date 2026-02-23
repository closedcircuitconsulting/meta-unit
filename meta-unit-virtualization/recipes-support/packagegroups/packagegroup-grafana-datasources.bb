SUMMARY = "Grafana provisioning data sources"

inherit packagegroup

RDEPENDS:${PN}:append = " grafana-prometheus-datasource"
