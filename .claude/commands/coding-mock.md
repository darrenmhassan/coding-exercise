---
description: Copy a mock-interviewer prompt for a separate Claude chat and start a 35-minute attempt.
argument-hint: "[problem]   omit for a random unseen, commonly asked problem"
allowed-tools: Bash(./coding mock:*), Bash(./coding status)
---

Equivalent of `./coding mock`. Arguments: `$ARGUMENTS`.

Run `./coding status` first; if an attempt is in progress, ask whether to replace it. Then run
`./coding mock $ARGUMENTS` (never `--show`, which would reveal the problem here). Tell me the prompt
is on the clipboard to paste into a new Claude chat, that the 35-minute timer has started, and to use
`/coding-done` afterwards. Don't name the problem or its pattern. For a coached round in this chat instead,
use `/coding-coach`.
