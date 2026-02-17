FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
FILESEXTRAPATHS:prepend := "${UNIT_GRAPHICS_LAYERDIR}/recipes-kernel/linux/files:"

require recipes-kernel/linux/unit-graphics.inc

# Replace default linux logo with yocto project logo
SRC_URI:append = " file://0001-replace-linux-logo.patch"
