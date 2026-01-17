SUMMARY = "Systemd profiling packages"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN}:append = " systemd-bootchart"
RDEPENDS:${PN}:append = " systemd-bootchart-conf"
RDEPENDS:${PN}:append = " systemd-analyze"
