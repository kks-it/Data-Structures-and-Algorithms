## Problem: 2140_Solving_Questions_With_Brainpower

### **Date:** 01-Apr-2025

### **Pattern:** 0/1 Knapsack



**Directly came up with dp solution**
* go from smallest problem to large problem
* Space cannot be optimized further because we may need to skip any no. of questions. So states are not fixed.


**Mistake done:** Didn't notice that I need to return long, Therefore create dp & solve of int type.


```

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];

        dp[n - 1] = questions[n - 1][0];

        for(int i = n - 2; i >= 0; i--){
            long solve = questions[i][0];

            // check if next allowed question is within range of array
            if(i + questions[i][1] + 1 < n){
                solve += dp[i + questions[i][1] + 1];
            }
            dp[i] = Math.max(solve, dp[i + 1]);
        }

        return dp[0];
    }
}
```