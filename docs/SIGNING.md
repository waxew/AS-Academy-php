# Production signing

Production signing material must never be committed to this public repository.

The `Production Release` workflow expects these GitHub Actions repository secrets:

- `ANDROID_SIGNING_KEYSTORE_BASE64` — Base64 representation of the production `.jks`/keystore file.
- `ANDROID_SIGNING_STORE_PASSWORD` — keystore password.
- `ANDROID_SIGNING_KEY_ALIAS` — signing key alias.
- `ANDROID_SIGNING_KEY_PASSWORD` — signing key password.

The workflow restores the keystore only inside the temporary GitHub Actions runner, builds `release`, verifies the resulting APK with `apksigner`, generates SHA-256 and publishes GitHub Release `v0.4.0`.

## Update compatibility

All future public versions must keep:

- applicationId: `com.asdevelopers.academy.php`
- the same production signing key
- a strictly increasing `versionCode`

Changing the production signing key or applicationId prevents normal in-place updates over previously distributed versions.

## Current release

- versionName: `0.4.0`
- versionCode: `4`
- final file name: `AS-Academy-PHP-v0.4.0.apk`
