import java.util.*;

class Solution {
    List<Integer>[] graph; // 인접그래프로 저장하기 위한 배열
    boolean[] visited;
    int count;

    void dfs(int node) { // 노드의 개수
        visited[node] = true;
        count++;

        for (int next : graph[node]) {
            if (!visited[next]) { // 연결 노드에 방문하지 않았다면
                dfs(next);
            }
        }
    }

    public int solution(int n, int[][] wires) {
        int answer = n;

        graph = new ArrayList[n + 1]; // 1번 노드부터 시작하기 때문에
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) { // 그래프안에 노드의 연결을 추가하기
            int a = wire[0];
            int b = wire[1];

            graph[a].add(b);
            graph[b].add(a); 
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            // 간선 제거. 무방향 그래프는 양방향으로 연결이 되어 있기 때문에 둘 다 끊어줘야 한다. 
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));

            visited = new boolean[n + 1];
            count = 0; 
            dfs(a);

            // 상반된 노드의 개수
            int part1 = count;
            int part2 = n - count;

            int diff = Math.abs(part1 - part2); 

            answer = Math.min(answer, diff); 

            // 다음 반복을 위해 다시 추가
            graph[a].add(b);
            graph[b].add(a);
        }

        return answer;
    }
}

