ROOTFS_POSTPROCESS_COMMAND:append = " fix_unitexe_user_home_directory_ownership;"

fix_unitexe_user_home_directory_ownership() {
    chown -R unitexe:unitexe ${IMAGE_ROOTFS}/home/unitexe
}
