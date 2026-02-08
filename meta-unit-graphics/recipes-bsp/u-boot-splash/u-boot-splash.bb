SUMMARY = "Deploy u-boot splash image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_GRAPHICS_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

inherit deploy

SRC_URI = "\
    file://yocto_project_logo_white_800x480_24bpp.bmp.gz;unpack=0 \
"

S = "${UNPACKDIR}"

do_deploy() {
    install -d ${DEPLOY_DIR_IMAGE}
    install -m 0644 ${S}/yocto_project_logo_white_800x480_24bpp.bmp.gz ${DEPLOY_DIR_IMAGE}/yocto_project_logo_white_800x480_24bpp.bmp.gz
}

addtask deploy before do_build after do_compile

# The recipe just deploys a file it doesn't install anything to rootfs
ALLOW_EMPTY:${PN} = "1"
