# Final QA — AS Academy PHP

## Quality gates

1. تمام JSONهای Course Package باید parse شوند.
2. تمام `levelId`، `chapterId` و `lessonId`ها باید به موجودیت واقعی اشاره کنند.
3. ID تکراری در Level/Chapter/Lesson/Exercise/Quiz/Project مجاز نیست.
4. هر Lesson باید حداقل یک block آموزشی داشته باشد.
5. هر Quiz باید سؤال و پاسخ صحیح داشته باشد.
6. نوع Exercise باید با قرارداد Core سازگار باشد.
7. عمق دوره نباید از حداقل‌های تعیین‌شده برای Lesson/Exercise/Quiz/Project پایین‌تر برود.
8. پس از Content Validation، Android Debug APK باید بدون خطا Build شود.

## حداقل محتوای نسخه جامع

- حداقل 35 درس مستقل
- حداقل 15 تمرین مستقل
- حداقل 7 آزمون
- حداقل 15 پروژه مرحله‌ای/نهایی
- چهار سطح مبانی، مقدماتی، پیشرفته و تخصصی

## CI

GitHub Actions ابتدا `tools/validate_course.py` را اجرا می‌کند و فقط در صورت موفقیت وارد Build Android می‌شود. این کار مانع انتشار Course Package دارای reference خراب یا JSON نامعتبر می‌شود.

## Release gate

نسخه Release فقط وقتی قابل اعلام است که:
- Content Validation سبز باشد.
- Android CI سبز باشد.
- APK Artifact تولید شود.
- نصب و Smoke Test روی دستگاه/Emulator انجام شود.
- versionCode/versionName و Signing برای Release نهایی مشخص باشند.
