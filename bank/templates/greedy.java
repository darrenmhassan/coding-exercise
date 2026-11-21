// Greedy: make the locally best choice and argue it never needs undoing. Often sort first.
// e.g. jump game: track the furthest reachable index
int furthest = 0;
for (int i = 0; i < nums.length; i++) {
    if (i > furthest) return false;              // can't even reach i
    furthest = Math.max(furthest, i + nums[i]);  // best choice so far
}
return true;
// Interval greedy (fewest removals / arrows): sort by END, keep an interval if it starts after the last kept end.
// In the interview, say why greedy is safe (exchange argument) or pick DP if you can't.
