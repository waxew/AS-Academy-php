# سطح 01 — مبانی PHP

## هدف سطح
در پایان این سطح دانشجو باید بتواند PHP را نصب و اجرا کند، Syntax پایه را بخواند و بنویسد، متغیرها و انواع داده را مدیریت کند، شرط و حلقه بسازد و با Array و Function مسئله‌های ساده را حل کند.

## درس 01 — PHP چیست؟
PHP یک زبان سمت سرور است. مرورگر کد PHP را مستقیماً اجرا نمی‌کند؛ درخواست به سرور می‌رسد، PHP اجرا می‌شود و نتیجه برای Client ارسال می‌شود.

## درس 02 — نصب و اجرای محلی
```bash
php -v
php -S localhost:8000
```
فایل `index.php` را در پوشه پروژه قرار دهید و آدرس `http://localhost:8000` را باز کنید.

## درس 03 — Syntax و خروجی
```php
<?php
// چاپ متن ساده.
echo "Hello PHP";
```
هر Statement معمولاً با `;` پایان می‌یابد.

## درس 04 — متغیرها و انواع داده
```php
$name = 'Sara';
$age = 22;
$score = 18.75;
$isActive = true;
$tags = ['php', 'web'];
```
انواع مهم: string، int، float، bool، array، null و object.

## درس 05 — Operatorها
Arithmetic، Assignment، Comparison، Logical و String concatenation بررسی می‌شوند. برای مقایسه دقیق مقدار و نوع از `===` استفاده کنید.

## درس 06 — شرط‌ها
```php
if ($score >= 17) {
    echo 'عالی';
} elseif ($score >= 12) {
    echo 'قبول';
} else {
    echo 'نیاز به تمرین';
}
```
`match` برای انتخاب‌های مقدارمحور خواناتر از زنجیره شرط‌های ساده است.

## درس 07 — حلقه‌ها
`for` برای شمارنده، `while` برای تکرار شرطی و `foreach` برای آرایه‌ها استفاده می‌شود.

## درس 08 — Array
Indexed، Associative و Multidimensional Array همراه `count`, `array_map`, `array_filter`, `array_reduce` و sortها تمرین می‌شوند.

## درس 09 — Function
```php
function calculateDiscount(float $price, float $percent): float
{
    return $price - ($price * $percent / 100);
}
```
تمرکز این درس بر parameter، return، scope، type declaration و pure functionهای ساده است.

## پروژه سطح
یک «محاسبه‌گر خرید» بسازید که چند کالا را در آرایه نگه دارد، جمع، تخفیف و مبلغ نهایی را محاسبه کند و خروجی خوانا چاپ کند.

## معیار تسلط
دانشجو باید بتواند بدون کپی‌کردن مثال، مسئله‌ای شامل ورودی، شرط، حلقه، آرایه و تابع را حل کند.
