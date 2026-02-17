ROOTFS_POSTPROCESS_COMMAND:append = " mask_tty1_getty;"

mask_tty1_getty() {
    # Mask systemd generated login prompt on TTY1 (screen)
    ln -sf /dev/null ${IMAGE_ROOTFS}${sysconfdir}/systemd/system/getty@tty1.service
}
