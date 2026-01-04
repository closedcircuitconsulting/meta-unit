# Enable rootless containers.
PACKAGECONFIG:append = " rootless"

# Don't build and install docker wrapper.
PODMAN_FEATURES:remove = "docker"

# Update PACKAGECONFIG to use pasta instead of slirp4netns.
# Pasta is the default network driver since Podman 5.0.0.
PACKAGECONFIG[rootless] = ",,,fuse-overlayfs passt,,"

# Update default_rootless_network_cmd to use pasta instead
# of slirp4netns. Again, Pasta is the default network driver
# since Podman 5.0.0.
do_install:append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'rootless', 'true', 'false', d)}; then
        sed -i 's/slirp4netns/pasta/' ${D}${sysconfdir}/containers/containers.conf
    fi
}
