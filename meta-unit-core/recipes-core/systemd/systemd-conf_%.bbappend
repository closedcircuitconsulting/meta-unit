FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

PACKAGECONFIG:append = " ${@bb.utils.contains('DISTRO_FEATURES', 'prefer-static-ethernet', 'static-ethernet', 'dhcp-ethernet', d)}"
PACKAGECONFIG[static-ethernet] = ""

PACKAGECONFIG:append = " timesyncd"
PACKAGECONFIG[timesyncd] = ""

SRC_URI:append = " \
    file://wired-static.network \
    file://static-ntp-server.conf \
    file://journald-persistent-storage.conf \
"

# Make priority higher (lower) than the priority of the wired.network being provided by openembedded-core
WIRED_STATIC_DROP_IN_PRIORITY ??= "75"

# No other configs to compete with for this so arbitrary
NTP_SERVER_DROP_IN_PRIORITY ??= "10"

# No other configs to compete with for this so arbitrary
JOURNAL_PERSISTANT_STORAGE_DROP_IN_PRIORITY ??= "10"

SELF_STATIC_IP_ADDRESS ??= "10.1.70.1/24"

NTP_SERVER_STATIC_IP_ADDRESS ??= "10.1.70.2"

do_install:append() {
    # Apply changes for static ethernet if it is being preferred over DHCP
    if ${@bb.utils.contains('PACKAGECONFIG', 'static-ethernet', 'true', 'false', d)}; then
        install -D -m0644 ${S}/wired-static.network ${D}${systemd_unitdir}/network/75-wired-static.network

        # Do variable substitution for static IPv4 address
        sed -i 's|@@STATIC_IP_ADDRESS@@|${SELF_STATIC_IP_ADDRESS}|g' ${D}${systemd_unitdir}/network/75-wired-static.network

        # Customize timesyncd behavior if enabled
        if ${@bb.utils.contains('PACKAGECONFIG', 'timesyncd', 'true', 'false', d)}; then
            # With static network, need a way to get time otherwise certificate expiry cant be known without setting manually
            install -D -m 0644 ${UNPACKDIR}/static-ntp-server.conf ${D}${systemd_unitdir}/timesyncd.conf.d/${NTP_SERVER_DROP_IN_PRIORITY}-static-ntp-server.conf

            # Do variable substitution for NTP server static IPv4 address
            sed -i 's|@@NTP_SERVER_STATIC_IP_ADDRESS@@|${NTP_SERVER_STATIC_IP_ADDRESS}|g' ${D}${systemd_unitdir}/timesyncd.conf.d/${NTP_SERVER_DROP_IN_PRIORITY}-static-ntp-server.conf
        fi
    fi

    # Customize journal behavior
    install -D -m 0644 ${UNPACKDIR}/journald-persistent-storage.conf ${D}${systemd_unitdir}/journald.conf.d/${JOURNAL_PERSISTANT_STORAGE_DROP_IN_PRIORITY}-journald-persistent-storage.conf
}

FILES:${PN}:append = " \
    ${systemd_unitdir}/timesyncd.conf.d/ \
"
