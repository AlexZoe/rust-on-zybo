SUMMARY = "Rust database application"
SECTION = "applications"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS:prepend := "${THISDIR}/../../../../rust_registry/:"

SRC_URI += " file://Cargo.toml "
SRC_URI += " file://build.rs "
SRC_URI += " file://src/main.rs "
SRC_URI += " file://table_database_rs "

#SRC_URI += " file://${THISDIR}/../../../../rust_registry/table-database-rs/ "
SRC_URI += " \
    crate://crates.io/aho-corasick/1.1.3 \
    crate://crates.io/bindgen/0.69.4 \
    crate://crates.io/bitflags/2.6.0 \
    crate://crates.io/cexpr/0.6.0 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/clang-sys/1.8.1 \
    crate://crates.io/either/1.13.0 \
    crate://crates.io/errno/0.3.9 \
    crate://crates.io/glob/0.3.1 \
    crate://crates.io/home/0.5.9 \
    crate://crates.io/itertools/0.12.1 \
    crate://crates.io/lazy_static/1.5.0 \
    crate://crates.io/lazycell/1.3.0 \
    crate://crates.io/libc/0.2.155 \
    crate://crates.io/libloading/0.8.5 \
    crate://crates.io/linux-raw-sys/0.4.14 \
    crate://crates.io/log/0.4.22 \
    crate://crates.io/memchr/2.7.4 \
    crate://crates.io/minimal-lexical/0.2.1 \
    crate://crates.io/nom/7.1.3 \
    crate://crates.io/once_cell/1.19.0 \
    crate://crates.io/prettyplease/0.2.20 \
    crate://crates.io/proc-macro2/1.0.86 \
    crate://crates.io/quote/1.0.36 \
    crate://crates.io/regex-automata/0.4.7 \
    crate://crates.io/regex-syntax/0.8.4 \
    crate://crates.io/regex/1.10.5 \
    crate://crates.io/rustc-hash/1.1.0 \
    crate://crates.io/rustix/0.38.34 \
    crate://crates.io/shlex/1.3.0 \
    crate://crates.io/syn/2.0.72 \
    crate://crates.io/unicode-ident/1.0.12 \
    crate://crates.io/which/4.4.2 \
    crate://crates.io/windows-sys/0.52.0 \
    crate://crates.io/windows-targets/0.52.6 \
    crate://crates.io/windows_aarch64_gnullvm/0.52.6 \
    crate://crates.io/windows_aarch64_msvc/0.52.6 \
    crate://crates.io/windows_i686_gnu/0.52.6 \
    crate://crates.io/windows_i686_gnullvm/0.52.6 \
    crate://crates.io/windows_i686_msvc/0.52.6 \
    crate://crates.io/windows_x86_64_gnu/0.52.6 \
    crate://crates.io/windows_x86_64_gnullvm/0.52.6 \
    crate://crates.io/windows_x86_64_msvc/0.52.6 \
    "

S = "${WORKDIR}"

DEPENDS += "table-database"
DEPENDS += "clang"

export INCLUDE_DIR = "${RECIPE_SYSROOT}${includedir}"

inherit cargo

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/build/target/*/release/data-base-app-rs ${D}${bindir}
}
