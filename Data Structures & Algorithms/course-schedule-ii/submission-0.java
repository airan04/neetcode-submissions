class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> grh=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            grh.add(new ArrayList<>());
        }
        for(int[] num:prerequisites){
            int first=num[0];
            int second=num[1];
            grh.get(second).add(first);
            indegree[first]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
                ans.add(i);
            }
        }

        while(!q.isEmpty()){
            int top=q.poll();

            for(int num:grh.get(top)){
                indegree[num]--;
                if(indegree[num]==0){
                    q.add(num);
                    ans.add(num);
                }
            }
        }
        if(ans.size()!=numCourses){
            return new int[0];
        }
        int[] arr = ans.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
}