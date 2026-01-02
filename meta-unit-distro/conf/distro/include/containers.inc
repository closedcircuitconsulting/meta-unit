require conf/distro/include/meta-virt-container-podman.inc

DISTRO_FEATURES:append = " virtualization"
DISTRO_FEATURES:append = " pam"

VIRTUAL-RUNTIME_dbus = "dbus-broker"
