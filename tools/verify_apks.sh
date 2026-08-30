#!/usr/bin/env bash
set -euo pipefail

DEBUG_APK="$(find app/build/outputs/apk/debug -maxdepth 1 -name '*.apk' -print -quit)"
RELEASE_APK="$(find app/build/outputs/apk/release -maxdepth 1 -name '*.apk' -print -quit)"

if [[ -z "${DEBUG_APK}" || ! -s "${DEBUG_APK}" ]]; then
  echo "Debug APK is missing or empty" >&2
  exit 1
fi

if [[ -z "${RELEASE_APK}" || ! -s "${RELEASE_APK}" ]]; then
  echo "Release APK is missing or empty" >&2
  exit 1
fi

# APK is a ZIP container; this catches truncated/corrupt artifacts.
unzip -tq "${DEBUG_APK}" >/dev/null
unzip -tq "${RELEASE_APK}" >/dev/null

# The PHP Course Package must actually be packaged into both variants.
unzip -l "${DEBUG_APK}" | grep -q 'assets/course/php/manifest.json'
unzip -l "${RELEASE_APK}" | grep -q 'assets/course/php/manifest.json'
unzip -l "${DEBUG_APK}" | grep -q 'assets/course/php/levels.json'
unzip -l "${DEBUG_APK}" | grep -q 'assets/course/php/chapters.json'

BUILD_TOOLS="$(find "${ANDROID_HOME}/build-tools" -mindepth 1 -maxdepth 1 -type d | sort -V | tail -n 1)"
APKSIGNER="${BUILD_TOOLS}/apksigner"

if [[ ! -x "${APKSIGNER}" ]]; then
  echo "apksigner not found: ${APKSIGNER}" >&2
  exit 1
fi

# Debug variants are signed automatically by Android tooling and must verify.
"${APKSIGNER}" verify --verbose "${DEBUG_APK}"

# CI Release is deliberately unsigned until production secrets are configured.
if "${APKSIGNER}" verify "${RELEASE_APK}" >/dev/null 2>&1; then
  echo "Release APK is unexpectedly signed; review signing policy." >&2
  exit 1
else
  echo "Unsigned Release APK confirmed as expected."
fi

mkdir -p app/build/outputs/apk/checksums
sha256sum "${DEBUG_APK}" "${RELEASE_APK}" > app/build/outputs/apk/checksums/SHA256SUMS.txt

printf 'Debug APK: %s bytes\n' "$(stat -c%s "${DEBUG_APK}")"
printf 'Release APK: %s bytes\n' "$(stat -c%s "${RELEASE_APK}")"
cat app/build/outputs/apk/checksums/SHA256SUMS.txt
