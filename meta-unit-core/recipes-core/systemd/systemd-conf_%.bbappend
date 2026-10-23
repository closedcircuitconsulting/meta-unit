FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG = "${@bb.utils.contains('DISTRO_FEATURES', 'prefer-static-ethernet', 'static-ethernet', 'dhcp-ethernet', d)}"
PACKAGECONFIG[static-ethernet] = ""

SRC_URI:append = " \
    file://wired-static.network \
"

ASSIGNED_STATIC_IP_ADDRESS ??= "10.1.70.1/24"

do_install:append() {
    if ${@bb.utils.contains('PACKAGECONFIG', 'static-ethernet', 'true', 'false', d)}; then
        # Make priority over the wired.network provided by openembedded-core
        install -D -m0644 ${S}/wired-static.network ${D}${systemd_unitdir}/network/75-wired-static.network

        # Do variable substitution for static IPv4 address
        sed -i 's|@@STATIC_IP_ADDRESS@@|${ASSIGNED_STATIC_IP_ADDRESS}|g' ${D}${systemd_unitdir}/network/75-wired-static.network
    fi
}
