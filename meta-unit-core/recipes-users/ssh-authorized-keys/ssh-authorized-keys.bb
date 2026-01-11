SUMMARY = "Add authorized SSH keys for unitexe user"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

SRC_URI = "file://authorized_keys"

S = "${UNPACKDIR}"

USER_NAME = "unitexe"

do_install() {
    install -D -m 0600 ${UNPACKDIR}/authorized_keys ${D}/home/${USER_NAME}/.ssh/authorized_keys
}

FILES:${PN} = "/home/${USER_NAME}/.ssh/authorized_keys"
