---
description: List the pattern weight profiles, or choose the one in use.
argument-hint: "[profile | --off]"
allowed-tools: Bash(./coding weights:*), Bash(./coding stats)
---

Equivalent of `./coding weights`. Arguments: `$ARGUMENTS`.

Run `./coding weights $ARGUMENTS` and show the output as printed in a ```text block. If I asked
for a new profile that doesn't exist yet, offer to create `.practise/weights/<name>.json` (local,
git-ignored): only the patterns that differ from `bank/patterns.json`, weights 1-5, plus a `_note`.
