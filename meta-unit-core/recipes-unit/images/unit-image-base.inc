inherit core-image
inherit image-buildinfo

IMAGE_INSTALL:append = " packagegroup-unit-networking"
IMAGE_INSTALL:append = " packagegroup-unit-system"
IMAGE_INSTALL:append = " packagegroup-unit-users"
IMAGE_INSTALL:append = " packagegroup-unit-utils"
