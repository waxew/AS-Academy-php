# معماری اپ آموزشی PHP

هدف محصول: کاربر اپ را باز کند، مسیر PHP را از صفر شروع کند، درس بخواند، کد ببیند، تمرین و آزمون انجام دهد، پروژه بسازد و پیشرفت خود را ادامه دهد.

## Runtime
`MainActivity -> AcademyCourseApp(courseId = "php") -> AS-Academy-Core`

Core مسئول App Shell، Navigation، Course Loader، Lesson Renderer، Progress، Search، Bookmark، Quiz، Exercise، Project، Glossary، Settings و Database است.

این ریپو فقط PHP-specific configuration/content را نگه می‌دارد.

## Course Package اجرایی
محتوا در مسیر استاندارد Android Assets نگه‌داری می‌شود:

`app/src/main/assets/course/php/manifest.json`
`app/src/main/assets/course/php/levels.json`
`app/src/main/assets/course/php/chapters.json`
`app/src/main/assets/course/php/lessons/*.json`
`app/src/main/assets/course/php/exercises/*.json`
`app/src/main/assets/course/php/quizzes/*.json`
`app/src/main/assets/course/php/projects/*.json`
`app/src/main/assets/course/php/glossary/*.json`

در زمان اجرا Core همچنان آن را با مسیر منطقی `course/php/...` می‌خواند.

## جریان یادگیری
Home -> Level -> Chapter -> Lesson -> Exercise/Quiz -> Complete -> Progress -> Next Lesson

Search و Bookmark برای برگشت سریع به مطالب و Projects برای یادگیری پروژه‌محور استفاده می‌شوند.
