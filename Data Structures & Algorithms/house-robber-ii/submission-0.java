class Solution {
    private int checkMoney(int index,int end,int[] nums,int[] dp){
        if(index>end){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }

        int notTake=checkMoney(index+1,end,nums,dp);
        int take=nums[index]+checkMoney(index+2,end,nums,dp);

        return dp[index]=Math.max(take,notTake);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp1=new int[n];
        Arrays.fill(dp1,-1);
        int first=checkMoney(0,n-2,nums,dp1);

        int[] dp2=new int[n];
        Arrays.fill(dp2,-1);
        int second=checkMoney(1,n-1,nums,dp2);

        return Math.max(first,second);
    }
}