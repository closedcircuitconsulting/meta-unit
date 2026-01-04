# Enable rootless containers.
PACKAGECONFIG:append = " rootless"

# Don't build and install docker wrapper.
PODMAN_FEATURES:remove = "docker"
