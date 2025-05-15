import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] city) {
        // 초기 세팅
        int rowLength = city.length; // 전체 행길이
        int colLength = city[0].length; // 해당 행의 열길이 (각 행의)

        boolean[][] visited = new boolean[rowLength][colLength]; // 방문 여부를 체크
        int[][] distance = new int[rowLength][colLength]; // 시작부터 끝까지 이동거리

        int[] dr = {0,1,1,1,0,-1,-1,-1}; // 상하좌우, 대각선 탐색 위해
        int[] dc = {1,1,0,-1,-1,-1,0,1};

        // 시작지점 or 도착지점이 막혀서 갈 수 없는 경우 -1을 반환하기
        if (city[0][0] == 1 || city[rowLength-1][colLength-1] == 1) {
            return -1;
        }

        // BFS / queue를 사용해 최단거리 구하기
        Queue<int[]> queue = new LinkedList<int[]>(); // 2차원 좌표를 넣어야 하니 배열로 선언.
        queue.offer(new int[]{0,0}); // 시작점을 큐에 넣기
        visited[0][0] = true; // visited는 boolean 타입이므로, 시작점에 방문 했다고 표시해놓기
        distance[0][0] = 1; // 자기 자신의 거리 1로 시작하기 

        while (!queue.isEmpty()) { // 큐가 빌때까지 반복하기 (비어있지 않으면 계속 반복됨)
            int[] cur = queue.poll(); // 큐 맨 앞에 있는거 꺼내기
            int r = cur[0]; // 현재 위치의 행과 열을 저장하기
            int c = cur[1];

            for (int i =0; i<8; i++) { // 상하좌우, 대각선으로 다 한번씩 가기 위해서 for문으로 돌리기 
                int nr = r + dr[i]; // 현재 행 + 다음으로 갈 행
                int nc = c + dc[i]; // 현재 열 + 다음으로 갈 열 

                // 표에 해당하는 범위 안에 있다면 // 벽이아니라 갈수 있는 곳이거나, 방문했던 곳이 아닐때
                if (nr >= 0 && nr<rowLength && nc >= 0 && nc < colLength && city[nr][nc] == 0 && !visited[nr][nc]) { 
                    visited[nr][nc] = true; // 방문 처리하기
                    distance[nr][nc] = distance[r][c] + 1; // 현재 위치의 거리에서 1 더하기 
                    queue.offer(new int[]{nr,nc}); // 해당 위치를 큐에 넣기 (이곳에서 다시 경로를 찾아야 하기 때문에)
                }
            }
        }
        return visited[rowLength-1][colLength-1] ? distance [rowLength -1][colLength -1] : -1; // 도착지까지 최단 거리 or 실패를 반환
    }
}
