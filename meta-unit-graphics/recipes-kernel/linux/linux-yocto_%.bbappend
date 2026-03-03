FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

require unit-graphics.inc

# Replace default linux logo with yocto project logo
SRC_URI:append = " file://0001-replace-linux-logo.patch"
