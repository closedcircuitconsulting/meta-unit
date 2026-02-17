inherit core-image
inherit image-buildinfo

IMAGE_INSTALL:append = " packagegroup-unit-networking"
IMAGE_INSTALL:append = " packagegroup-unit-system"
IMAGE_INSTALL:append = " packagegroup-unit-systemd"
IMAGE_INSTALL:append = " packagegroup-unit-users"
IMAGE_INSTALL:append = " packagegroup-unit-utils"

# Allow for 4GB of extra space for misc. purposes (ex. container image storage)
IMAGE_ROOTFS_EXTRA_SPACE = "4194304"

IMAGE_FEATURES:append = " splash"
