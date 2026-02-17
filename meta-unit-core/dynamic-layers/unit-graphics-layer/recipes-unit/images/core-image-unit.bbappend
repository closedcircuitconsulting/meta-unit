inherit fix-kiosk-home-dir-ownership
inherit mask-tty1-getty

IMAGE_FEATURES:append = " hwcodecs"

IMAGE_INSTALL:append = " packagegroup-unit-kiosk"
IMAGE_INSTALL:append = " packagegroup-unit-splash"

IMAGE_BOOT_FILES:append = " yocto_project_logo_white_800x480_24bpp.bmp.gz"
