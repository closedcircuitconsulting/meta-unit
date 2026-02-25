inherit fix-kiosk-home-dir-ownership
inherit mask-tty1-getty

IMAGE_FEATURES:append = " hwcodecs"

IMAGE_INSTALL:append = " packagegroup-unit-kiosk"
IMAGE_INSTALL:append = " ${@bb.utils.contains('IMAGE_FEATURES', 'splash', 'packagegroup-unit-splash', '', d)}"
IMAGE_INSTALL:append = " ${@bb.utils.contains('IMAGE_FEATURES', 'boot-splash', 'packagegroup-unit-boot-splash', '', d)}"

IMAGE_BOOT_FILES:append = " ${@bb.utils.contains('IMAGE_FEATURES', 'boot-splash', 'yocto_project_logo_white_800x480_24bpp.bmp.gz', '', d)}"
