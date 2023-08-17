do_install:append () {
    # Mount the persistent storgae used by Memfault
    echo "/dev/mmcblk${EMMC_DEV}p4  /data ext4  defaults  0  0" >> ${D}${sysconfdir}/fstab
}
