DEPENDS = "u-boot-imx-tools-native u-boot-mkenvimage"
LICENSE = "CLOSED"

do_compile() {
    ${STAGING_BINDIR_NATIVE}/mkenvimage -r -s "0x10000" -o ${DEPLOY_DIR_IMAGE}/u-boot-env.bin ${DEPLOY_DIR_IMAGE}/u-boot-imx-initial-env-sd
}

RPROVIDES:${PN} += "u-boot-default-env"
