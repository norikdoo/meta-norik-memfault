do_install:append() {
    mkdir -p ${D}${sysconfdir}
    echo "{" > ${D}${sysconfdir}/memfaultd.conf
    echo "  \"base_url\": \"${MEMFAULT_BASE_URL}\"," >> ${D}${sysconfdir}/memfaultd.conf
    echo "  \"project_key\": \"${MEMFAULT_PROJECT_KEY}\"," >> ${D}${sysconfdir}/memfaultd.conf
    echo "  \"software_type\": \"${MEMFAULT_SOFTWARE_TYPE}\"," >> ${D}${sysconfdir}/memfaultd.conf
    echo "  \"software_version\": \"${MEMFAULT_SOFTWARE_VERSION}\"," >> ${D}${sysconfdir}/memfaultd.conf
    echo "  \"persist_dir\": \"/data\"," >> ${D}${sysconfdir}/memfaultd.conf
    echo "  \"tmp_dir\": \"/data\"," >> ${D}${sysconfdir}/memfaultd.conf
    echo "  \"enable_data_collection\": true" >> ${D}${sysconfdir}/memfaultd.conf
    echo "}" >> ${D}${sysconfdir}/memfaultd.conf
}
