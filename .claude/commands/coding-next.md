---
description: Start the next practice problem (due reviews, then the weakest high-value pattern).
argument-hint: "[pattern] [--timebox N] [--easy] [--premium] [--peek]"
allowed-tools: Bash(./practise next:*), Bash(./practise status)
---

Equivalent of `./practise next`. Arguments: `$ARGUMENTS`.

1. Run `./practise status`. If an attempt is in progress, tell me which and ask whether to replace it
   before going on (starting a new one discards it).
2. Run `./practise next` with my arguments: a bare pattern name or number becomes `-p "<pattern>"`;
   pass `--timebox`, `--easy`, `--premium`, `--peek` and `--no-open` through as given.
3. Show the output as printed in a ```text block. Don't name or hint at the pattern.
4. Remind me to write the solution in the file it created without running it, and to use `/coding-done`
   when finished (or `/coding-coach` next time for a coached round).
