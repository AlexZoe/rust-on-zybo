# Rust on Zybo

## Meta-Rust

Need to add the following changes to `conf/layer`:

```
+RUST_BUILD_ARCH = "x86_64"
+require conf/distro/include/rust_versions.inc
```

## Bindings

When using `bindgen` as part of `build.rs`, `clang` has to be installed on the system.
The petalinux project does not need to have `clang` enabled.

If the shared/static library for which bindings are to be generated is implemented in C++, `stdc++` might need to be linked to the rust library.
For this, the following entry has to be added to the `build.rs` file.

```
println!("cargo:rustc-link-lib=stdc++");
```

