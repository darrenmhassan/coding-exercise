---
description: Add a LeetCode problem to the bank.
argument-hint: "<LeetCode URL or slug>"
allowed-tools: Bash(./coding add:*), Bash(./coding patterns), Bash(./coding list:*), Read
---

Equivalent of `./coding add`. Arguments: `$ARGUMENTS`.

1. If no problem was given, ask for its LeetCode URL or slug. Check `bank/problems.json` doesn't
   already have it.
2. Draft every field: slug, LeetCode number, title, difficulty, patterns (names from
   `./coding patterns`, primary first), whether it's commonly asked, whether it's premium, an
   own-words one-line `summary`, and a small `example` (input -> output). Show me the draft and
   ask me to confirm or correct it.
3. On yes, run `./coding add --slug ... --lc ... --title "..." --difficulty ... --patterns "..."
   --summary "..." --example "..."` plus `--core` / `--premium` as agreed. Pass every value as a
   flag: anything missing waits for terminal input.
4. Show the output. The bank is committed to git, so ask whether to commit and push the change.
