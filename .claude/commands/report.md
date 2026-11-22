---
description: Markdown practice report (stats, drill sessions, attempts), shown or written to a file.
argument-hint: "[output path]"
allowed-tools: Bash(./practise report:*)
---

Equivalent of `./practise report`. Arguments: `$ARGUMENTS`.

With a path, run `./practise report -o "<path>"` and tell me where it was written. Without one, run
`./practise report` and show the markdown as rendered markdown (not in a code block). It reads only
the local progress logs.
