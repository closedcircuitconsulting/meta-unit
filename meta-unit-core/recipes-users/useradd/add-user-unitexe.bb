SUMMARY = "Add unitexe user"
LICENSE = "MIT"

EXCLUDE_FROM_WORLD = "1"

inherit useradd
inherit extrausers

RDEPENDS:${PN}:append = " base-passwd"
RDEPENDS:${PN}:append = " busybox"
RDEPENDS:${PN}:append = " sudo"
RDEPENDS:${PN}:append = " shadow"
RDEPENDS:${PN}:append = " ssh-authorized-keys"
RDEPENDS:${PN}:append = " systemd"

USERADD_PACKAGES = "${PN}"

USER_TO_ADD_NAME ?= "unitexe"
USER_TO_ADD_UID ?= "1000"
USER_TO_ADD_PASSWORD_HASHED ?= "\$6\$esHchcEKubkj/1v7\$woeV0ChUqcC8J8lOEWB563mX4XRAvYJldGcU/I0Pzg1Nw9bBGOQoLmIsn0wU1gUzpysZr6R18xps5Cjn470Nv/"
COMMA_SEPARATED_LIST_OF_GROUPS_TO_ADD_USER_TO ?= "systemd-journal"

USERADD_PARAM:${PN} = "-u ${USER_TO_ADD_UID} -d /home/${USER_TO_ADD_NAME} -s ${base_bindir}/sh -G ${COMMA_SEPARATED_LIST_OF_GROUPS_TO_ADD_USER_TO} -p '${USER_TO_ADD_PASSWORD_HASHED}' ${USER_TO_ADD_NAME}"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

# Prior to useradd being performed on the sysroot a couple things must happen:
#   1. Need the systemd recipe to create the systemd-journal group
#   2. Need busybox shell present
do_prepare_recipe_sysroot[depends] += "systemd:do_populate_sysroot busybox:do_populate_sysroot"
