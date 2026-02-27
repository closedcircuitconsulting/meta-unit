inherit fix-svc-user-home-dir-ownership
inherit fix-prometheus-conf-dir-ownership

IMAGE_INSTALL:append = " packagegroup-unit-containers"

IMAGE_INSTALL:append = " packagegroup-unit-containers-conf"

IMAGE_INSTALL:append = " packagegroup-unit-kubes"

IMAGE_INSTALL:append = " packagegroup-unit-quadlets"

IMAGE_INSTALL:append = " ${@bb.utils.contains('IMAGE_FEATURES', 'observability', 'packagegroup-unit-observability-quadlets', '', d)}"
