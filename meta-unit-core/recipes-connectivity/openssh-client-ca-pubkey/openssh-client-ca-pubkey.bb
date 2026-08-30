SUMMARY = "Add SSH client CA public key"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

SRC_URI = "file://ssh-client-ca.pub"

S = "${UNPACKDIR}"

do_install() {
    install -D -m 0644 ${UNPACKDIR}/ssh-client-ca.pub ${D}${sysconfdir}/ssh/ssh-client-ca.pub
}

FILES:${PN} = "${sysconfdir}/ssh/ssh-client-ca.pub"
