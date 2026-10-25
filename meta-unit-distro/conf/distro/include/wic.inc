# This will override the default wic.xz for meta-rockchip.
WIC_COMPRESSION_EXTENSION = ".zst"

# This will override the default wic.bz2 for meta-raspberrypi.
IMAGE_FSTYPES:remove:rpi = "wic.bz2"
IMAGE_FSTYPES:append:rpi = " wic${WIC_COMPRESSION_EXTENSION}"

# This will override the default wic.gz for meta-sunxi.
IMAGE_FSTYPES:remove:sunxi = "wic.gz"
IMAGE_FSTYPES:append:sunxi = " wic${WIC_COMPRESSION_EXTENSION}"

# This will override the default wic.gz for meta-freescale.
IMAGE_FSTYPES:remove:mx8m-generic-bsp = "wic.gz"
IMAGE_FSTYPES:append:mx8m-generic-bsp = " wic${WIC_COMPRESSION_EXTENSION}"
