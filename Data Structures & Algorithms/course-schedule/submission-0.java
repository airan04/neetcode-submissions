class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> grh=new ArrayList<>();
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
            if(indegree[i]==0) q.add(i);
        }
        boolean[] vis=new boolean[numCourses];

        while(!q.isEmpty()){
            int top=q.poll();
            vis[top]=true;

            for(int num:grh.get(top)){
                indegree[num]--;
                if(indegree[num]==0){
                    vis[num]=true;
                    q.add(num);
                }
            }
        }

        for(boolean num:vis){
            if(!num) return false;
        }

        return true;
    }
}