OCI_IMAGE_TAG = "latest${@['', '-${TCLIBC}'][d.getVar('TCLIBC') == 'musl']}"
