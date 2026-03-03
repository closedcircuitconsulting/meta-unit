INITRAMFS_IMAGE_BUNDLE = "1"
INITRAMFS_IMAGE = "core-image-unit-initramfs"

# The beaglebone-yocto machine configuration file does not handle the case where
# using kernel with bundled initramfs.
IMAGE_BOOT_FILES:remove:beaglebone-yocto = "${KERNEL_IMAGETYPE}"
IMAGE_BOOT_FILES:append:beaglebone-yocto = " ${KERNEL_IMAGETYPE}-${INITRAMFS_LINK_NAME}.bin;${KERNEL_IMAGETYPE}"
