# محتوای کامل دوره PHP

این پوشه محتوای اختصاصی PHP را نگه می‌دارد. قابلیت‌های عمومی اپ آموزشی از `AS-Academy-Core` تأمین می‌شوند.

## 01 — مبانی
### 1. PHP چیست؟
PHP یک زبان برنامه‌نویسی متن‌باز و عمدتاً سمت سرور برای توسعه وب است. کد PHP روی سرور اجرا و نتیجه، معمولاً HTML یا JSON، برای Client ارسال می‌شود.

```php
<?php
echo "سلام PHP";
```

### 2. نصب و محیط توسعه
PHP را می‌توان مستقل یا همراه XAMPP/Laragon/MAMP نصب کرد. پس از نصب:
```bash
php -v
php -S localhost:8000
```
فایل `index.php` را بسازید و با سرور داخلی PHP اجرا کنید.

### 3. Syntax، متغیر و نوع داده
```php
<?php
$name = "Ali";       // string
$age = 25;            // int
$price = 12.5;        // float
$isActive = true;     // bool
$nothing = null;      // null
```
متغیرها با `$` آغاز می‌شوند. نام متغیر باید معنادار باشد.

### 4. عملگرها و شرط
```php
$score = 85;
if ($score >= 90) {
    echo "عالی";
} elseif ($score >= 70) {
    echo "قبول";
} else {
    echo "نیاز به تمرین";
}
```

### 5. حلقه‌ها
```php
for ($i = 1; $i <= 5; $i++) {
    echo $i . PHP_EOL;
}
```
`while` برای تکرار شرطی و `foreach` برای پیمایش آرایه‌ها مناسب است.

### 6. آرایه‌ها
```php
$student = [
    'name' => 'Sara',
    'score' => 95,
];
echo $student['name'];
```

### 7. توابع
```php
function calculateTotal(float $price, int $count): float
{
    return $price * $count;
}
```
توابع باید یک مسئولیت روشن داشته باشند و تا حد ممکن type declaration داشته باشند.

## 02 — مقدماتی
### 8. فرم‌ها و HTTP
`$_GET` و `$_POST` ورودی HTTP را در اختیار PHP قرار می‌دهند. ورودی کاربر هرگز قابل اعتماد فرض نمی‌شود.
```php
$email = filter_input(INPUT_POST, 'email', FILTER_VALIDATE_EMAIL);
if ($email === false) {
    exit('ایمیل نامعتبر است');
}
```

### 9. Session و Cookie
Session برای نگهداری وضعیت سمت سرور استفاده می‌شود.
```php
session_start();
$_SESSION['user_id'] = 10;
```
پس از Login شناسه Session را regenerate کنید.

### 10. فایل و Upload
قبل از ذخیره فایل، حجم، MIME type، مجوز کاربر و نام مقصد بررسی شود. فایل آپلودشده را با نام تولیدشده توسط سرور ذخیره کنید.

### 11. SQL و MySQL
CRUD شامل Create، Read، Update و Delete است. طراحی جدول، کلید اصلی، کلید خارجی، Index و Transaction بخش ضروری این فصل است.

### 12. PDO
```php
$pdo = new PDO($dsn, $user, $password, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
]);
$stmt = $pdo->prepare('SELECT * FROM users WHERE email = :email');
$stmt->execute(['email' => $email]);
$user = $stmt->fetch(PDO::FETCH_ASSOC);
```
Prepared Statement دفاع پایه در برابر SQL Injection است.

### 13. CRUD واقعی
دانشجو سیستم کاربران را با Create/List/Show/Edit/Delete، جستجو، Pagination و Validation می‌سازد.

## 03 — پیشرفته
### 14. OOP
```php
final class Product
{
    public function __construct(
        public readonly int $id,
        public string $name,
        public int $price,
    ) {}
}
```
Class، Object، Encapsulation، Inheritance، Composition، Interface، Trait، Abstract Class و Polymorphism آموزش داده می‌شوند.

### 15. Composer و Autoload
```bash
composer init
composer install
composer dump-autoload
```
Namespace و PSR-4 برای سازمان‌دهی پروژه‌های واقعی استفاده می‌شوند.

### 16. Exception Handling
```php
try {
    // operation
} catch (Throwable $e) {
    error_log($e->getMessage());
    http_response_code(500);
}
```
جزئیات داخلی خطا در Production نباید به کاربر نمایش داده شود.

### 17. معماری MVC
Request وارد Router می‌شود، Controller جریان درخواست را هماهنگ می‌کند، Service منطق کاربردی و Repository دسترسی داده را مدیریت می‌کند، سپس Response تولید می‌شود.

### 18. SOLID و Design Patterns
SRP، OCP، LSP، ISP و DIP همراه Factory، Strategy، Adapter، Observer و Repository با مثال‌های PHP بررسی می‌شوند.

### 19. امنیت
موضوعات اصلی: SQL Injection، XSS، CSRF، Password Hashing، Session Security، Upload Security، Authorization، RBAC، Rate Limiting و مدیریت Secretها.
```php
$hash = password_hash($password, PASSWORD_DEFAULT);
$isValid = password_verify($password, $hash);
```

### 20. REST API
Endpointهای استاندارد با JSON، HTTP status code، Validation، Pagination، Filtering، Authentication، Authorization، Versioning و Error Envelope طراحی می‌شوند.

## 04 — تخصصی
### 21. Laravel
Installation، Artisan، Routing، Controller، Blade، Eloquent، Migration، Seeder، Factory، Middleware، Validation، Auth، Policies، Events، Queue، Cache، Storage و API Resources.

### 22. Testing
PHPUnit برای Unit/Integration/Feature/API Test استفاده می‌شود. تست‌ها باید رفتار و قرارداد عمومی سیستم را بررسی کنند، نه جزئیات پیاده‌سازی شکننده را.

### 23. Performance
OPcache، Index، Query Plan، جلوگیری از N+1، Cache، Redis، Queue، Pagination و Profiling بررسی می‌شوند.

### 24. Queue و Scheduler
کارهای کند مانند ایمیل، گزارش و پردازش فایل به Job پس‌زمینه منتقل می‌شوند. Retry، idempotency و failed jobs بخشی از طراحی Production هستند.

### 25. Docker
محیط آموزشی نهایی از PHP + Nginx + MySQL + Redis تشکیل می‌شود. Environmentهای development و production از هم تفکیک می‌شوند.

### 26. Git و CI/CD
Branch، Commit، PR، Tag، Semantic Versioning، تست خودکار و pipeline انتشار آموزش داده می‌شوند.

### 27. Deployment
Linux، SSH، DNS، HTTPS، Nginx/Apache، environment variables، permission، migration، backup، logging، monitoring و rollback پوشش داده می‌شوند.

### 28. Backend موبایل
Android/iOS از طریق HTTPS و JSON به API متصل می‌شوند. Token، Refresh، Upload، Pagination و مدیریت خطای شبکه در قرارداد API طراحی می‌شود.

## قواعد پایان دوره
دانشجو باید بتواند یک Backend را طراحی، پیاده‌سازی، تست، امن، مستندسازی و Deploy کند و دلایل تصمیم‌های معماری خود را توضیح دهد.
