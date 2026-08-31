FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://netfilter-legacy-podman.cfg"

KERNEL_FEATURES:append = " features/namespaces/namespaces.cfg"
KERNEL_FEATURES:append = " features/cgroups/cgroups.cfg"
KERNEL_FEATURES:append = " features/netfilter/netfilter.cfg"
