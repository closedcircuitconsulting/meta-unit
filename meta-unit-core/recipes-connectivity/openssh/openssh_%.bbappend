FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

do_install:append () {
	# Disable root login completely
	sed -i -e 's:#PermitRootLogin.*:PermitRootLogin no:' ${D}${sysconfdir}/ssh/sshd_config
	
	# Enable public key authentication
	sed -i -e 's:#PubkeyAuthentication yes:PubkeyAuthentication yes:' ${D}${sysconfdir}/ssh/sshd_config
	
	# Add global authorized_keys file to AuthorizedKeysFile
	sed -i -e 's:^AuthorizedKeysFile.*:AuthorizedKeysFile\t.ssh/authorized_keys /etc/ssh/authorized_keys:' ${D}${sysconfdir}/ssh/sshd_config
	
	# Disable password authentication
	sed -i -e 's:#PasswordAuthentication yes:PasswordAuthentication no:' ${D}${sysconfdir}/ssh/sshd_config
	
	# Explicitly disable empty passwords
	sed -i -e 's:#PermitEmptyPasswords no:PermitEmptyPasswords no:' ${D}${sysconfdir}/ssh/sshd_config
	
	# Restrict SSH access to unitexe user only
	echo "" >> ${D}${sysconfdir}/ssh/sshd_config
	echo "# Allow only the unitexe user" >> ${D}${sysconfdir}/ssh/sshd_config
	echo "AllowUsers unitexe" >> ${D}${sysconfdir}/ssh/sshd_config
}
