class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        if(n==1){
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> results=new ArrayList<>();
        int i=0;
        while(i<n-1){
            if(intervals[i][1]>=intervals[i+1][0]){
                intervals[i+1][0]=intervals[i][0];
                intervals[i+1][1]=Math.max(intervals[i+1][1],intervals[i][1]);
            }else{
                results.add(intervals[i]);
            }
            i++;
        }
        results.add(intervals[i]);

        return results.toArray(new int[results.size()][]);
    }
}