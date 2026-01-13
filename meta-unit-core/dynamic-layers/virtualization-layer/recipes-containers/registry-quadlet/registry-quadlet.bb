SUMMARY = "Registry quadlet"
DESCRIPTION = "A quadlet for a registry container that runs rootful"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=136e4f49dbf29942c572a3a8f6e88a77"

SRC_URI = "\
    file://registry.container \
    file://LICENSE \
"

RDEPENDS:${PN}:append = " systemd-regkeygen"

S = "${UNPACKDIR}"

do_install() {
    install -D -p -m 0644 ${UNPACKDIR}/registry.container ${D}${sysconfdir}/containers/systemd/registry.container
}

FILES:${PN} = "${sysconfdir}/containers/systemd/registry.container"
