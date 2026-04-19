SUMMARY = "Initramfs to boot a fully-featured rootfs"
DESCRIPTION = "Small initramfs that contains udev and init to find the real rootfs"
LICENSE = "MIT"

inherit image

INITRAMFS_SCRIPTS ?= "\
    initramfs-module-debug \
    initramfs-module-udev \
    initramfs-module-kmod \
"

PACKAGE_INSTALL = "\
    ${INITRAMFS_SCRIPTS} \
    ${VIRTUAL-RUNTIME_base-utils} \
    base-passwd \
"

# Ensure the initramfs only contains the bare minimum
IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""

# Don't allow the initramfs to contain a kernel, as kernel modules will depend
# on the kernel image.
PACKAGE_EXCLUDE = "kernel-image-*"

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"
IMAGE_FSTYPES:remove:rpi = "wic.zst"
IMAGE_NAME_SUFFIX ?= ""
IMAGE_ROOTFS_SIZE = "24576"
IMAGE_ROOTFS_EXTRA_SPACE = "0"
