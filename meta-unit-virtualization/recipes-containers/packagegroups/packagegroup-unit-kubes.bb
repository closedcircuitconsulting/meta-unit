SUMMARY = "Unit kube packages"

inherit packagegroup

RDEPENDS:${PN}:append = " pubd-kube"
