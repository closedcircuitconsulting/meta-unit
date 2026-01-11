SUMMARY = "Add unitexe user"
LICENSE = "MIT"

EXCLUDE_FROM_WORLD = "1"

inherit useradd
inherit extrausers

S = "${UNPACKDIR}"

RDEPENDS:${PN}:append = " sudo"
RDEPENDS:${PN}:append = " shadow"
RDEPENDS:${PN}:append = " ssh-authorized-keys"

USERADD_PACKAGES = "${PN}"

USER_TO_ADD_NAME ?= "unitexe"
USER_TO_ADD_UID ?= "1000"
USER_TO_ADD_PASSWORD_HASHED ?= "\$6\$esHchcEKubkj/1v7\$woeV0ChUqcC8J8lOEWB563mX4XRAvYJldGcU/I0Pzg1Nw9bBGOQoLmIsn0wU1gUzpysZr6R18xps5Cjn470Nv/"

USERADD_PARAM:${PN} = "--uid ${USER_TO_ADD_UID} --home-dir /home/${USER_TO_ADD_NAME} --shell ${base_bindir}/sh --password '${USER_TO_ADD_PASSWORD_HASHED}' ${USER_TO_ADD_NAME}"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
