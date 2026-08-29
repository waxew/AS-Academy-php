<?php
// AS Academy PHP — نمونه PDO امن برای آموزش CRUD.
declare(strict_types=1);

// اطلاعات واقعی اتصال باید از Environment خوانده شوند، نه از Git.
$dsn = getenv('DB_DSN') ?: 'mysql:host=127.0.0.1;dbname=academy;charset=utf8mb4';
$dbUser = getenv('DB_USER') ?: 'root';
$dbPassword = getenv('DB_PASSWORD') ?: '';

// PDO در حالت Exception خطاهای دیتابیس را قابل مدیریت می‌کند.
$pdo = new PDO($dsn, $dbUser, $dbPassword, [
    PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
    PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
]);

// مقدار نمونه؛ در برنامه واقعی پس از validation از Request دریافت می‌شود.
$email = 'student@example.com';

// Prepared Statement از الحاق مستقیم ورودی کاربر به SQL جلوگیری می‌کند.
$statement = $pdo->prepare('SELECT id, name, email FROM users WHERE email = :email LIMIT 1');
$statement->execute(['email' => $email]);

// اگر رکورد وجود نداشته باشد false برمی‌گردد.
$user = $statement->fetch();
var_export($user);
