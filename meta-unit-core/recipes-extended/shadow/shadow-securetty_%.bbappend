do_install:append() {
    # Empty securetty to disallow root login on all TTYs.
    echo -n > ${D}${sysconfdir}/securetty
}
