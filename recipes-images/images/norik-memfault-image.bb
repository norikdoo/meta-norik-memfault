SUMMARY = "Norik image with memfault - wic and swupdate image"
LICENSE = "MIT"

inherit image

# Disable most of the image build process
do_rootfs[noexec] = "1"
do_rootfs_wicenv[noexec] = "1"
do_image[noexec] = "0"
do_image_wic[noexec] = "1"
do_image_ext3[noexec] = "1"
do_image_ext4[noexec] = "1"
do_image_tar[noexec] = "1"
do_image_complete[noexec] = "1"
do_image_complete_setscene[noexec] = "1"
do_image_qa[noexec] = "1"
do_image_qa_setscene[noexec] = "1"
do_build[noexec] = "1"

do_image[depends] += "swupdate-image:do_swuimage base-image:do_image_complete"
