FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

require unit-graphics.inc

SRC_URI:append = " file://0001-add-yocto-kernel-logos.patch"

SRC_URI:append = " file://yocto-kernel-logo-1024x600.cfg"
