#!/usr/bin/env python3
import json
import os
import sys
from pathlib import Path

REPO = Path(__file__).resolve().parents[1]
ROOT = Path(os.environ.get("ACADEMY_COURSE_ROOT", REPO / "app" / "src" / "main" / "assets" / "course" / "php"))
if not ROOT.is_absolute():
    ROOT = REPO / ROOT
errors = []


def fail(message: str) -> None:
    errors.append(message)


def load_json(path: Path):
    try:
        return json.loads(path.read_text(encoding="utf-8"))
    except Exception as exc:
        fail(f"Invalid JSON: {path.relative_to(ROOT)}: {exc}")
        return None


def unique_ids(items, label):
    seen = set()
    for item in items:
        item_id = item.get("id") if isinstance(item, dict) else None
        if not item_id:
            fail(f"Missing id in {label}")
            continue
        if item_id in seen:
            fail(f"Duplicate {label} id: {item_id}")
        seen.add(item_id)
    return seen

if not ROOT.exists():
    print(f"Course root does not exist: {ROOT}")
    sys.exit(1)

manifest = load_json(ROOT / "manifest.json") or {}
levels = load_json(ROOT / "levels.json") or []
chapters = load_json(ROOT / "chapters.json") or []

lesson_docs = [load_json(p) for p in sorted((ROOT / "lessons").glob("*.json"))]
exercise_docs = [load_json(p) for p in sorted((ROOT / "exercises").glob("*.json"))]
quiz_docs = [load_json(p) for p in sorted((ROOT / "quizzes").glob("*.json"))]
project_docs = [load_json(p) for p in sorted((ROOT / "projects").glob("*.json"))]
lesson_docs = [x for x in lesson_docs if isinstance(x, dict)]
exercise_docs = [x for x in exercise_docs if isinstance(x, dict)]
quiz_docs = [x for x in quiz_docs if isinstance(x, dict)]
project_docs = [x for x in project_docs if isinstance(x, dict)]

if manifest.get("courseId") != "php":
    fail("manifest.courseId must be php")

level_ids = unique_ids(levels, "level")
chapter_ids = unique_ids(chapters, "chapter")
lesson_ids = unique_ids(lesson_docs, "lesson")
unique_ids(exercise_docs, "exercise")
unique_ids(quiz_docs, "quiz")
unique_ids(project_docs, "project")

for chapter in chapters:
    if chapter.get("levelId") not in level_ids:
        fail(f"Chapter {chapter.get('id')} references missing level {chapter.get('levelId')}")

for lesson in lesson_docs:
    if lesson.get("chapterId") not in chapter_ids:
        fail(f"Lesson {lesson.get('id')} references missing chapter {lesson.get('chapterId')}")
    blocks = lesson.get("blocks")
    if not isinstance(blocks, list) or not blocks:
        fail(f"Lesson {lesson.get('id')} has no blocks")

allowed_exercise_types = {"WRITE_CODE", "COMPLETE_CODE", "READ_AND_ANSWER", "BUILD_FEATURE", "FIX_CODE", "PREDICT_OUTPUT"}
for exercise in exercise_docs:
    if exercise.get("lessonId") not in lesson_ids:
        fail(f"Exercise {exercise.get('id')} references missing lesson {exercise.get('lessonId')}")
    if exercise.get("type") not in allowed_exercise_types:
        fail(f"Exercise {exercise.get('id')} has unsupported type {exercise.get('type')}")

for quiz in quiz_docs:
    if quiz.get("lessonId") not in lesson_ids:
        fail(f"Quiz {quiz.get('id')} references missing lesson {quiz.get('lessonId')}")
    questions = quiz.get("questions")
    if not isinstance(questions, list) or not questions:
        fail(f"Quiz {quiz.get('id')} has no questions")
        continue
    unique_ids(questions, f"question in {quiz.get('id')}")
    for question in questions:
        answers = question.get("answers")
        if not isinstance(answers, list) or len(answers) < 2:
            fail(f"Question {question.get('id')} in {quiz.get('id')} needs at least 2 answers")
            continue
        if not any(a.get("isCorrect") is True for a in answers):
            fail(f"Question {question.get('id')} in {quiz.get('id')} has no correct answer")

for project in project_docs:
    for lesson_id in project.get("lessonIds", []):
        if lesson_id not in lesson_ids:
            fail(f"Project {project.get('id')} references missing lesson {lesson_id}")

minimums = {"lessons": 35, "exercises": 15, "quizzes": 7, "projects": 15}
counts = {
    "levels": len(levels),
    "chapters": len(chapters),
    "lessons": len(lesson_docs),
    "exercises": len(exercise_docs),
    "quizzes": len(quiz_docs),
    "projects": len(project_docs),
}
for key, minimum in minimums.items():
    if counts[key] < minimum:
        fail(f"Course depth regression: {key}={counts[key]} < {minimum}")

print(f"AS Academy PHP content inventory: {ROOT}")
for key, value in counts.items():
    print(f"- {key}: {value}")
print(f"- version: {manifest.get('version', 'unknown')}")

if errors:
    print("\nValidation failed:")
    for error in errors:
        print(f"- {error}")
    sys.exit(1)

print("\nValidation passed.")
