# Don't want login prompt to ever show on kiosk system
SRC_URI:append = " file://disable-vt-console.cfg"

# Using alternative logos
SRC_URI:append = " file://disable-default-linux-logo.cfg"

# Patch in alternative kernel logos
SRC_URI:append = " file://0001-add-yocto-kernel-logos.patch"
