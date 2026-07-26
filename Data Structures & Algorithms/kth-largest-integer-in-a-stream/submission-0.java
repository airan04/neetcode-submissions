class KthLargest {
    private PriorityQueue<Integer> q=new PriorityQueue<>();
    public int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int n:nums) add(n);
    }
    
    public int add(int val) {
        q.offer(val);
        if(q.size()>k) q.poll();
        return q.peek();
    }
}