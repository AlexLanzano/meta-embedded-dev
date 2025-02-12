SUMMARY = "An example kernel recipe that uses the linux-yocto and oe-core"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"

inherit kernel
require recipes-kernel/linux/config-fragments.inc
require recipes-kernel/linux/linux-beagleplay.inc
require recipes-kernel/linux/linux-beagleyai.inc
require recipes-kernel/linux/linux-imx8ulp-evk-dev.inc


SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=git;branch=linux-6.12.y \
           file://debug.cfg "

SRCREV="${AUTOREV}"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"
PV = "${LINUX_VERSION}"

S = "${WORKDIR}/git"

LINUX_VERSION ?= "6.12"

PACKAGECONFIG ??= ""
PACKAGECONFIG[debug] = ",,"

do_install:append() {
    ${S}/scripts/clang-tools/gen_compile_commands.py -d ${B} -o ${S}/compile_commands.json
}
