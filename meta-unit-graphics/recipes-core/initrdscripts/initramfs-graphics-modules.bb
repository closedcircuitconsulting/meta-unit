SUMMARY = "Graphics modules to load in initramfs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${UNIT_GRAPHICS_LAYERDIR}/LICENSE;md5=a77c12e0c0e8a14cebb1494195720ccc"

SRC_URI:append:raspberrypi3-64 = " file://early-graphics.conf"
SRC_URI:append:radxa-zero-3e = " file://early-graphics.conf"

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

RDEPENDS:${PN}:append:radxa-zero-3e = " \
    kernel-module-rockchipdrm \
    kernel-module-dw-mipi-dsi \
    kernel-module-dw-hdmi \
    kernel-module-dw-hdmi-qp \
    kernel-module-dw-hdmi-cec \
    kernel-module-analogix-dp \
    kernel-module-drm-display-helper \
    kernel-module-drm-dma-helper \
    kernel-module-drm-dp-aux-bus \
    kernel-module-cec \
    kernel-module-panfrost \
    kernel-module-gpu-sched \
"

S = "${UNPACKDIR}"

# Source configuration file for modules to load must be provided by machine specific overrides

do_install() {
    install -d ${D}${sysconfdir}/modules-load.d
    install -m 0644 ${S}/early-graphics.conf ${D}${sysconfdir}/modules-load.d/01-early-graphics.conf
}

FILES:${PN} = "${sysconfdir}/modules-load.d/01-early-graphics.conf"
