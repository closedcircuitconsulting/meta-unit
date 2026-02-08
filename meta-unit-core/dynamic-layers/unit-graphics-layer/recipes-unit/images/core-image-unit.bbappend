inherit fix-kiosk-home-dir-ownership

IMAGE_FEATURES:append = " hwcodecs"

IMAGE_INSTALL:append = " packagegroup-unit-kiosk"

IMAGE_INSTALL:append:raspberrypi3-64 = " u-boot-splash"
IMAGE_BOOT_FILES:append:raspberrypi3-64 = " yocto_project_logo_white_800x480_24bpp.bmp.gz"
