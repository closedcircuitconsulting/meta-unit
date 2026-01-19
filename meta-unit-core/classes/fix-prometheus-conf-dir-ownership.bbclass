ROOTFS_POSTPROCESS_COMMAND:append = " fix_prometheus_conf_dir_ownership;"

fix_prometheus_conf_dir_ownership() {
    chmod 755 ${IMAGE_ROOTFS}${sysconfdir}/prometheus
    chmod 755 ${IMAGE_ROOTFS}${sysconfdir}/prometheus/targets.d
}
