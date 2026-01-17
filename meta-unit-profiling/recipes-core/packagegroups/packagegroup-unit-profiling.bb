SUMMARY = "Profiling packages"
LICENSE = "MIT"

inherit packagegroup

# Performance analysis
RDEPENDS:${PN}:append = " procps"
RDEPENDS:${PN}:append = " sysstat"

# Performance testing
RDEPENDS:${PN}:append = " stress-ng"
