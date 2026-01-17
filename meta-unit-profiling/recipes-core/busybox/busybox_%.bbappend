FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " file://mpstat.cfg"
SRC_URI:append = " file://iostat.cfg"
