SUMMARY = "Norik base image with memfault support"
LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

IMAGE_INSTALL = " \
    packagegroup-machine-base \
    packagegroup-core-boot \
    packagegroup-hwtools \
    packagegroup-benchmark \
    packagegroup-userland \
    packagegroup-userland-flashing \
    packagegroup-rt \
    packagegroup-coprocessor \
    ${@bb.utils.contains("COMBINED_FEATURES", "alsa", "packagegroup-audio", "", d)} \
    ${@bb.utils.contains("COMBINED_FEATURES", "wifi", "packagegroup-wifi", "", d)} \
    ${@bb.utils.contains("COMBINED_FEATURES", "bluetooth", "packagegroup-bluetooth", "", d)} \
    ${@bb.utils.contains("COMBINED_FEATURES", "3g", "packagegroup-3g", "", d)} \
    tzdata \
    ${@bb.utils.contains("MACHINE_FEATURES", "tpm2", "packagegroup-sks-openssl-tpm2", "",  d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "tpm2", "packagegroup-sks-pkcs11-tpm2", "", d)} \
    ${@bb.utils.contains("MACHINE_FEATURES", "tpm2", "packagegroup-sks-provision-tpm2", "", d)} \
    packagegroup-camera \
    memfault-device-info \
    u-boot-fw-utils \
    u-boot-env \
"

IMAGE_INSTALL:append:mx8m-generic-bsp = " firmwared"

PACKAGECONFIG:pn_memfaultd := "swupdate collectd coredump logging"

# You must set the following variables in your local.conf:
# MEMFAULT_DEVICE_ID - unique device ID (ex. MAC address, serial number, etc.)
# MEMFAULT_HARDWARE_VERSION - board revision
# MEMFAULT_BASE_URL - Memfault API URL (https://device.memfault.com)
# MEMFAULT_PROJECT_KEY - unique project key (shown on Memfault dashboard)
# MEMFAULT_SOFTWARE_TYPE
# MEMFAULT_SOFTWARE_VERSION
