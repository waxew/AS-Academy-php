# راه‌اندازی محیط دوره PHP

## حداقل ابزارها
- PHP 8.x مدرن و پشتیبانی‌شده
- Composer
- MySQL یا MariaDB برای فصل دیتابیس
- Git
- یک Editor مانند VS Code یا PhpStorm
- Docker برای سطح تخصصی

## بررسی نصب
```bash
php -v
composer --version
git --version
```

## اجرای مثال‌های ساده
```bash
php examples/01-basics/index.php
```

## اجرای API نمونه
```bash
php -S localhost:8000 -t examples/03-api
```
سپس `/api/v1/health` را باز کنید.

## دیتابیس
مثال PDO اطلاعات واقعی را hard-code نمی‌کند. Environmentهای زیر را تعریف کنید:
```text
DB_DSN=mysql:host=127.0.0.1;dbname=academy;charset=utf8mb4
DB_USER=your_user
DB_PASSWORD=your_password
```

## نکته امنیتی
`.env` واقعی، password، token و private key را commit نکنید.
