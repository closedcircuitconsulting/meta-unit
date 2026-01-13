INIT_MANAGER = "systemd"

# Don't symlink /var/log to /var/volatile/log 
# so persistent journal storage can be used.
FILESYSTEM_PERMS_TABLES:remove = "files/fs-perms-volatile-log.txt"
