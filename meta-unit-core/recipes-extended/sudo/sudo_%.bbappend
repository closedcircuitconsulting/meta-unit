FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://50-unitexe"

do_install:append() {
    install -p -m0440 ${UNPACKDIR}/50-unitexe ${D}${sysconfdir}/sudoers.d/50-unitexe
}

FILES:${PN}-lib:append = " ${sysconfdir}/sudoers.d/50-unitexe"
