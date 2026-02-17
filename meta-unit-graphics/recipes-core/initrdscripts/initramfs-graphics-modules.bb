SUMMARY = "Graphics modules to load in initramfs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_GRAPHICS_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SRC_URI:append:raspberrypi3-64 = " file://early-graphics.conf"

RDEPENDS:${PN}:append:raspberrypi3-64 = " \
    kernel-module-rpi-panel-attiny-regulator \
    kernel-module-i2c-mux-pinctrl \
    kernel-module-edt-ft5x06 \
    kernel-module-panel-raspberrypi-touchscreen \
    kernel-module-tc358762 \
    kernel-module-v3d \
    kernel-module-raspberrypi-gpiomem \
    kernel-module-snd-bcm2835 \
    kernel-module-rpi-backlight \
    kernel-module-backlight \
    kernel-module-panel-simple \
"

S = "${UNPACKDIR}"

# Source configuration file for modules to load must be provided by machine specific overrides

do_install() {
    install -d ${D}${sysconfdir}/modules-load.d
    install -m 0644 ${S}/early-graphics.conf ${D}${sysconfdir}/modules-load.d/01-early-graphics.conf
}

FILES:${PN} = "${sysconfdir}/modules-load.d/01-early-graphics.conf"
