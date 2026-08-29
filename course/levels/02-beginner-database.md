# سطح 02 — PHP مقدماتی و دیتابیس

## هدف سطح
ساخت برنامه وب stateful با فرم، Session، File Upload و MySQL/PDO.

## درس 10 — HTTP و Superglobalها
`$_GET`, `$_POST`, `$_SERVER`, `$_FILES`, `$_COOKIE`, `$_SESSION` معرفی می‌شوند. داده ورودی قبل از استفاده باید validate شود.

## درس 11 — Form و Validation
```php
$email = filter_input(INPUT_POST, 'email', FILTER_VALIDATE_EMAIL);
if (!$email) {
    $errors['email'] = 'ایمیل معتبر نیست.';
}
```
Validation با Sanitization یکسان نیست؛ اولی صحت داده را بررسی می‌کند.

## درس 12 — Session و Cookie
```php
session_start();
session_regenerate_id(true);
$_SESSION['user_id'] = $userId;
```
Cookieهای حساس باید Secure/HttpOnly/SameSite مناسب داشته باشند.

## درس 13 — File I/O و Upload
فایل با `is_uploaded_file` و `move_uploaded_file` مدیریت می‌شود. MIME، اندازه، نام مقصد و authorization باید بررسی شوند.

## درس 14 — طراحی دیتابیس
Entity، Table، Row، Primary Key، Foreign Key، Constraint، Normalization و Index معرفی می‌شوند.

## درس 15 — SQL
SELECT/INSERT/UPDATE/DELETE، WHERE، JOIN، GROUP BY، ORDER BY، aggregateها و Transaction.

## درس 16 — PDO
```php
$stmt = $pdo->prepare('SELECT id, name FROM users WHERE email = :email');
$stmt->execute(['email' => $email]);
```
هیچ ورودی کاربر مستقیماً به رشته SQL متصل نمی‌شود.

## درس 17 — CRUD
Create/List/Show/Edit/Delete با validation، PRG pattern و مدیریت خطا ساخته می‌شود.

## درس 18 — Search و Pagination
Query parameterها برای page، search، sort و filter به‌شکل whitelist شده مدیریت می‌شوند.

## پروژه سطح
سیستم مدیریت مخاطبین با Login، CRUD، Search، Pagination و MySQL/PDO.

## معیار تسلط
دانشجو باید schema دیتابیس را طراحی و یک CRUD امن و قابل استفاده بدون framework بسازد.
