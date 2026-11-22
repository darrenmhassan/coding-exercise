---
description: One row per completed drill session recorded in this directory.
argument-hint: "[N]   show only the last N sessions"
allowed-tools: Bash(./practise sessions:*)
---

Run `./practise sessions --markdown` (add `--last $ARGUMENTS` if a number was given). It reads only
this directory's local progress logs (`progress/`). Show the table exactly as printed, as a rendered
markdown table (not in a code block), with the legend line under it, and don't merge, total or
average across sessions. Then add at most 2 lines on what stands
out (e.g. a pattern missed in several sessions), with any suggested next step as a slash command
(e.g. `/coding-drill 6 cyclic sort` or `/coding-coach heaps`), not a `./practise` command.
