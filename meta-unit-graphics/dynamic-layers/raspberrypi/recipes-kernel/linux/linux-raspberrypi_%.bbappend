FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
FILESEXTRAPATHS:prepend := "${UNIT_GRAPHICS_LAYERDIR}/recipes-kernel/linux/files:"

require recipes-kernel/linux/unit-graphics.inc

SRC_URI:append = " file://0001-add-yocto-kernel-logos.patch"

SRC_URI:append = " file://yocto-kernel-logo-800x480.cfg"
