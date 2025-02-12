inherit extrausers
EXTRA_USERS_PARAMS = "usermod -p '\$1\$HhsG6ibe\$welFXCf1sirIa/p6eTmsO1' root"

EXTRA_IMAGECMD:append = " -O ^metadata_csum"

IMAGE_FSTYPES += "ext4"
IMAGE_INSTALL:append = "packagegroup-core-ssh-openssh u-boot-env bash mmc-utils util-linux vim kernel-modules perf trace-cmd drmtest"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
