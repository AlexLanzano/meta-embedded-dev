do_configure:append() {
    if [ -n "${KERNEL_CONFIG_FRAGMENTS}" ]
    then
        for f in ${KERNEL_CONFIG_FRAGMENTS}
        do
            # Check if the config fragment is available
            if [ ! -e "$f" ]
            then
                echo "Could not find kernel config fragment $f"
                exit 1
            fi
        done
    fi

    # Now that all the fragments are located merge them
    if [ -n "${KERNEL_CONFIG_FRAGMENTS}" -o -n "$configfrags" ]
    then
        ( cd ${WORKDIR} && ${S}/scripts/kconfig/merge_config.sh -m -r -O ${B} ${B}/.config $configfrags ${KERNEL_CONFIG_FRAGMENTS} 1>&2 )
        yes '' | oe_runmake -C ${S} O=${B} oldconfig
    fi
}
