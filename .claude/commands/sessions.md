---
description: One row per completed drill session, from every device and cloud session.
argument-hint: "[N]   show only the last N sessions"
allowed-tools: Bash(./practise sessions:*)
---

Run `./practise sessions --sync` (add `--last $ARGUMENTS` if a number was given). It first merges the
progress logs from every device and cloud session. Show me the output exactly as printed, in a
```text block, and don't merge, total or average across sessions. Then add at most 2 lines on what
stands out (e.g. a pattern missed in several sessions). If the sync failed, say so in one line.
