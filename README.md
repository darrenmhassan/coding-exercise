# coding-exercise

Pattern-based coding interview practice with spaced repetition. Problems are tagged with the
patterns from my Educative notes (`Vault/career/Programming Patterns Reference.md`), and the
`practise` CLI decides what to work on next, times each attempt, and tracks mastery by pattern.

Python 3.8+ standard library only. Solutions are written in Java.

## Daily loop

```sh
./practise plan              # the dated session plan and what's ticked off
./practise drill -n 15       # quick pattern-recognition warm-up, default 10 (or /drill in Claude Code)
./practise next              # start the next problem; opens attempts/<date>_<id>/Solution.java
./practise status            # elapsed vs timebox
./practise done              # log it: pattern you used, rating 1-4, hints, notes
./practise stats             # mastery by pattern, sorted by what needs work most
```

`done` asks for anything you don't pass as a flag: `-r/--rating 1-4`, `-u/--used <pattern>`,
`--hints N`, `-n/--notes "..."`, and `-m/--minutes N` to override the elapsed time.

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

Claude presents each problem as a realistic industry scenario with an example, asks which pattern and
why, gives a guiding question if you're wrong, then explains the signals, the key insight, a Java
sketch of the solution, complexity and a common trap. It picks problems with
`./practise drill-pick` (weighted towards likely and previously missed patterns), logs your first
answer with `./practise drill-log` (plus your retry after a guiding question, shown as "fixed after
hint" but not counted in the score), and closes the session with `./practise drill-end` (`--stopped`
if you stop early, which keeps it out of the session history). So `stats`, `sessions` and future picks
include tutor sessions.
`./practise drill [-n N] [-p pattern]` remains as the quick offline version. Both pick problems at random, weighted by the same
pattern need as `next` (heavy patterns you're weak in or haven't tried come up most), towards problems
you've missed, and away from ones you drilled in the last few days, so restarting gives you a different set.

## Coached coding: `/coach` in Claude Code

```sh
/coach              # next problem from the schedule (plan > due > weakest pattern)
/coach graphs       # a problem from one pattern
/coach lru-cache    # a specific problem
```

One interview-style round, about 30-45 minutes. Claude presents the problem as a scenario, you name
the pattern, then clarify requirements and outline the approach before coding. You code in
`attempts/<date>_<id>/Solution.java` (or paste into the chat) with a 30-minute timer, and say
"hint" for a hint ladder: a guiding question, then the structure, then a line or two of code,
never the whole solution unless you say "give up". When you're done, Claude reviews it
whiteboard-style (you trace the example; it points at failing inputs rather than fixing them), then
verifies it with a small `Main.java` harness, asks a follow-up, proposes a rating and logs it with
`./practise done`, so it feeds the spaced-repetition schedule like any other attempt.

Use `/drill` for fast recognition reps and `/coach` for full problems.

## Progress: `/stats` and `/sessions` in Claude Code

```sh
/stats          # ./practise stats: mastery by pattern, plus the 2-3 patterns that need work most
/sessions       # ./practise sessions: one row per completed drill session
/sessions 5     # only the last 5
```

Both read only the local logs in `progress/` and show the table as printed, with a short note on
what stands out.

## Slash commands for every practise command

In Claude Code, each user-facing `./practise` command has a slash command that runs it, asks in the
chat for anything the command would otherwise prompt for, and keeps the pattern hidden until it's
meant to be revealed:

| slash command | runs | notes |
|---|---|---|
| `/next [pattern]` | `next` | checks for an attempt in progress first |
| `/start <problem>` | `start` | |
| `/practise-status` | `status` | `/status` is built into Claude Code |
| `/done [rating] [pattern] [hints] [notes]` | `done` | asks for whatever you didn't pass |
| `/abandon` | `abandon` | asks you to confirm |
| `/drill [count] [pattern]` | the tutor (see above) | replaces the offline `drill` quiz in Claude Code |
| `/coach [pattern or problem]` | coached round (see below) | |
| `/stats`, `/sessions [N]` | `stats`, `sessions` | |
| `/template [pattern]` | `template` | |
| `/report [path]` | `report` | |
| `/practise-plan` | `plan` | `/plan` is built into Claude Code |
| `/list [pattern] [--core]` | `list` | |
| `/patterns` | `patterns` | |
| `/mock [problem]` | `mock` | prompt goes to the clipboard, never shown in the chat |
| `/add <URL or slug>` | `add` | drafts every field for you to confirm |
| `/weights [profile or --off]` | `weights` | |

`drill-pick`, `drill-log` and `drill-end` have none: they're the plumbing `/drill` and `/coach` use.

## Pattern templates

`bank/templates/<pattern>.java` holds a short reference implementation for each pattern (the
canonical loop shape, with comments on the key invariant and common variants). They're shown:

- in `drill` when you name the wrong pattern (after the "when to use" signals for both your answer
  and the right one); when you're right, press `t` to see it. `--code` always shows it, `--no-code` never;
- in `done` when the pattern you used doesn't match the bank;
- on demand with `./practise template graphs` (or no argument to pick from the menu).

