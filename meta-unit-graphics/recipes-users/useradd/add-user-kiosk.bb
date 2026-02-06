SUMMARY = "Add kiosk user"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_GRAPHICS_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

EXCLUDE_FROM_WORLD = "1"

inherit useradd
inherit extrausers
inherit enable-linger

RDEPENDS:${PN}:append = " systemd"
RDEPENDS:${PN}:append = " weston-init"

SRC_URI = "file://.profile"

USERADD_PACKAGES = "${PN}"
USER_TO_ADD_NAME ?= "kiosk"
USER_TO_ADD_UID ?= "50557"
USER_TO_ADD_PASSWORD_HASHED ?= "\$6\$oD8hxDdrL3h.n..p\$j2LvVlUqokdmPQGDQLKgy3oA5qg.l7Sy4cV4m6zrMu8A8Yc8WJD8Kn9BgYC.Y5iZiAEbMdpUyiuFCCo7Whvgq0"
COMMA_SEPARATED_LIST_OF_GROUPS_TO_ADD_USER_TO ?= "systemd-journal,video,input,render,seat,wayland"

USERADD_PARAM:${PN} = "-u ${USER_TO_ADD_UID} -U -d /home/${USER_TO_ADD_NAME} -s ${base_bindir}/sh -G ${COMMA_SEPARATED_LIST_OF_GROUPS_TO_ADD_USER_TO} -p '${USER_TO_ADD_PASSWORD_HASHED}' ${USER_TO_ADD_NAME}"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

S = "${UNPACKDIR}"

do_install() {
    install -D -m 0644 ${S}/.profile ${D}/home/${USER_TO_ADD_NAME}/.profile
}

# Prior to useradd being performed on the sysroot a couple things must happen:
#   1. Need the systemd recipe to create the systemd-journal group
#   2. Need busybox shell present
#   3. Need the weston-init recipe to create the video,input,render and seat groups
do_prepare_recipe_sysroot[depends] += "systemd:do_populate_sysroot busybox:do_populate_sysroot weston-init:do_populate_sysroot"

FILES:${PN} = "/home/${USER_TO_ADD_NAME}/.profile"
