FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " file://splash.cfg"
SRC_URI:append = " file://0001-tweak-default-environment.patch"

# On screen console not wanted
UBOOT_EXTLINUX_CONSOLE:remove = "console=tty1"

# Without this plymouth will not show
UBOOT_EXTLINUX_KERNEL_ARGS:append = " splash"
