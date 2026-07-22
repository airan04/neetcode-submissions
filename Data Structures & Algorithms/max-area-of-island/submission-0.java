class Solution {
    private int bfs(int[][] grid,boolean[][] vis,int i,int j){
        vis[i][j]=true;
        int area=1;
        int m=grid.length;
        int n=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});

        while(!q.isEmpty()){
            int[] top=q.poll();
            int r=top[0];
            int c=top[1];
            int[] dr={-1,0,1,0};
            int[] dc={0,1,0,-1};

            for(int p=0;p<4;p++){
                int newR=r+dr[p];
                int newC=c+dc[p];

                if(newR>=0 && newR<m && newC>=0 && newC<n && 
                !vis[newR][newC] && grid[newR][newC]==1){
                    area++;
                    q.add(new int[]{newR,newC});
                    vis[newR][newC]=true;
                }
            }
        }

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int maxArea=0;
        boolean[][] vis=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    maxArea=Math.max(maxArea,bfs(grid,vis,i,j));
                }
            }
        }

        return maxArea;

    }
}