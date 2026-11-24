# coding-exercise

Pattern-based coding interview practice with spaced repetition. Problems are tagged with the
patterns from my Educative notes ([docs/patterns-reference.md](docs/patterns-reference.md): what each
pattern is, when to use it and example questions), and the `coding` CLI decides what to work on next, times each attempt, and tracks mastery by pattern.

Python 3.8+ standard library only. Solutions are written in Java.

Most of it is used from Claude Code in this directory (`cd ~/home/coding-exercise && claude`, or the
Claude app with this folder open). Every step also has a plain `./coding` command for the terminal.

## Ways to practise

| session | what it trains | how long | start with |
|---|---|---|---|
| [Drill](#drill-session) | naming the pattern from a problem statement | 10-20 min | `/coding-drill` |
| [Coach](#coach-session) | a full interview-style problem, with hints and review | 30-45 min | `/coding-coach` |
| [Solo problem](#solo-problem) | a timed problem on your own, checked afterwards | 25-35 min | `/coding-next` |
| [Mock interview](#mock-interview) | a full round with Claude as interviewer, in a separate chat | ~50 min | `/coding-mock` |
| [Progress check](#progress-check) | seeing where you're weak and what to do next | 2 min | `/coding-stats` |

All of them choose problems the same way: heavy patterns you're weak in or haven't tried come up
most (see [How problems are chosen](#how-problems-are-chosen)).

## Drill session

Fast recognition reps: Claude describes a problem, you name the pattern and say why.

1. `/coding-drill` for 8 problems, `/coding-drill 12` for more, or `/coding-drill 5 graphs` to focus on one pattern.
2. For each problem Claude gives a realistic industry scenario with an example (input -> output only)
   and the numbered grid of patterns. Answer with a number or name, or say "hint", "skip" or "stop".
3. If you're wrong, Claude asks one guiding question and you get one more try.
4. Claude then teaches: the signals in the wording, the key insight, a short Java sketch, the
   complexity and a common trap. Say "next" to move on.
5. At the end Claude shows your recent sessions, the patterns you missed and what to look for next.

Your first answer is the one that counts in the score. A right answer on the retry is shown
separately as "fixed". Nothing is logged until the answer has been revealed, so the
log never gives the answer away.

Terminal version, without the teaching: `./coding drill [-n 10] [-p pattern] [--code | --no-code]`.
It shows the "when to use" signals and the pattern's Java template when you're wrong (press `t` to
see it when you're right; `--code` always shows it, `--no-code` never).

## Coach session

One interview-style round on a full problem, with Claude as a coach.

1. `/coding-coach` for the next problem, `/coding-coach graphs` for one pattern, or `/coding-coach lru-cache` for a
   specific problem.
2. **Recognise:** Claude presents the problem as a scenario and you name the pattern (as in a drill).
3. **Clarify and plan:** ask your clarifying questions, then outline the approach and its time and
   space complexity before coding. Claude points at flaws rather than fixing them.
4. **Code:** a 30-minute timer starts and you write `attempts/<date>_<id>/Solution.java` (or paste
   into the chat). Say "hint" for the hint ladder: a guiding question, then the structure, then a
   line or two of code. "give up" shows a full solution.
5. **Review:** you trace the example by hand, Claude checks complexity and readability, then runs a
   small `Main.java` harness with the example and edge cases. Failing inputs are shown for you to fix.
6. **Follow-up:** one question an interviewer might ask (scale, concurrency, extending the API).
7. **Log:** Claude logs the result, bugs, hints and complexity; the rating is
   [derived from them](#how-attempts-are-rated) and sets the next review date.

## Solo problem

A timed problem on your own, written as you would in the interview editor (without running it).

1. `/coding-next` picks a problem, opens `attempts/<date>_<id>/Solution.java` and starts the timer.
   `/coding-next graphs` picks from one pattern; `/coding-start <slug or number>` starts a specific problem.
2. Read the statement on LeetCode only. Write the solution in the file without running it, talking
   aloud through the five steps in its header: clarify, approach, code, test by hand, optimise.
3. `/coding-status` shows the time used and left. `/coding-abandon` drops the attempt without logging it.
4. `/coding-done` checks your work: it works out which pattern your code uses, runs it against the example
   and edge cases (showing any failing input for you to fix), compares its complexity with the
   optimal, and asks only how many hints you used. Then it logs the attempt with a
   [derived rating](#how-attempts-are-rated) and reveals the bank's pattern.

Terminal version: `./coding next` (or `start`), `./coding status`, then paste the solution into
LeetCode and run `./coding done`, which asks about your submissions instead.

The pattern is never shown when a problem starts, only after `done`, so recognition is practised too.

## Mock interview

A full round with Claude as the interviewer, in a separate chat so the problem stays hidden here.

1. `/coding-mock` (a random unseen, commonly asked problem) or `/coding-mock <problem>`. It copies an interviewer
   prompt to the clipboard and starts a 35-minute attempt.
2. Paste the prompt into a new Claude chat. It rewords the problem as an industry scenario, leaves
   requirements ambiguous for you to clarify, asks follow-ups and scores you on problem solving,
   data structures and algorithms, logical and maintainable code, and communication.
3. Put your final code in the attempt's `Solution.java` and run `/coding-done` to check and log it.

## Progress check

| command | shows |
|---|---|
| `/coding-stats` | mastery by pattern, sorted by need, plus the 2-3 patterns to work on next |
| `/coding-sessions [N]` | one row per session, oldest first (never merged): drills with their score, misses fixed after a hint and missed patterns; coach rounds, solo problems and mocks with the problem, rating and minutes |
| `/coding-list [pattern] [--core]` | the problem bank by pattern, with LeetCode links and your last rating and next review per problem |
| `/coding-patterns` | the patterns with their weights, your mastery and when to use each |
| `/coding-template [pattern]` | a pattern's signals and Java reference template |
| `/coding-report [path]` | a markdown report of all of the above, shown or written to a file |

In `stats`: `tried` is problems attempted out of the bank, `avg` the mean latest rating, `recog` how
often you named the right pattern when solving, `drill` your first-answer drill accuracy, `fixed`
drill misses you got right on the retry, `due` reviews waiting, and `mastery` the blend used to
choose problems.

## How attempts are rated

You don't rate yourself. `done` measures the attempt and derives a rating from 1 to 4:

| rating | when |
|---|---|
| 1 again | not solved: still failing, gave up, or saw the solution |
| 2 hard | solved, but with any hint, 2+ bugs to fix, or over 1.5x the timebox |
| 3 good | solved with one slip: 1 bug, over the timebox, or suboptimal complexity |
| 4 easy | correct first run, no hints, within the timebox, optimal |

Each signal caps the rating and the lowest cap wins; `done` prints the rating with its reasons. The
timer measures the minutes, and `/coding-done` or `/coding-coach` measure the result, bugs and complexity by
running your code.

The rating sets the next review: 1, 2, 4 or 7 days after the first attempt. After that, a 1 resets
it to 1 day, and a 2, 3 or 4 multiplies the previous interval by about 1.2, 2.5 or 3.5.

## How problems are chosen

`/coding-next` and `/coding-coach` pick in this order:

1. **Today's plan session**, only if you have a plan: its problems in order, then its stretch problems.
2. **Due reviews**: problems whose review date has arrived, most overdue first.
3. **New problem from the highest-need pattern**, where need = weight x (1 - mastery). Weight (1-5)
   is how often the pattern comes up in interviews; mastery blends your latest ratings, coverage
   (3 problems tried counts as full coverage) and drill accuracy. Commonly asked Mediums first.

`/coding-drill` has no plan or reviews: it samples at random by the same need, favours problems you've missed, and avoids ones you
drilled in the last few days, so restarting gives a different set.

### Weight profiles

Weights can be tuned per company or interview without changing the bank. Each profile is a local,
git-ignored file `.practise/weights/<name>.json` of overrides, e.g. `{"_note": "...", "Trie": 4}`.
Unlisted patterns keep their default, keys starting with `_` are notes, and an unknown pattern name
is an error.

```sh
./coding weights            # list profiles and show the active one (or /coding-weights)
./coding weights <name>     # use that profile from now on
./coding weights --off      # back to the defaults in bank/patterns.json
```

`PRACTISE_WEIGHTS=<name or path>` overrides the choice for one run. `stats` names the active profile
at the top.

### Dated plan (optional)

Copy `plan.example.json` to `.practise/plan.json` (git-ignored) and set your own dates and problems,
or point `PRACTISE_PLAN` at a file elsewhere. `/coding-plan` shows it and what's ticked off.
Without a plan, picks go straight to due reviews and need.

### Adding problems

`/coding-add <LeetCode URL or slug>` drafts every field (number, title, difficulty, patterns with the
primary first, commonly asked, premium, an own-words summary and a small example) for you to
confirm, then adds it to `bank/problems.json`.

## Command reference

Every user-facing command, with its slash command in Claude Code. The slash commands ask in the chat
for anything the command would otherwise prompt for. All of them start with `coding-`, which groups
them in the `/` menu and keeps them clear of Claude Code's built-ins (`/stats`, `/status`, `/plan`).

| `./coding` | slash command | options |
|---|---|---|
| `drill` | `/coding-drill [count] [pattern]` (the tutor) | `-n N` (default 10), `-p/--pattern`, `--code`, `--no-code` |
| `next` | `/coding-next [pattern]` | `-p/--pattern`, `-s/--session plan-session`, `-t/--timebox minutes` (default 25), `--easy`, `--premium`, `--peek` (show without starting), `--no-open` (don't open the editor), `--json` (used by `/coding-coach`) |
| `start <problem>` | `/coding-start <problem>` | `-t/--timebox minutes`, `--no-open`, `--via solo\|coach` (used by `/coding-coach`) |
| `status` | `/coding-status` | |
| `done` | `/coding-done [notes]` | `-u/--used pattern`, `--result pass\|fixed\|fail`, `--bugs N`, `--hints N`, `--optimal` or `--suboptimal`, `-n/--notes`, `-m/--minutes` (override the timer) |
| `abandon` | `/coding-abandon` | |
| `mock [problem]` | `/coding-mock [problem]` | `--show` (print the prompt instead of copying it) |
| - | `/coding-coach [pattern or problem]` | |
| `stats` | `/coding-stats` | |
| `sessions` | `/coding-sessions [N]` | `--last N`, `--markdown` |
| `list` | `/coding-list [pattern] [--core]` | `-p/--pattern`, `--core` (commonly asked only), `--markdown` |
| `patterns` | `/coding-patterns` | `--markdown` |
| `template [pattern]` | `/coding-template [pattern]` | no pattern: pick from the menu |
| `report` | `/coding-report [path]` | `-o/--out path` (write to a file instead of printing) |
| `plan` | `/coding-plan` | |
| `weights [profile]` | `/coding-weights [profile]` | `--off` |
| `add` | `/coding-add <URL or slug>` | `--slug`, `--lc`, `--title`, `--difficulty`, `--patterns`, `--summary`, `--example`, `--core`, `--premium` |

`drill-pick` (`-n`, `-p`), `drill-shown` (`--session`, `-n`: starts a problem's timer), `drill-log` (`--session`, `--id`, `--guess` for the first answer,
`--retry` for the answer after a guiding question, `--hinted`) and `drill-end` (`--session`,
`--stopped`) are the plumbing `/coding-drill` and `/coding-coach` use; they have no slash command.
Run without a terminal (as slash commands do), any command that would wait for input exits and
asks for a flag instead.

## Files

| path | what |
|---|---|
| `bank/problems.json` | problem bank: slug, LeetCode number, patterns (primary first), commonly-asked flag, premium flag, one-line summary and a small input -> output example |
| `bank/patterns.json` | pattern names (match my notes), weight, recognition signals |
| `docs/patterns-reference.md` | the patterns reference: description, when to use, example questions, and a quick reference by category |
| `bank/templates/` | one Java reference template per pattern; the file name is the pattern name in lower case with dashes, edit freely |
| `.claude/commands/*.md` | the slash commands; `coding-drill.md` and `coding-coach.md` hold the tutor and coach prompts (edit them to change how Claude teaches) |
| `.claude/settings.json` | turns off Claude Code's prompt suggestions in this repo (they give drill answers away) |
| `progress/attempts.jsonl` | append-only attempt log; the review schedule is derived from it |
| `progress/drills.jsonl` | drill answers, tagged with their session |
| `progress/drill_sessions.jsonl` | start and end of each drill session |
| `attempts/` | your written solutions |
| `.practise/` | the attempt in progress, the optional plan and the weight profiles |

## Where your progress lives

`progress/`, `attempts/` and `.practise/` stay in this directory on this machine and are git-ignored,
so none of it goes to GitHub. Run sessions from this directory (terminal or Claude app); the
progress commands read only these local files. To back up, copy `progress/` and `attempts/`
somewhere safe.

## Ideas for later

- Local test cases per problem so solutions can be checked offline.
- Track time-to-first-correct-approach separately from total time.
- A low-level design track (parking lot, rate limiter, file search) alongside the algorithm bank.
