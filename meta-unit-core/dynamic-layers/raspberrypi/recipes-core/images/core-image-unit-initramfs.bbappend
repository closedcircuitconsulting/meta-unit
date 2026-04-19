INITRAMFS_SCRIPTS:append:raspberrypi3-64 = " initramfs-module-backlight"

PACKAGE_INSTALL:append:raspberrypi3-64 = " \
    initramfs-graphics-modules \
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
