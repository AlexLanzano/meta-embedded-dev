require recipes-bsp/u-boot/u-boot-ti.inc

PR = "r0"

PV = "2023.04"

UBOOT_GIT_URI = "git://openbeagle.org/beagleboard/u-boot.git"
UBOOT_GIT_PROTOCOL = "https"
BRANCH = "v2023.04-ti-09.02.00.009-BeagleY-AI-Production"
SRCREV = "93735daa6fe024304934d5a5e93ab05a06abf1a8"

SRC_URI += "file://extra-u-boot-configs.cfg"
SRC_URI += "file://am67a-beagley-ai-a53.cfg"
