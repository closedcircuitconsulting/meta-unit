SUMMARY = "Add service user"
LICENSE = "MIT"

EXCLUDE_FROM_WORLD = "1"

inherit useradd
inherit extrausers

S = "${UNPACKDIR}"

RDEPENDS:${PN}:append = " shadow"

USERADD_PACKAGES = "${PN}"

USER_TO_ADD_NAME ?= "svc"
USER_TO_ADD_UID ?= "2000"
USER_TO_ADD_PASSWORD_HASHED ?= "\$6\$1TQs7iLskyTyCjoL\$xhngcFWaPRsoaZCwLSsYXUrRcVdR19zV2vBEzrzSEVu8zbqDlfKu4HLwzsZfiqJCiWqiu9qirD4Ym12CMf7D7."

USERADD_PARAM:${PN} = "--uid ${USER_TO_ADD_UID} --home-dir /home/${USER_TO_ADD_NAME} --shell ${base_bindir}/sh --password '${USER_TO_ADD_PASSWORD_HASHED}' ${USER_TO_ADD_NAME}"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
