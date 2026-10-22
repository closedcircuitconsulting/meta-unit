FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append:radxa-zero-3e-custom = " file://0001-add-unit-device-tree-for-radxa-zero-3e.patch"

SRC_URI:append:rock-pi-4b-custom = " file://0001-add-rk3399-base-enable-pwm0-dtsi.patch"
SRC_URI:append:rock-pi-4b-custom = " file://0002-add-custom-device-tree-for-rk3399-rock-pi-4b.patch"
