---
description: Drop the current attempt without logging it.
allowed-tools: Bash(./coding abandon), Bash(./coding status)
---

Equivalent of `./coding abandon`. Run `./coding status`, tell me which attempt would be dropped
and ask me to confirm (it can't be undone). On yes, run `./coding abandon` and show the output.
