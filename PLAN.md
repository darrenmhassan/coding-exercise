# AWS SDE3 coding interview prep: Sat 21 to Wed 25 Nov 2026

`./practise plan` shows this with progress ticks; `./practise next` follows it automatically.

## What to expect

- An Amazon coding round is roughly 60 minutes: 15-20 minutes of Leadership Principle questions,
  then about 35 minutes of coding in a shared editor that **doesn't run code**.
- Problems are usually LeetCode Mediums, often dressed up as an Amazon scenario (packages,
  servers, orders, logs) rather than given word for word. Recognising the pattern behind the
  story is the core skill, which is why each session starts with `drill`.
- The most frequent shapes: graphs/grids (BFS/DFS), trees, hash maps, heaps/top K,
  intervals, sliding window, topological sort, and designing a small class (LRU-style).
- At SDE3 the bar is beyond "it works": drive the conversation, state assumptions, compare
  approaches before coding, write readable code (clear names, small helpers, edge cases handled),
  test by tracing an example, then handle follow-ups on scale and extensibility. Those map to the
  coding dimensions in my calibration notes: Problem Solving, DS&A, Logical & Maintainable Code.

## Sessions

Timebox each problem at 25 minutes (interview pace leaves time for talk). If stuck at 15 minutes,
take one hint and rate 2; at 25 minutes read the solution, rate 1, and it comes back tomorrow.

### Saturday, 2 h: grids, top K, intervals
1. `./practise drill -n 15` (10 min)
2. Number of Islands, Rotting Oranges (grid BFS/DFS; multi-source BFS)
3. Top K Frequent Words (heap with a custom comparator, ties alphabetical)
4. Merge Intervals (sort by start, merge with previous)
5. Stretch: K Closest Points to Origin, Word Ladder
6. `./practise stats` (10 min)

### Sunday, 2.5-3 h: trees, dependencies, window, design
1. `./practise drill -n 15`
2. Lowest Common Ancestor of a Binary Tree (post-order DFS)
3. Binary Tree Zigzag Level Order Traversal (BFS by level)
4. Course Schedule II (Kahn's algorithm, cycle detection)
5. Longest Substring Without Repeating Characters (variable window + map)
6. LRU Cache (hash map + doubly linked list)
7. Stretch: Find Median from Data Stream, Search Suggestions System, All Nodes Distance K
8. `./practise next` for anything due from Saturday, then `./practise stats`

### Wednesday, 2-2.5 h: consolidate and stop
1. `./practise drill -n 20`
2. `./practise mock`: a full simulated round with Claude as interviewer (about 50 min with debrief)
3. Word Break (DP), Reorganize String (greedy + heap)
4. `./practise next` for due/weakest items with whatever time is left
5. Stop at least an hour before the interview; re-read the Interview structure note.
   No new problems in the last hour.

## After Wednesday

Keep going with `./practise next` daily (20-30 minutes is enough): it serves due reviews
first, then the weakest high-value pattern. Replace `plan.json` sessions for the next target.
