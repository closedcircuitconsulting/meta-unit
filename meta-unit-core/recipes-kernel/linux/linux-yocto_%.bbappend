FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

KERNEL_FEATURES:append = " features/pwm/pwm.scc"

SRC_URI:append = " file://wdt.cfg"
