class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return ways(n,dp,n);
    }
    private int ways(int n,int[] dp,int i){
        if(i==0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }

        int one=ways(n,dp,i-1);
        int two=0;
        if(i>1){
            two=ways(n,dp,i-2);
        }

        return dp[i]=one+two;
    }
}