ROOTFS_POSTPROCESS_COMMAND:append = " fix_svc_user_home_directory_ownership;"

fix_svc_user_home_directory_ownership() {
    chown -R svc:svc ${IMAGE_ROOTFS}/home/svc
}
