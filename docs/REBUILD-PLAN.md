# برنامه بازسازی AS Academy PHP

## هدف
بازسازی نسخه فعلی از Course Package کوچک به دوره 490 درسی مطابق MASTER-CURRICULUM و TEACHING-STANDARD، بدون تکرار زیرساخت مشترک Core.

## Source of Truth
- docs/MASTER-CURRICULUM.md: فهرست نهایی موضوعات و درس‌ها
- docs/TEACHING-STANDARD.md: قرارداد تدریس هر درس
- AS-Academy-Core: UI/Navigation/Database/Progress/Bookmark/Quiz/Exercise/Search/Settings
- app/src/main/assets/course/php: فقط محتوای runtime دوره PHP

## ساختار Course Package هدف
course/php/
- manifest.json
- levels.json
- chapters.json
- lessons/
- exercises/
- quizzes/
- projects/
- glossary/

## فاز 1 — Runtime Core QA (Blocker)
قبل از Release باید این رفتارها روی دستگاه/Emulator تأیید شوند:
- Mark as studied: toggle، persistence، undo
- Favorite/Bookmark: add/remove، persistence
- Progress: محاسبه مجدد بعد از مطالعه درس
- Search: باز کردن lesson صحیح
- Previous/Next navigation
- Quiz submission/scoring
- Exercise state
- Back navigation
هر اشکال مشترک در AS-Academy-Core اصلاح می‌شود، نه با کد اختصاصی PHP.

## فاز 2 — Migration محتوا
- 490 lesson ID پایدار ایجاد شود.
- درس‌های فعلی که قابل استفاده‌اند به ID/فصل جدید نگاشت و عمیق شوند.
- هیچ فایل placeholder مجاز نیست.
- هر درس باید قرارداد TEACHING-STANDARD را پاس کند.

## فاز 3 — Assessment
- حداقل 165 تمرین
- حداقل یک Quiz برای هر فصل
- Assessment برای هر سطح
- Final Assessment حداقل 60 سؤال
- پاسخ/Hint/Solution برای تمرین‌های مناسب

## فاز 4 — Projects
پروژه‌ها مرحله‌ای و وابسته به مهارت‌های آموخته‌شده هستند؛ از Hello PHP تا Production Ecommerce Capstone. پروژه نباید قبل از تدریس پیش‌نیازهایش نمایش داده شود.

## فاز 5 — Validation
Validator باید علاوه بر parse JSON این موارد را بررسی کند:
- تمام 490 lesson ID
- level/chapter/lesson references
- block types
- duplicate IDs
- exercise types و lesson references
- quiz answer IDs/correct answers
- project references
- glossary schema
- حداقل depth هر درس و نبود placeholder

## فاز 6 — Release Gate
Build موفق به تنهایی Release نیست. Release فقط بعد از Content Validation + Core Runtime QA + Device Smoke Test + APK integrity/signature verification انجام می‌شود.

## وضعیت نسخه 0.4.0
نسخه فعلی baseline توسعه محسوب می‌شود و به‌دلیل ناقص بودن Curriculum runtime و گزارش خرابی تعامل‌های UI، نسخه آموزشی نهایی نیست.
