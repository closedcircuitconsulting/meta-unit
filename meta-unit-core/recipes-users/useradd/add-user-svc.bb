SUMMARY = "Add service user"
LICENSE = "MIT"

EXCLUDE_FROM_WORLD = "1"

inherit useradd
inherit extrausers

RDEPENDS:${PN}:append = " base-passwd"
RDEPENDS:${PN}:append = " busybox"
RDEPENDS:${PN}:append = " shadow"
RDEPENDS:${PN}:append = " systemd"

USERADD_PACKAGES = "${PN}"

USER_TO_ADD_NAME ?= "svc"
USER_TO_ADD_UID ?= "50556"
USER_TO_ADD_PASSWORD_HASHED ?= "\$6\$1TQs7iLskyTyCjoL\$xhngcFWaPRsoaZCwLSsYXUrRcVdR19zV2vBEzrzSEVu8zbqDlfKu4HLwzsZfiqJCiWqiu9qirD4Ym12CMf7D7."
COMMA_SEPARATED_LIST_OF_GROUPS_TO_ADD_USER_TO ?= "systemd-journal"

USERADD_PARAM:${PN} = "-u ${USER_TO_ADD_UID} -d /home/${USER_TO_ADD_NAME} -s ${base_bindir}/sh -G ${COMMA_SEPARATED_LIST_OF_GROUPS_TO_ADD_USER_TO} -p '${USER_TO_ADD_PASSWORD_HASHED}' ${USER_TO_ADD_NAME}"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install() {
    # Note: Use of .profile here assumes busybox shell.
    install -D -m 0644 /dev/null ${D}/home/${USER_TO_ADD_NAME}/.profile

    # User is not part of sudo group and therefore doesn't 
    # have sbin in path, add it for access to common commands.
    cat > ${D}/home/${USER_TO_ADD_NAME}/.profile << 'EOF'
export PATH="${sbindir}:/sbin:$PATH"
EOF
}

# Prior to useradd being performed on the sysroot a couple things must happen:
#   1. Need the systemd recipe to create the systemd-journal group
#   2. Need busybox shell present
do_prepare_recipe_sysroot[depends] += "systemd:do_populate_sysroot busybox:do_populate_sysroot"

FILES:${PN}:append = " /home/${USER_TO_ADD_NAME}/.profile"
