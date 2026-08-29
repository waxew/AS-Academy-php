# Release readiness — AS Academy PHP 0.4.0

## Version
- applicationId: `com.asdevelopers.academy.php`
- versionCode: `4`
- versionName: `0.4.0`
- Course Package version: `0.4.0`

## Automated gates
- Course JSON validation
- ID/reference validation
- minimum depth regression checks
- Android Debug build
- Android Release build

## Artifacts
CI produces:
- `as-academy-php-debug-v0.4.0`
- `as-academy-php-release-unsigned-v0.4.0`

The Release APK generated in CI is intentionally unsigned until a production signing key is configured securely. Signing credentials must never be committed to Git.

## Before public release
1. Configure production signing through secure GitHub secrets or local protected signing setup.
2. Produce signed Release APK/AAB.
3. Verify APK signature.
4. Install over previous version and verify update behavior.
5. Run smoke tests: launch, level list, lesson rendering, search, bookmark, quiz, exercise, progress persistence and back navigation.
6. Record SHA-256 for final distributable.

## Content state
The course includes four levels, machine-readable lessons, exercises, quizzes, specialist glossary and fifteen project tracks, including a production capstone.