Edit them freely; the file name is the pattern name in lower case with dashes.

## How `next` chooses

1. **Today's plan session**, if you have a plan: its problems in order, then its stretch problems.
   Plans are optional and local: copy `plan.example.json` to `.practise/plan.json` (git-ignored) and
   set your own dates, or point `PRACTISE_PLAN` at a file elsewhere.
2. **Due reviews**: problems whose spaced-repetition date has arrived, most overdue first.
   Intervals: first attempt 1/2/4/7 days for ratings 1-4, then roughly x1 / x1.2 / x2.5 / x3.5.
3. **New problem from the highest-need pattern**, where need = weight x (1 - mastery).
   Weight (1-5) is how often the pattern comes up in interviews; mastery blends latest ratings, coverage
   (3 problems tried counts as full coverage) and drill accuracy. Commonly asked Mediums first.

Weights can be tuned per company or interview without changing the bank. Each profile is a local,
git-ignored file `.practise/weights/<name>.json` of overrides, e.g. `{"_note": "...", "Trie": 4}`:
unlisted patterns keep their default, keys starting with `_` are notes, and an unknown pattern name
is an error. Choose one with:

```sh
./practise weights            # list profiles and show the active one
./practise weights <name>     # use that profile from now on
./practise weights --off      # back to the defaults in bank/patterns.json
```

`PRACTISE_WEIGHTS=<name or path>` overrides the choice for one run. The active profile applies to
`next`, `/coach`, `/drill`, `stats` and `patterns`, and `stats` names it at the top.

Filters: `-p/--pattern graphs`, `-s/--session sun`, `--premium` (allow LeetCode premium), `--easy`,
`-t/--timebox 35`, `--peek` (show without starting), `--no-open` (don't open the editor) and `--json`
(print the pick as JSON without starting it; used by `/coach`).

## Other commands

- `./practise mock [problem]` copies a mock-interviewer prompt to the clipboard for a Claude chat
  (reworded industry scenario, clarifying questions, follow-ups, scoring on problem solving,
  DS&A, logical & maintainable code and communication) and starts a 35-minute timer. `--show`
  prints the prompt instead of copying it.
- `./practise start <slug|number> [-t minutes] [--no-open]` starts a specific problem.
- `./practise list [--pattern X] [--core]` shows the bank and your state per problem.
- `./practise patterns` lists patterns, weights and recognition signals.
- `./practise add` adds a problem (or pass `--slug --lc --title --difficulty --patterns --summary --example --core --premium`).
- `./practise report` prints a markdown report; `-o ~/Documents/Vault/career/Coding\ practice\ report.md`
  writes it to a file instead.
- `./practise abandon` drops the in-progress attempt.
- `./practise sessions [--last N] [--markdown]` shows one row per completed drill session (`/drill` or
  `./practise drill`): when, how, focus, answered, correct, score, misses fixed after a hint, hints, minutes and the patterns missed.
  Sessions are never merged, and stopped or unfinished ones are left out. `report` includes the table too.

## Files

| path | what |
|---|---|
| `bank/problems.json` | problem bank: slug, LeetCode number, patterns (primary first), commonly-asked flag, premium flag, one-line summary and a small input -> output example, both used by `drill` |
| `bank/patterns.json` | pattern names (match my notes), weight, recognition signals |
| `bank/templates/` | one Java reference template per pattern |
| `.practise/plan.json` | optional dated sessions, local only (copy `plan.example.json`) |
| `.practise/weights/` | optional weight profiles per company, `<name>.json`, plus `active` naming the one in use; local only |
| `progress/attempts.jsonl` | append-only attempt log; the schedule is derived from it (local only) |
| `progress/drills.jsonl` | drill answers (tagged with their session) |
| `progress/drill_sessions.jsonl` | start and end of each drill session |
| `attempts/` | my written solutions (local only) |
| `.claude/commands/drill.md` | the `/drill` tutor prompt (edit it to change how Claude teaches) |
| `.claude/commands/coach.md` | the `/coach` coached-coding prompt |
| `.claude/commands/stats.md`, `sessions.md` | `/stats` and `/sessions`, reading the local logs |
| `.claude/commands/*.md` | the other slash commands, one per `practise` command |
| `.claude/settings.json` | turns off Claude Code's prompt suggestions in this repo (they give drill answers away) |

## Where your progress lives

Everything you record (attempt and drill logs in `progress/`, solutions in `attempts/`) stays in
this directory on this machine and is git-ignored, so none of it goes to GitHub. Run sessions from
this directory, in the terminal or in the Claude app with this folder; `/stats`, `/sessions` and
`./practise stats` / `sessions` read only these local files. To back it up, copy `progress/` and
`attempts/` somewhere safe.

`.practise/` holds the in-progress attempt and your optional local plan and weight profiles; it is
git-ignored too.

## Ideas for later

- Local test cases per problem so solutions can be checked offline.
- Track time-to-first-correct-approach separately from total time.
- A low-level design track (parking lot, rate limiter, file search) alongside the algorithm bank.
