class Solution {
    private int check(int index,int n,int[] dp){
        if(index==n){
            return 1;
        }
        if(index>n){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }

        int left=check(index+1,n,dp);
        int right=0;
        if(index<n-1){
            right=check(index+2,n,dp);
        }
        return dp[index] = (left+right);
    }
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return check(0,n,dp);
    }
}