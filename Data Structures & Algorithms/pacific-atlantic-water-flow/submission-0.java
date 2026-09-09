class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();
                
        for (int r = 0; r < rows; r++) {
            pacQueue.add(new int[]{r, 0});
            pacific[r][0] = true;
            
            atlQueue.add(new int[]{r, cols - 1});
            atlantic[r][cols - 1] = true;
        }
        
        // Top and Bottom edges
        for (int c = 0; c < cols; c++) {
            pacQueue.add(new int[]{0, c});
            pacific[0][c] = true;
            
            atlQueue.add(new int[]{rows - 1, c});
            atlantic[rows - 1][c] = true;
        }
        
        bfs(heights, pacQueue, pacific);
        bfs(heights, atlQueue, atlantic);
        
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        
        return result;
    }
    
    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int rows = heights.length;
        int cols = heights[0].length;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                
                if (newR >= 0 && newR < rows && newC >= 0 && newC < cols 
                    && !visited[newR][newC] 
                    && heights[newR][newC] >= heights[r][c]) {
                    
                    visited[newR][newC] = true;
                    queue.add(new int[]{newR, newC});
                }
            }
        }
    }
}