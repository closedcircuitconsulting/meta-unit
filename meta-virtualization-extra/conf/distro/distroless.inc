DISTRO_FEATURES = "acl ipv4 ipv6 largefile xattr"

VIRTUAL-RUNTIME_dev_manager ?= ""
VIRTUAL-RUNTIME_login_manager ?= ""
VIRTUAL-RUNTIME_init_manager ?= ""
VIRTUAL-RUNTIME_initscripts ?= ""
VIRTUAL-RUNTIME_keymaps ?= ""

PREFERRED_PROVIDER_virtual/kernel = "linux-dummy"
