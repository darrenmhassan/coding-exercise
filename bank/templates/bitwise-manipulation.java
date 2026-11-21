// Bitwise Manipulation: XOR cancels pairs (a ^ a = 0, a ^ 0 = a).
int x = 0;
for (int n : nums) x ^= n;
return x;                               // the value that appears once
// Useful: n & (n - 1) clears the lowest set bit; (n >> i) & 1 reads bit i; 1 << i is a mask.
