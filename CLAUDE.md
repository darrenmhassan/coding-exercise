# coding-exercise

Darren's coding-interview practice repo. Solutions are written in Java; the tooling is the
`practise` script (Python 3 standard library only). See README.md for usage.

- Problem bank: `bank/problems.json` (patterns use the names in `bank/patterns.json`, primary first).
- Patterns reference (from my notes): `docs/patterns-reference.md`.
- Pattern templates: `bank/templates/<pattern-slug>.java`.
- Progress logs are append-only JSONL in `progress/`; the spaced-repetition schedule is derived
  from `progress/attempts.jsonl`, so never rewrite or reorder those files.
- `progress/`, `attempts/` and `.practise/` are local-only and git-ignored: never commit them or
  push them anywhere. `/practise-stats` and `/sessions` read only these local files.
- `/drill` (`.claude/commands/drill.md`) is the interactive pattern-recognition tutor; it uses
  `./practise drill-pick` and `./practise drill-log`.
- `/coach` (`.claude/commands/coach.md`) is a coached coding round; it uses `./practise next --json`,
  `start`, `done` and `drill-log`.
- In Claude sessions, suggest next steps as slash commands (`/coach heaps`, `/drill 6 graphs`, `/next`),
  not `./practise` commands; the CLI prints slash-command hints itself when `CLAUDECODE` is set.
- When adding a problem, include an own-words `summary` and a small `example` (input -> output).
