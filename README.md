# AS Academy PHP

مرجع فارسی پروژه‌محور **PHP از صفر تا تخصصی** و Course Package رسمی PHP برای معماری AS Academy.

## وضعیت
**v1.0.0 — بسته پایه کامل دوره**

## معماری AS Academy
این مخزن فقط محتوای اختصاصی PHP را نگه می‌دارد. زیرساخت‌های مشترک شامل Navigation، Design System، Progress، Quiz، Exercise، Search، Bookmark، Settings، Drawer/Profile، Database و Content Engine در مخزن `AS-Academy-Core` نگهداری می‌شوند.

قرارداد دوره در `course/manifest.json` قرار دارد و با `contentSchemaVersion: 1` و حداقل Core نسخه `0.1.0` تعریف شده است.

## مسیر آموزشی
1. مبانی — نصب، Syntax، Type، Operator، Condition، Loop، Array، Function
2. مقدماتی — HTTP/Form، Session/Cookie، File/Upload، SQL/MySQL، PDO، CRUD
3. پیشرفته — OOP، Composer/PSR، Exception، MVC، SOLID، Security، REST API
4. تخصصی — Laravel، Testing، Performance، Redis، Queue، Docker، CI/CD، Deployment و Backend موبایل

## ساختار واقعی مخزن
```text
AS-Academy-php/
├── course/
│   ├── manifest.json
│   ├── CONTENT.md
│   ├── EXERCISES-QUIZZES.md
│   ├── PROJECTS.md
│   └── GLOSSARY.md
├── examples/
│   ├── 01-basics/index.php
│   ├── 02-database/pdo.php
│   └── 03-api/index.php
├── docs/
│   ├── COURSE-ROADMAP.md
│   └── CORE-INTEGRATION.md
├── CHANGELOG.md
└── README.md
```

## پروژه‌های عملی
مسیر پروژه‌ها از Calculator و Contact Form شروع می‌شود و به Todo، Phone Book، Authentication، User Manager، Blog، File Manager، Invoice، REST API، Appointment، E-commerce، Mobile Backend، Laravel Production و Master Project می‌رسد.

## استاندارد آموزش
هر بخش متناسب با موضوع شامل توضیح مفهومی، Syntax، مثال، توضیح کد، نکات امنیتی، خطاهای رایج، تمرین، Quiz و پروژه است. مثال‌های سورس برای هدف آموزشی دارای کامنت توضیحی هستند.

## امنیت
Credential، password، token، API key و Secret واقعی نباید در این مخزن ذخیره شود. مثال‌های اتصال از Environment Variable و placeholder استفاده می‌کنند.

## هدف نهایی
دانشجو پس از تکمیل مسیر باید بتواند Backend واقعی PHP/Laravel را طراحی، پیاده‌سازی، تست، امن‌سازی، مستندسازی و Deploy کند و API مناسب وب و اپلیکیشن موبایل ارائه دهد.
