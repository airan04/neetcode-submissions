class Solution {
    public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        if(n<2){
            return stones[0];
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:stones){
            pq.add(num);
        }
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            if(first!=second){
                int value=first-second;
                pq.add(value);
            }
        }
        
        return !pq.isEmpty() ? pq.peek() : 0;
    }
}
