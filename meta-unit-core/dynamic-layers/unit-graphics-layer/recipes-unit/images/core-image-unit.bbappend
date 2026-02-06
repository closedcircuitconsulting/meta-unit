inherit fix-kiosk-home-dir-ownership

IMAGE_FEATURES:append = " hwcodecs"

IMAGE_INSTALL:append = " packagegroup-unit-kiosk"
