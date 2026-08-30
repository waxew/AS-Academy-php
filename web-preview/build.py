from pathlib import Path
import json, shutil

root = Path(__file__).resolve().parents[1]
src = root / 'app' / 'src' / 'main' / 'assets' / 'course' / 'php'
dst = root / 'web-preview' / 'dist'
course_dst = dst / 'course' / 'php'

if dst.exists():
    shutil.rmtree(dst)
dst.mkdir(parents=True)
shutil.copy2(root / 'web-preview' / 'src' / 'index.html', dst / 'index.html')
shutil.copy2(root / 'web-preview' / 'src' / 'styles.css', dst / 'styles.css')
shutil.copy2(root / 'web-preview' / 'src' / 'app.js', dst / 'app.js')
shutil.copytree(src, course_dst)

catalog = {}
for name in ['lessons', 'exercises', 'quizzes', 'projects']:
    folder = src / name
    catalog[name] = [p.name for p in sorted(folder.glob('*.json'))]
(dst / 'catalog.json').write_text(json.dumps(catalog, ensure_ascii=False, indent=2), encoding='utf-8')
print('Web preview built:', dst)
