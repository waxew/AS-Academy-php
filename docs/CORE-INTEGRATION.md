# اتصال دوره PHP به AS Academy Core

این ریپو یک **Course Package** است و نباید منطق عمومی Academy را کپی کند.

## از AS-Academy-Core استفاده می‌شود
- Navigation و Shell اپ
- Design System و Theme framework
- Progress tracking
- Quiz engine
- Exercise engine
- Search
- Bookmark
- Settings
- Drawer/Profile
- Database/Room زیرساخت عمومی
- Content Engine / Updater
- Course schema و validation

## متعلق به این ریپو است
- `manifest.json` دوره PHP
- متن درس‌های PHP
- مثال‌های PHP
- Quiz/Exercise اختصاصی PHP
- پروژه‌های PHP/Laravel
- Glossary اختصاصی
- branding و capabilityهای PHP

## قانون تغییر
هر قابلیت قابل استفاده برای چند دوره باید ابتدا در `AS-Academy-Core` طراحی شود. این ریپو فقط configuration/content موردنیاز آن قابلیت را ارائه می‌کند.

## قرارداد فعلی
- courseId: `php`
- contentSchemaVersion: `1`
- minimumCoreVersion: `0.1.0`
- RTL: فعال
- codeRunner/terminal/diagrams/quizzes/exercises/projects/glossary: فعال

## امنیت
هیچ password، token، signing key، API key یا credential واقعی نباید در Course Package commit شود. مثال‌ها فقط از placeholder و `.env.example` استفاده می‌کنند.
