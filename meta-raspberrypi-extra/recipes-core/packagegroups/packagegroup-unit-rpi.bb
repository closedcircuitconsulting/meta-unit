SUMMARY = "Raspberrypi specific packages"

inherit packagegroup

# Allows updating RPIs on board EEPROM (if it has one).
RDEPENDS:${PN}:append:raspberrypi5 = " rpi-eeprom"

# Gives us useful tools such as vcgencmd.
RDEPENDS:${PN}:append = " raspi-utils"

# Install copies of files that reside on
# the boot partition to make updating them
# easier.
RDEPENDS:${PN}:append = " rpi-config-rootfs"
RDEPENDS:${PN}:append = " rpi-cmdline-rootfs"
RDEPENDS:${PN}:append = " rpi-u-boot-scr-rootfs"
