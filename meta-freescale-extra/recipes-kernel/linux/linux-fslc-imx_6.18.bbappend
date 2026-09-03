FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Override to newer version that has olimex-imx8mp support
LINUX_VERSION = "6.18.32"
SRCREV = "b53c67dffacd841fa51dbfeb9d5abd0cf9f7cdae"
SRCREV_meta ?= "2f71b0a288c307062fc60948ac793d8d51c685e2"
SRC_URI:append = " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.18;destsuffix=${KMETA};protocol=https"

# Backport fix for misaligned labels.
SRC_URI:append = " file://0001-arm64-dts-imx8mp-align-dts-for-olimex-with-nxp-rename-of-gpu-labels.patch"
