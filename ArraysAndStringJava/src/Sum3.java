import java.util.*;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 */
class Sum3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        Set<List<Integer>> results = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            int l = 0, r = nums.length - 1;
            while (l < r) {
                if (l == i) {
                    l++;
                    continue;
                }
                if (r == i) {
                    r--;
                    continue;
                }
                if (first + nums[l] + nums[r] < 0) {
                    l++;
                    continue;
                }
                if (first + nums[l] + nums[r] > 0) {
                    r--;
                    continue;
                }
                if (first + nums[l] + nums[r] == 0) {
                    List<Integer> re = Arrays.asList(first, nums[l], nums[r]);
                    Collections.sort(re);
                    results.add(re);
                    break;
                }
            }
        }
        res.addAll(results);
        return res;
    }

    public static void main(String[] args) {
        Sum3 solution = new Sum3();
        List<List<Integer>> res = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res);
    }
}
