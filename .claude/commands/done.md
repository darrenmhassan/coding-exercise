---
description: Log the current attempt (pattern used, rating 1-4, hints, notes) and see the answer.
argument-hint: "[rating] [pattern] [hints] [notes]"
allowed-tools: Bash(./practise done:*), Bash(./practise status), Bash(./practise patterns)
---

Equivalent of `./practise done`. Arguments: `$ARGUMENTS`.

1. Run `./practise status`. If nothing is in progress, say so and stop.
2. I need to give four things. Take any already in my arguments and ask for the rest in ONE message:
   - the pattern I used (a number or name from `./practise patterns`; don't suggest one);
   - a rating: 1 again (couldn't solve / needed the solution), 2 hard (solved with hints, bugs
     LeetCode found, or well over time), 3 good (within the timebox, minor slips), 4 easy (fast,
     clean, optimal first time);
   - hints used (default 0);
   - notes: mistakes and the key insight (optional).
3. Run `./practise done -u "<pattern>" -r <rating> --hints <n> -n "<notes>"`, always with all four
   flags: without them it waits for terminal input. Add `-m <minutes>` only if I correct the time.
4. Show the output as printed in a ```text block (it reveals the bank's pattern and the template if
   mine differed), then add one line on what to do next (`/next`, `/coach` or `/drill`).
