DESCRIPTION = "Sets the uboot.env file in the rootfs"
SECTION = "bsp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += "file://u-boot-env.txt"
S = "${WORKDIR}"

DEPENDS += "u-boot-tools-native"

do_configure[noexec] = "1"

FILES:${PN} += "/boot"
FILES:${PN} += "/boot/u-boot-env.bin"


do_compile() {
    cp u-boot-env.txt u-boot-env.txt.tmp
    sed -i 's/EMB_DEV_IPADDR/${EMB_DEV_IPADDR}/g' u-boot-env.txt.tmp
    sed -i 's/EMB_DEV_HOSTIP/${EMB_DEV_HOSTIP}/g' u-boot-env.txt.tmp
    sed -i 's/EMB_DEV_NFSROOT/${EMB_DEV_NFSROOT}/g' u-boot-env.txt.tmp
    sed -i 's/EMB_DEV_KERNEL_ADDR/${EMB_DEV_KERNEL_ADDR}/g' u-boot-env.txt.tmp
    sed -i 's/EMB_DEV_DTB_ADDR/${EMB_DEV_DTB_ADDR}/g' u-boot-env.txt.tmp
    sed -i 's/EMB_DEV_DTB/${EMB_DEV_DTB}/g' u-boot-env.txt.tmp
    mkenvimage -s 0x1f000 -o u-boot-env.bin u-boot-env.txt.tmp
}

do_install() {
    install -d ${D}/boot
    install -m 0755 ${WORKDIR}/u-boot-env.bin ${D}/boot
}
