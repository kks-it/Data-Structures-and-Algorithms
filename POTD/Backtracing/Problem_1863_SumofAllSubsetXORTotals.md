
# Sum of All Subset XOR Totals

**Find All Subsets code but keep xoring element**

We can calculate the running XOR total for the current subset by passing the XOR of the running XOR and the current element in nums as a parameter to our helper function.

For the current subset, we save the XOR total by adding the element to the subset in the variable withElement and the XOR total by not adding the element in the variable withoutElement. Each of these variables represents the XOR total of a different subset, so we can return their sum to compute the running total for those two subsets.

```
class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXORSumRecursively(nums, 0, 0);
    }

    public static int subsetXORSumRecursively(int[] nums, int idx, int xsf){      //xsf: xor so far
        if(idx == nums.length){
            return xsf;
        }

        int take =  subsetXORSumRecursively(nums, idx + 1, xsf ^ nums[idx]);
        int notTake = subsetXORSumRecursively(nums, idx + 1, xsf);

        return take + notTake;
    }

    public static int subsetXORSumIteratively(int[] nums) {
        List<Integer> xors = new ArrayList<>();
        xors.add(0);

        for (int num : nums) {
            int size = xors.size();

            for (int i = 0; i < size; i++) {
                xors.add(xors.get(i) ^ num);
            }
        }

        return xors.stream().reduce((a, b) -> a + b).orElse(0);
    }

}

// 1 + (1 ^ 3) + (1 ^ 3 ^ 5)
```