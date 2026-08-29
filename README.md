# AS Academy PHP

اپ اندرویدی و Course Package فارسی برای **یادگیری PHP از صفر تا سطح تخصصی**.

## هدف
این پروژه یک کتاب Markdown صرف نیست. کاربر باید داخل اپ درس‌ها را مرحله‌به‌مرحله بخواند، مثال کد ببیند، تمرین و Quiz انجام دهد، پروژه بسازد و Progress خود را نگه دارد.

## معماری
زیرساخت عمومی از `AS-Academy-Core` به‌صورت Git submodule استفاده می‌شود. `MainActivity` فقط `AcademyCourseApp(courseId = "php")` را اجرا می‌کند؛ Navigation، UI، Progress، Search، Bookmark، Quiz/Exercise Engine، Database و Content Loader در Core باقی می‌مانند.

## مسیر آموزشی فعلی
- مبانی: PHP، نصب، Type، Operator، Condition، Loop، Array، Function
- مقدماتی: HTTP، Form، Session، Upload، SQL، PDO، CRUD
- پیشرفته: OOP، Composer/PSR، Exception، MVC، SOLID، Security، REST API
- تخصصی: Laravel، Eloquent، Validation/Policy، Testing، Redis، Queue، Performance، Docker، CI/CD و Deployment

## محتوای قابل اجرای اپ
محتوا در `course/php` مطابق قرارداد Core قرار دارد:
- `manifest.json`
- `levels.json`
- `chapters.json`
- `lessons/*.json`
- `exercises/*.json`
- `quizzes/*.json`
- `projects/*.json`
- `glossary/*.json`

## ساخت Android
```bash
git clone --recurse-submodules https://github.com/waxew/AS-Academy-php.git
cd AS-Academy-php
# سپس پروژه را با Android Studio/Gradle باز و app را build کنید.
```
اگر قبلاً clone شده:
```bash
git submodule update --init --recursive
```

## Package
`com.asdevelopers.academy.php`

## اصل توسعه
هر قابلیت مشترک بین دوره‌ها باید در `AS-Academy-Core` پیاده‌سازی شود. این مخزن فقط منطق و محتوای اختصاصی PHP را نگه می‌دارد.
