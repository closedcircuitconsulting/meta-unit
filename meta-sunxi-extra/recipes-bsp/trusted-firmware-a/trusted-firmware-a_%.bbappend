# Allwinner TF-A builds BL31 with LTO. That needs gcc as the linker, so it can
# load the LTO plugin. The base recipe uses bare ld, so override it here.
EXTRA_OEMAKE:append:pine64-pinephone-braveheart = " LD='${TARGET_PREFIX}gcc'"
