SUMMARY = "Container packages"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

# A number of kernel modules are needed for this to work
RDEPENDS:${PN}:append = " kernel-modules"

# Rootless containers
RDEPENDS:${PN}:append = " dbus-broker"
RDEPENDS:${PN}:append = " libpam"

# Networking
RDEPENDS:${PN}:append = " iproute2"
RDEPENDS:${PN}:append = " passt"

# Podman
RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " podman-tui"
RDEPENDS:${PN}:append = " podman-compose"

# Working with registries
RDEPENDS:${PN}:append = " skopeo"

# Working with container images
RDEPENDS:${PN}:append = " umoci"
