---
description: Check the current attempt's solution, then log it with a rating derived from how it went.
argument-hint: "[notes]"
allowed-tools: Bash(./practise done:*), Bash(./practise status), Bash(./practise patterns), Bash(javac:*), Bash(java:*), Read, Write, Edit
---

Equivalent of `./practise done`. I don't rate myself: you measure how the attempt went and
`practise` derives the rating from that. Arguments: `$ARGUMENTS` (optional notes).

1. Run `./practise status`. If nothing is in progress, say so and stop. Note the problem and the
   solution file it names (`attempts/<date>_<id>/Solution.java`). If I pasted code into the chat
   instead, save it into that file first.
2. **Pattern used:** read the solution and decide which pattern it actually uses, from the names in
   `./practise patterns`. Don't ask me, and don't reveal the bank's pattern yet.
3. **Correctness:** write `Main.java` in the same folder that runs the problem's example plus 3-4 edge
   cases (empty / single element / duplicates / large or boundary values, whichever apply), compile
   and run it with `javac` and `java` in that folder.
   - All pass on the first run: result `pass`.
   - Something fails: show me the failing input and expected vs actual output, without the fix,
     and let me fix it. Re-run after each fix and count the fixes as bugs. If it passes, result
     `fixed`. If I give up or ask for the solution, result `fail`.
4. **Complexity:** compare the solution's time and space complexity with the optimal one for this
   problem. Suboptimal if either is worse.
5. **Hints:** ask me one question only: how many hints did I use (looked something up, asked for
   help, saw part of a solution)? If I saw a full solution, the result is `fail`.
6. Run `./practise done -u "<pattern>" --result <pass|fixed|fail> --bugs <n> --hints <n>
   --optimal|--suboptimal -n "<one line: the main mistake or insight, plus my notes>"`, always with
   every flag: without them it waits for terminal input. Add `-m <minutes>` only if I say the timer
   was wrong (e.g. I started late).
7. Show the output as printed in a ```text block (the derived rating with its reasons, the bank's
   pattern, and the next review date), then one line on what to work on next.
