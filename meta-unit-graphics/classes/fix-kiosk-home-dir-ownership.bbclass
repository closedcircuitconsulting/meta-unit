ROOTFS_POSTPROCESS_COMMAND:append = " fix_kiosk_user_home_directory_ownership;"

fix_kiosk_user_home_directory_ownership() {
    chown -R kiosk:kiosk ${IMAGE_ROOTFS}/home/kiosk
}
