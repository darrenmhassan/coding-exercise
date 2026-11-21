// Cyclic Sort: values in 1..n belong at index value-1; swap each into place. O(n), O(1) space.
int i = 0;
while (i < nums.length) {
    int target = nums[i] - 1;
    if (nums[i] >= 1 && nums[i] <= nums.length && nums[i] != nums[target]) {
        int tmp = nums[i]; nums[i] = nums[target]; nums[target] = tmp;   // put it home
    } else i++;
}
for (i = 0; i < nums.length; i++)
    if (nums[i] != i + 1) return i + 1;          // first index out of place = missing value
return nums.length + 1;
