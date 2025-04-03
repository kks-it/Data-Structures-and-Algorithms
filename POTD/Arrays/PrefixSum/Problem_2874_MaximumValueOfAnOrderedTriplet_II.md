# Maximum Value of an Ordered Triplet II

## Solution
## Approach 1: Greedy + Prefix Suffix Array
**Intuition**
Let the length of the array nums be n. According to the value formula (nums[i]−nums[j])×nums[k], it can be known that when j is fixed, the maximum value of the triplet is achieved when nums[i] and nums[k] respectively take the maximum values from [0,j) and [j+1,n). We use leftMax[j] and rightMax[j] to maintain the maximum value of the prefix [0,j) and the maximum value of the suffix [j+1,n), respectively, and enumerate j in order, calculate the value (leftMax[j]−nums[j])×rightMax[j], and return the maximum value (if all values are negative, return 0).

**Implementation**
```
public class Solution {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
            rightMax[n - 1 - i] = Math.max(rightMax[n - i], nums[n - i]);
        }
        long res = 0;
        for (int j = 1; j < n - 1; j++) {
            res = Math.max(res, (long) (leftMax[j] - nums[j]) * rightMax[j]);
        }
        return res;
    }
}
```

**Complexity Analysis**
Let n be the length of the array nums.

* Time complexity: O(n).
During the traversal of the array, the prefix and suffix arrays can be maintained, thus achieving a single traversal.

* Space complexity: O(n).
Two arrays are needed to maintain the maximum and minimum values of the prefixes and suffixes.

## Approach 2: Greedy
**Intuition**
Similar to approach 1, if we fix k, then the value of the triplet is maximized when nums[i]−nums[j] takes the maximum value. We can use imax to maintain the maximum value of nums[i], and dmax to maintain the maximum value of nums[i]−nums[j]. During the enumeration of k, update dmax and imax.

**Implementation**
class Solution {

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }
        return res;
    }
}

**Complexity Analysis**
Let n be the length of the array nums.

* Time complexity: O(n).
Similar to approach 1, in the process of a single traversal, the maximum and minimum values can be maintained.

* Space complexity: O(1).
We only need two variables to maintain the maximum and minimum values.