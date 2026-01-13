SUMMARY = "Unit systemd packages"

inherit packagegroup

RDEPENDS:${PN}:append = " systemd-analyze"
RDEPENDS:${PN}:append = " systemd-conf-journal-persistent-storage"
