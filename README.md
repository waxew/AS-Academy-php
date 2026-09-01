# AS Academy PHP

اپ Android اختصاصی PHP در معماری جدید AS Academy.

## معماری جدید

این ریپو دیگر محل اصلی نگهداری محتوای آموزشی یا UI مشترک نیست و به یک **Course Host سبک** تبدیل می‌شود:

```text
AS-Academy-MainCourse -> محتوای PHP
          |
          v
AS-Academy-PHP -> Host / applicationId / version / PHP branding
          |
          v
AS-Academy-MainUi -> UI/UX و Wiring مشترک
          |
          v
AS-Academy-Core -> Engine / Room / Repository / Contracts
```

### AS-Academy-Core
Database، Repository، Progress Engine، Quiz/Exercise/Search Engine، Content Contract و سرویس‌های زیرساختی مشترک.

### AS-Academy-MainUi
Home، Lesson Reader، Search UI، Bookmark، Progress، Quiz، Exercise، Project، Drawer/Profile، Settings، Theme و اتصال actionهای UI به Core.

### AS-Academy-MainCourse
Single Source of Truth تمام محتوای آموزشی. محتوای PHP در `courses/php/course` نگهداری می‌شود: Level، Chapter، Lesson، Exercise، Quiz، Project، Solution، Glossary و assets.

### AS-Academy-PHP
فقط applicationId، version، entry point، branding/capability اختصاصی PHP و packaging نهایی را نگه می‌دارد.

## وضعیت Migration

محتوای legacy فعلاً در `app/src/main/assets/course/php` وجود دارد تا Build فعلی نشکند. نسخه مرجع جدید PHP در `AS-Academy-MainCourse/courses/php/course` در حال انتقال است. بعد از تطبیق کامل و validation، duplicate legacy حذف می‌شود و build pipeline محتوای PHP را از MainCourse بسته‌بندی خواهد کرد.

## سطوح اصلی
- مبانی
- مقدماتی
- پیشرفته
- تخصصی

هدف دوره مرجع کامل PHP از صفر تا Production است؛ تعداد درس به‌تنهایی معیار نیست و هر Lesson باید واحد آموزشی واقعی با توضیح، مثال، نکته، خطای رایج و ارزیابی مناسب باشد.

## Package
`com.asdevelopers.academy.php`

## قانون توسعه
- تغییر محتوای PHP -> `AS-Academy-MainCourse`
- تغییر UI مشترک -> `AS-Academy-MainUi`
- تغییر Engine/Database/Repository/Contract -> `AS-Academy-Core`
- تغییر PHP-only host/branding/capability -> `AS-Academy-PHP`
