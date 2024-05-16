SUMMARY = "Rust standalone application"
SECTION = "applications"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI += " file://Cargo.toml "
SRC_URI += " file://src/main.rs "

S = "${WORKDIR}"

inherit cargo

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/build/target/*/release/standalone-app ${D}${bindir}
}
