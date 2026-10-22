FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:beaglebone-yocto-custom = " file://ti-pwm.cfg"
SRC_URI:append:beaglebone-yocto-custom = " file://0001-add-am335x-boneblack-enable-pwm1b-dtsi.patch"
SRC_URI:append:beaglebone-yocto-custom = " file://0002-add-custom-device-tree-for-am335x-boneblack.patch"
