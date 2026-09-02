class Solution {
    private int check(int index,int[] cost,int[] dp){
        if(index>=cost.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int one=check(index+1,cost,dp);
        int two=0;
        if(index<cost.length-1){
            two=check(index+2,cost,dp);
        }

        return dp[index]=Math.min(one,two)+cost[index];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int first=check(0,cost,dp);
        int second=check(1,cost,dp);

        return Math.min(first,second);
    }
}