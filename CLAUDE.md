# coding-exercise

Darren's coding-interview practice repo. Solutions are written in Java; the tooling is the
`practise` script (Python 3 standard library only). See README.md for usage.

- Problem bank: `bank/problems.json` (patterns use the names in `bank/patterns.json`, primary first).
- Pattern templates: `bank/templates/<pattern-slug>.java`.
- Progress logs are append-only JSONL in `progress/`; the spaced-repetition schedule is derived
  from `progress/attempts.jsonl`. Don't edit them by hand; only `practise sync` rewrites them
  (union of lines across devices, attempts sorted by start time).
- Every recorded answer is synced to GitHub automatically (`practise sync`); `/stats` and
  `/sessions` show results from all devices.
- `/drill` (`.claude/commands/drill.md`) is the interactive pattern-recognition tutor; it uses
  `./practise drill-pick` and `./practise drill-log`.
- `/coach` (`.claude/commands/coach.md`) is a coached coding round; it uses `./practise next --json`,
  `start`, `done` and `drill-log`.
- When adding a problem, include an own-words `summary` and a small `example` (input -> output).
