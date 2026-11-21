// Dynamic Programming: define dp[i] in words, write the recurrence, base case, iteration order.
// e.g. coin change: dp[a] = fewest coins to make amount a
int[] dp = new int[amount + 1];
Arrays.fill(dp, amount + 1);                     // "infinity"
dp[0] = 0;                                       // base case
for (int a = 1; a <= amount; a++)
    for (int coin : coins)
        if (coin <= a) dp[a] = Math.min(dp[a], dp[a - coin] + 1);   // recurrence
return dp[amount] > amount ? -1 : dp[amount];
// Top-down alternative: recursive function + memo map; often easier to explain first.
// Word break: dp[i] = true if some j < i has dp[j] && dict.contains(s.substring(j, i)).
