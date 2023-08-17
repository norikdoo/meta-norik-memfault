DESCRIPTION = "Memfault script containing device info"
LICENSE = "CLOSED"

S = "${WORKDIR}"

python do_configure() {
    import re

    device_id = d.getVar('MEMFAULT_DEVICE_ID')
    if not device_id or not re.match(r"^[-a-zA-Z0-9_]+$", device_id):
        bb.warn("Invalid MEMFAULT_DEVICE_ID")

    device_id = d.getVar('MEMFAULT_HARDWARE_VERSION')
    if not device_id or not re.match(r"^[a-zA-Z0-9\-_.+:]+$", device_id):
        bb.warn("Invalid MEMFAULT_HARDWARE_VERSION")
}

do_compile() {
    echo "#!/bin/sh" > ${S}/memfault-device-info
    echo "echo MEMFAULT_DEVICE_ID=${MEMFAULT_DEVICE_ID}" >> ${S}/memfault-device-info
    echo "echo MEMFAULT_HARDWARE_VERSION=${MEMFAULT_HARDWARE_VERSION}" >> ${S}/memfault-device-info
}

do_install() {
    install -Dm 755 ${S}/memfault-device-info ${D}/${bindir}/memfault-device-info
}
