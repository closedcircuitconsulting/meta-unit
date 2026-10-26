FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRCREV_meta ?= "5978c5f530b91cfb62213506ee6f157897432ba3"

SRC_URI:append = " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.18;destsuffix=${KMETA};protocol=https"
SRC_URI:append:olinuxino-a20-emmc-custom = " file://0001-add-sun7i-a20-enable-pwm1-dtsi.patch"
SRC_URI:append:olinuxino-a20-emmc-custom = " file://0002-add-custom-device-tree-for-sun7i-a20-olinuxino-micro.patch"

KMETA = "kernel-meta"

KERNEL_FEATURES:append:pine64-pinephone-braveheart = " cfg/fs/ext4.scc"
