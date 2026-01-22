SUMMARY = "Distribution quadlet"
DESCRIPTION = "A quadlet for a distribution container that runs rootless"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${UNPACKDIR}/LICENSE;md5=d2794c0df5b907fdace235a619d80314"

SRC_URI = "\
    file://config.yml \
    file://distribution.container \
    file://prometheus-target.yml \
    file://LICENSE \
"

RDEPENDS:${PN}:append = " systemd-regkeygen"
RDEPENDS:${PN}:append = " podman"
RDEPENDS:${PN}:append = " add-user-svc"

S = "${UNPACKDIR}"

ROOTLESS_USER_NAME ?= "svc"

do_install() {
    install -D -p -m 0644 ${UNPACKDIR}/distribution.container ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/systemd/distribution.container
    install -D -p -m 0644 ${UNPACKDIR}/config.yml ${D}/home/${ROOTLESS_USER_NAME}/.config/containers/distribution/config.yml
    install -D -m 0644 ${UNPACKDIR}/prometheus-target.yml ${D}${sysconfdir}/prometheus/targets.d/distribution.yml
}

FILES:${PN} = "\
    /home/${ROOTLESS_USER_NAME}/.config/containers/systemd/distribution.container \
    /home/${ROOTLESS_USER_NAME}/.config/containers/distribution/config.yml \
    ${sysconfdir}/prometheus/targets.d/distribution.yml \
"
