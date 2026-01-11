#
# Support rootless podman for users.
#
# This is explained at:
#   https://github.com/containers/podman/blob/main/docs/tutorials/rootless_tutorial.md#etcsubuid-and-etcsubgid-configuration
#
do_install:append() {
    echo "unitexe:100000:65536" >> ${D}${sysconfdir}/subuid
    echo "" >> ${D}${sysconfdir}/subuid
    echo "unitexe:100000:65536" >> ${D}${sysconfdir}/subgid
    echo "" >> ${D}${sysconfdir}/subgid

    echo "svc:200000:65536" >> ${D}${sysconfdir}/subuid
    echo "" >> ${D}${sysconfdir}/subuid
    echo "svc:200000:65536" >> ${D}${sysconfdir}/subgid
    echo "" >> ${D}${sysconfdir}/subgid
}
