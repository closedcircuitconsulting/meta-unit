SRCREV_meta ?= "5978c5f530b91cfb62213506ee6f157897432ba3"

SRC_URI:append = " git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=yocto-6.18;destsuffix=${KMETA};protocol=https"

KMETA = "kernel-meta"
