inherit fix-prometheus-conf-dir-ownership

IMAGE_INSTALL:append = " packagegroup-unit-containers"
IMAGE_INSTALL:append = " packagegroup-unit-kubes"
IMAGE_INSTALL:append = " packagegroup-unit-quadlets"
