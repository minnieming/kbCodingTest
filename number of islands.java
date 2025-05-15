class Solution {
    public int numIslands(char[][] grid) {
        // 초기 세팅
        int rowLength = grid.length;
        int colLength = grid[0].length;

        boolean[][] visited = new boolean[rowLength][colLength];
        int islandCount = 0;

        int[] dr = {0,1,0,-1};
        int[] dc = {1,0,-1,0};

        // 전체를 돌면서 섬 찾기
        for (int r=0; r<rowLength; r++) {
            for (int c = 0; c<colLength; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) { // 현재 있는곳이 땅이고, 방문하지 않을 곳일때
                    found(grid, visited, r,c,dr,dc, rowLength, colLength); // bfs 방식을 메서드로 빼서 작성
                    islandCount++; // Found 메서드에서 확인을 하고 오기 때문에 연결된 섬 하나당 count++ 된다. 
                }
            }
        }

        return islandCount;
    }

    private void found(char[][] grid, boolean[][] visited, int r, int c, int[] dr, int[] dc, int rowLength, int colLength) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{r,c}); // 시작을 위해 현재 위치를 queue에 넣기
        visited[r][c] = true; // 왔던곳인지 확인하기 위해서 현재 위치를 true로 표시하기

        while (!queue.isEmpty()) { // 큐가 비어있을때까지 반복하기
            int[] cur = queue.poll(); // 큐에 있는것 꺼내기
            int curRow = cur[0]; 
            int curCol = cur[1]; // cur에서 현재 위치를 int에 각각 넣기

            for (int i=0; i<4; i++) {
                int nextRow = curRow + dr[i];
                int nextCol = curCol + dc[i]; // 상하좌우 확인 할 수 있도록

                if (nextRow >= 0 && nextRow <rowLength && nextCol >= 0 && nextCol < colLength) { // 정상범위에 들어오는지 확인하기 
                    if (grid[nextRow][nextCol] == '1' && !visited[nextRow][nextCol]) { // 해당칸이 섬이고, 방문하지 않은 곳일때 
                    queue.offer(new int[]{nextRow, nextCol}); // 해당 칸에서 다시 다음곳으로 가야하기 때문에 큐에 넣기
                    visited[nextRow][nextCol] = true; // 방문 체크하기
                    }
                }
            }
        }
    }
}
