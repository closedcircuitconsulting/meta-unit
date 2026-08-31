SRCREV_meta ?= "24949c3ef490d79a73a821f688efdc2f562fc851"

SRC_URI:append = " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.18;destsuffix=${KMETA};protocol=https"

KMETA = "kernel-meta"
