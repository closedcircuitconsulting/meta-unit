FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

# Override to newer version that has olimex-imx8mp support
LINUX_VERSION = "6.18.32"
SRCREV = "b53c67dffacd841fa51dbfeb9d5abd0cf9f7cdae"

# Backport fix for misaligned labels.
SRC_URI:append = " file://0001-arm64-dts-imx8mp-align-dts-for-olimex-with-nxp-rename-of-gpu-labels.patch"
