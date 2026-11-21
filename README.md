# coding-exercise

Pattern-based coding interview practice with spaced repetition. Problems are tagged with the
patterns from my Educative notes (`Vault/career/Programming Patterns Reference.md`), and the
`practise` CLI decides what to work on next, times each attempt, and tracks mastery by pattern.

Python 3.8+ standard library only. Solutions are written in Java.

## Daily loop

```sh
./practise plan              # the dated session plan and what's ticked off
./practise drill -n 15       # quick pattern-recognition warm-up (or /drill in Claude Code)
./practise next              # start the next problem; opens attempts/<date>_<id>/Solution.java
./practise status            # elapsed vs timebox
./practise done              # log it: pattern you used, rating 1-4, hints, notes
./practise stats             # mastery by pattern, sorted by what needs work most
```

How to do a problem: open the LeetCode link only to read the statement, write the solution in
the scaffold file **without running it** (the interview editor won't run code), talking aloud through
the five steps in the header (clarify, approach, code, test by hand, optimise). When you think it's
done, paste it into LeetCode. Rate honestly:

| rating | meaning |
|---|---|
| 1 again | couldn't solve it / needed the solution |
| 2 hard | solved with hints, bugs found by LeetCode, or well over time |
| 3 good | solved within the timebox, minor slips |
| 4 easy | fast, clean, optimal first time |

The pattern isn't shown when a problem starts, only after `done`, so recognition is practised too.

## Interactive tutor: `/drill` in Claude Code

```sh
cd ~/home/coding-exercise && claude
/drill            # 8 problems
/drill 12         # more
/drill 5 graphs   # focus on one pattern
```

Claude presents each problem as an Amazon-style scenario with an example, asks which pattern and
why, gives a guiding question if you're wrong, then explains the signals, the key insight, a Java
sketch of the solution, complexity and a common trap. It picks problems with
`./practise drill-pick` (weighted towards likely and previously missed patterns) and logs your first
answer with `./practise drill-log`, so `stats` and future picks include tutor sessions.
`./practise drill` remains as the quick offline version.

## Pattern templates

`bank/templates/<pattern>.java` holds a short reference implementation for each pattern (the
canonical loop shape, with comments on the key invariant and common variants). They're shown:

- in `drill` when you name the wrong pattern (after the "when to use" signals for both your answer
  and the right one); when you're right, press `t` to see it. `--code` always shows it, `--no-code` never;
- in `done` when the pattern you used doesn't match the bank;
- on demand with `./practise template graphs` (or no argument to pick from the menu).

Edit them freely; the file name is the pattern name in lower case with dashes.

## How `next` chooses

1. **Today's plan session** (`plan.json`): its problems in order, then its stretch problems.
2. **Due reviews**: problems whose spaced-repetition date has arrived, most overdue first.
   Intervals: first attempt 1/2/4/7 days for ratings 1-4, then roughly x1 / x1.2 / x2.5 / x3.5.
3. **New problem from the highest-need pattern**, where need = weight x (1 - mastery).
   Weight (1-5) is how likely the pattern is at Amazon; mastery blends latest ratings, coverage
   (3 problems tried counts as full coverage) and drill accuracy. Amazon-frequent Mediums first.

Filters: `--pattern graphs`, `--session sun`, `--premium` (allow LeetCode premium), `--easy`,
`--timebox 35`, `--peek` (show without starting).

## Other commands

- `./practise mock [problem]` copies a mock-interviewer prompt to the clipboard for a Claude chat
  (reworded Amazon scenario, clarifying questions, follow-ups, scoring on Amazon's coding
  dimensions) and starts a 35-minute timer.
- `./practise start <slug|number>` starts a specific problem.
- `./practise list [--pattern X] [--core]` shows the bank and your state per problem.
- `./practise patterns` lists patterns, weights and recognition signals.
- `./practise add` adds a problem (or pass `--slug --lc --title --difficulty --patterns --summary --example --core`).
- `./practise report -o ~/Documents/Vault/career/Coding\ practice\ report.md` writes a markdown report.
- `./practise abandon` drops the in-progress attempt.

## Files

| path | what |
|---|---|
| `bank/problems.json` | problem bank: slug, LeetCode number, patterns (primary first), Amazon-frequent flag, premium flag, one-line summary and a small input -> output example, both used by `drill` |
| `bank/patterns.json` | pattern names (match my notes), weight, recognition signals |
| `bank/templates/` | one Java reference template per pattern |
| `plan.json` | dated sessions (edit or replace for the next interview) |
| `progress/attempts.jsonl` | append-only attempt log; the schedule is derived from it |
| `progress/drills.jsonl` | drill answers |
| `attempts/` | my written solutions |
| `.claude/commands/drill.md` | the `/drill` tutor prompt (edit it to change how Claude teaches) |
| `.claude/settings.json` | turns off Claude Code's prompt suggestions in this repo (they give drill answers away) |

Everything except `.practise/` (the in-progress attempt) is meant to be committed, so history
travels with the repo.

## Ideas for later

- Local test cases per problem so solutions can be checked offline.
- Weight patterns per target company (separate weight sets in `patterns.json`).
- Track time-to-first-correct-approach separately from total time.
- A low-level design track (parking lot, rate limiter, file search) alongside the algorithm bank.
