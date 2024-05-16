SUMMARY = "Table Database"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " file://CMakeLists.txt "
SRC_URI += " file://database.cpp "
SRC_URI += " file://database.h "

S = "${WORKDIR}"

TARGET_CC_ARCH += "${LDFLAGS}"

inherit cmake

do_install() {
            install -d ${D}${includedir}
            install -m 0755 ${WORKDIR}/*.h ${D}${includedir}
            install -d ${D}${libdir}
            install -m 0644 libtable-database.a ${D}${libdir}
}
FILES:${PN} = "${libdir}/*.a.* ${includedir}/*"
FILES:${PN}-dev = "${libdir}/*.a"
