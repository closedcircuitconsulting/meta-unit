SUMMARY = "Unit system packages"

inherit packagegroup

RDEPENDS:${PN}:append = " kernel-modules"

# The preferred default for unit images (is also default for arch).
# Provides high performance and reliability while being drop in 
# compatible.
RDEPENDS:${PN}:append = " dbus-broker"
