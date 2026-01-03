SUMMARY = "Add unitexe user"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_CORE_LAYERDIR}/LICENSE;md5=38bf13be5d6979b28bd8adddb2f2f9b3"

EXCLUDE_FROM_WORLD = "1"

inherit useradd
inherit extrausers

SRC_URI = "file://authorized_keys"

S = "${UNPACKDIR}"

RDEPENDS:${PN}:append = " sudo"
RDEPENDS:${PN}:append = " shadow"

USERADD_PACKAGES = "${PN}"

USER_TO_ADD_NAME ?= "unitexe"
USER_TO_ADD_UID ?= "1000"
USER_TO_ADD_PASSWORD_HASHED ?= "\$6\$esHchcEKubkj/1v7\$woeV0ChUqcC8J8lOEWB563mX4XRAvYJldGcU/I0Pzg1Nw9bBGOQoLmIsn0wU1gUzpysZr6R18xps5Cjn470Nv/"

USERADD_PARAM:${PN} = "--uid ${USER_TO_ADD_UID} --home-dir /home/${USER_TO_ADD_NAME} --shell ${base_bindir}/sh --password '${USER_TO_ADD_PASSWORD_HASHED}' ${USER_TO_ADD_NAME}"

do_install() {
    # Give the user a home directory.
    install -d -m 0755 ${D}/home/${USER_TO_ADD_NAME}

    # Create .ssh directory.
    install -d -m 0700 ${D}/home/${USER_TO_ADD_NAME}/.ssh

    # Create authorized keys file.
    install -m 0600 ${UNPACKDIR}/authorized_keys ${D}/home/${USER_TO_ADD_NAME}/.ssh/authorized_keys
}

pkg_postinst_ontarget:${PN}() {
    chown -R ${USER_TO_ADD_NAME}:${USER_TO_ADD_NAME} /home/${USER_TO_ADD_NAME}
}

FILES:${PN} = "\
    /home/${USER_TO_ADD_NAME} \
    /home/${USER_TO_ADD_NAME}/.ssh/authorized_keys \
"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
