# معماری اپ آموزشی PHP

هدف محصول: کاربر اپ را باز کند، مسیر PHP را از صفر شروع کند، درس بخواند، کد ببیند، تمرین و آزمون انجام دهد، پروژه بسازد و پیشرفت خود را ادامه دهد.

## Runtime
`MainActivity -> AcademyCourseApp(courseId = "php") -> AS-Academy-Core`

Core مسئول App Shell، Navigation، Course Loader، Lesson Renderer، Progress، Search، Bookmark، Quiz، Exercise، Project، Glossary، Settings و Database است.

این ریپو فقط PHP-specific configuration/content را نگه می‌دارد.

## Course Package اجرایی
`course/php/manifest.json`
`course/php/levels.json`
`course/php/chapters.json`
`course/php/lessons/*.json`
`course/php/exercises/*.json`
`course/php/quizzes/*.json`
`course/php/projects/*.json`
`course/php/glossary/*.json`

## جریان یادگیری
Home -> Level -> Chapter -> Lesson -> Exercise/Quiz -> Complete -> Progress -> Next Lesson

Search و Bookmark برای برگشت سریع به مطالب و Projects برای یادگیری پروژه‌محور استفاده می‌شوند.
