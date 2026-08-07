class Solution {
    private static final int INF = (int) 1e9;
    private int coin(int[] coins,int[][] dp,int target,int amount,int i){
        if(amount==target){
            return 0;
        }
        if(i<0 || amount>target){
            return INF;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }

        int notTake=coin(coins,dp,target,amount,i-1);
        int take=Integer.MAX_VALUE;
        if(amount+coins[i]<=target){
            take=1+coin(coins,dp,target,amount+coins[i],i);
        }

        return dp[i][amount]=Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int ans=coin(coins,dp,amount,0,n-1);

        return ans<INF ? ans : -1;
    }
}