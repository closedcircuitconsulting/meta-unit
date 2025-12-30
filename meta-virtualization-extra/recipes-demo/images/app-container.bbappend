OCI_IMAGE_TAG = "${IMAGE_BASENAME}:latest${@['', '-${TCLIBC}'][d.getVar('TCLIBC') == 'musl']}"
