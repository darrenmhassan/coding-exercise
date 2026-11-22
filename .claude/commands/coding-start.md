---
description: Start a specific problem by slug, LeetCode number or part of the slug.
argument-hint: "<slug|number> [--timebox N] [--no-open]"
allowed-tools: Bash(./coding start:*), Bash(./coding status)
---

Equivalent of `./coding start`. Arguments: `$ARGUMENTS`.

If no problem was given, ask me which one. Otherwise run `./coding status` first; if an attempt is
in progress, ask whether to replace it. Then run `./coding start $ARGUMENTS` and show the output as
printed in a ```text block, without naming or hinting at the pattern. Remind me to use `/coding-done` when
finished.
