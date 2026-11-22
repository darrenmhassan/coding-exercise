---
description: Start a specific problem by slug, LeetCode number or part of the slug.
argument-hint: "<slug|number> [--timebox N] [--no-open]"
allowed-tools: Bash(./practise start:*), Bash(./practise status)
---

Equivalent of `./practise start`. Arguments: `$ARGUMENTS`.

If no problem was given, ask me which one. Otherwise run `./practise status` first; if an attempt is
in progress, ask whether to replace it. Then run `./practise start $ARGUMENTS` and show the output as
printed in a ```text block, without naming or hinting at the pattern. Remind me to use `/done` when
finished.
