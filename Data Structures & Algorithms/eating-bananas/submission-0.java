class Solution {
    private long count(int[] piles,int k){
        long sum=0;
        for(int num:piles){
            sum+=Math.ceil((double)num/k);
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int high=0;
        for(int pile:piles){
            high=Math.max(high,pile);
        }
        int low=1;
        int ans=high;
        while(low<=high){
            int mid= (high+low)/2;
            if(count(piles,mid)<=h){
                high=mid-1;
                ans=Math.min(ans,mid);
            }else{
                low=mid+1;
            }
        }

        return ans;
    }
}