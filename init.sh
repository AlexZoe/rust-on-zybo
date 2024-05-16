#!/bin/bash

SCRIPT_DIR="$(dirname "$(realpath "$0")")"
REPO_DIR=${SCRIPT_DIR}

echo "PETALINUX_VER=2022.1" > ${REPO_DIR}/.petalinux/metadata
