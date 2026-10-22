inherit core-image
inherit image-buildinfo

IMAGE_FEATURES[validitems] += "boot-splash"
IMAGE_FEATURES[validitems] += "observability"

# Uses dhcp by default if not provided
IMAGE_FEATURES[validitems] += "prefer-static-ethernet"

IMAGE_INSTALL:append = " packagegroup-unit-networking"
IMAGE_INSTALL:append = " packagegroup-unit-system"
IMAGE_INSTALL:append = " packagegroup-unit-systemd"
IMAGE_INSTALL:append = " packagegroup-unit-users"
IMAGE_INSTALL:append = " packagegroup-unit-utils"
IMAGE_INSTALL:append = " packagegroup-unit-file-system"
IMAGE_INSTALL:append = " packagegroup-unit-debugging"

# Allow for 4GB of extra space for misc. purposes (ex. container image storage)
IMAGE_ROOTFS_EXTRA_SPACE = "4194304"

IMAGE_FEATURES:append = " splash"
