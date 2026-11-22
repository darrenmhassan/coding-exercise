# coding-exercise

Darren's coding-interview practice repo. Solutions are written in Java; the tooling is the
`coding` script (Python 3 standard library only). See README.md for usage.

- Problem bank: `bank/problems.json` (patterns use the names in `bank/patterns.json`, primary first).
- Patterns reference (from my notes): `docs/patterns-reference.md`.
- Pattern templates: `bank/templates/<pattern-slug>.java`.
- Progress logs are append-only JSONL in `progress/`; the spaced-repetition schedule is derived
  from `progress/attempts.jsonl`, so never rewrite or reorder those files.
- `progress/`, `attempts/` and `.practise/` are local-only and git-ignored: never commit them or
  push them anywhere. `/coding-stats` and `/coding-sessions` read only these local files.
- `/coding-drill` (`.claude/commands/coding-drill.md`) is the interactive pattern-recognition tutor; it uses
  `./coding drill-pick` and `./coding drill-log`.
- `/coding-coach` (`.claude/commands/coding-coach.md`) is a coached coding round; it uses `./coding next --json`,
  `start`, `done` and `drill-log`.
- In Claude sessions, suggest next steps as slash commands (`/coding-coach heaps`, `/coding-drill 6 graphs`, `/coding-next`),
  not `./coding` commands; the CLI prints slash-command hints itself when `CLAUDECODE` is set.
- When adding a problem, include an own-words `summary` and a small `example` (input -> output).
