FILESEXTRAPATHS:prepend := "${UNIT_GRAPHICS_LAYERDIR}/recipes-kernel/linux/files:"

require recipes-kernel/linux/unit-graphics.inc

SRC_URI:append:raspberrypi3-64 = " file://yocto-kernel-logo-800x480.cfg"

SRC_URI:append:raspberrypi5 = " file://yocto-kernel-logo-1024x600.cfg"
