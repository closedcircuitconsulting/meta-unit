SUMMARY = "Plymouth theme collection"
DESCRIPTION = "A huge collection (80+) of plymouth themes ported from android bootanimations"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "\
    git://github.com/adi1090x/plymouth-themes;branch=master;protocol=https \
"

SRCREV = "5d8817458d764bff4ff9daae94cf1bbaabf16ede"

PV = "1.0"

RDEPENDS:${PN}:append = " plymouth"

S = "${UNPACKDIR}/${PN}-${PV}"

PLYMOUTH_THEMES ??= "pack_1/circuit pack_2/darth_vader pack_3/pixels pack_4/spin"

do_install() {
    install -d ${D}${datadir}/plymouth/themes/pixels

    for theme_path in ${PLYMOUTH_THEMES}; do
        # Drop pack from the path
        theme_name=$(basename ${theme_path})

        # Create theme destination directory
        install -d ${D}${datadir}/plymouth/themes/${theme_name}

        # Copy theme files
        cp -r ${S}/${theme_path}/* ${D}${datadir}/plymouth/themes/${theme_name}/
    done
}

FILES:${PN} = "\
    ${datadir}/plymouth/themes/* \
"
