SUMMARY = "Unit users"

inherit packagegroup

# TTY root login restriction, among other things.
# Is needed for rootless containers too.
RDEPENDS:${PN}:append = " libpam"

# Add admin user.
RDEPENDS:${PN}:append = " add-user-unitexe"

# Add service user.
RDEPENDS:${PN}:append = " add-user-svc"
