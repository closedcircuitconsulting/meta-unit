# This will override the default wic.xz for meta-rockchip.
WIC_COMPRESSION_EXTENSION = ".zst"

# This will override the default wic.bz2 for meta-raspberrypi.
IMAGE_FSTYPES:remove:rpi = "wic.bz2"
IMAGE_FSTYPES:append:rpi = " wic${WIC_COMPRESSION_EXTENSION}"

# Need to use a custom WIC kickstart file because the upstream
# one doesn't work with our kernel with bundled initramfs (boot
# partition not big enough).
WKS_FILE:beaglebone-yocto = "unit-beaglebone-yocto.wks"
