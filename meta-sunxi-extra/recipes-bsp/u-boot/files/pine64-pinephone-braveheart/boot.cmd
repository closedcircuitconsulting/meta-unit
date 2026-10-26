# Use the device U-Boot found this script on (bootstd sets devtype/devnum)
if test -z "${devtype}"; then setenv devtype mmc; fi
if test -z "${devnum}"; then setenv devnum 0; fi

# Find the root partition by ID so the kernel's MMC numbering doesn't matter
part uuid ${devtype} ${devnum}:2 rootuuid

setenv bootargs console=${console} console=tty1 root=PARTUUID=${rootuuid} rootwait panic=10 ${extra}
load ${devtype} ${devnum}:1 ${fdt_addr_r} ${fdtfile}
load ${devtype} ${devnum}:1 ${kernel_addr_r} Image
booti ${kernel_addr_r} - ${fdt_addr_r}
