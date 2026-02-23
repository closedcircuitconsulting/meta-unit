inherit fix-svc-user-home-dir-ownership
inherit fix-prometheus-conf-dir-ownership

IMAGE_INSTALL:append = " packagegroup-unit-containers"

# The only kube in here uses gRPC curl container which doesn't support armv7
IMAGE_INSTALL:append:raspberrypi3-64 = " packagegroup-unit-kubes"
IMAGE_INSTALL:append:radxa-zero-3e = " packagegroup-unit-kubes"

IMAGE_INSTALL:append = " packagegroup-unit-quadlets"
IMAGE_INSTALL:append = " ${@bb.utils.contains('IMAGE_FEATURES', 'observability', 'packagegroup-unit-observability-quadlets', '', d)}"
