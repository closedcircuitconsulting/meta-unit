FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:olinuxino-a20-emmc-custom = " \
    file://0001-add-sun7i-a20-enable-pwm1-dtsi.patch \
    file://0002-add-custom-device-tree-for-sun7i-a20-olinuxino-micro.patch \
    file://0003-add-custom-defconfig-for-sun7i-a20-olinuxino-micro.patch \
"
