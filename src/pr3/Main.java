package pr3;

import java.util.*;

public class Main {

    private static final int N = 5;

    public static void main(String[] args) {
        int[][] matrix = new int[N][N];

        addEdge(matrix, 0, 1, 3);
        addEdge(matrix, 0, 3, 7);
        addEdge(matrix, 1, 2, 2);
        addEdge(matrix, 1, 3, 1);
        addEdge(matrix, 2, 4, 4);
        addEdge(matrix, 3, 4, 5);

        System.out.println("\n--- BFS от 0 (A) ---");
        bfs(matrix, 0);

        System.out.println("\n--- DFS от 0 (A) ---");
        dfs(matrix, 0);

        System.out.println("\n--- Дейкстра (0 -> 4) ---");
        dijkstra(matrix, 0, 4);
    }

    public static void addEdge (int[][] matrix, int edge1, int edge2, int weight) {
        matrix[edge1][edge2] = weight;
        matrix[edge2][edge1] = weight;
    }

    public static void bfs(int[][] matrix, int start) {
        boolean[] visited = new boolean[N];
        int[] distance = new int[N];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        visited[start] = true;
        distance[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int i = 0; i < N; i++) {
                if(matrix[current][i] > 0 && !visited[i]) {
                    visited[i] = true;
                    distance[i] = distance[current] + 1;
                    queue.add(i);
                }
            }
        }

        System.out.println("Порядок обхода: " + order);
        System.out.println("Расстояние в ребрах от " + start + ": " + Arrays.toString(distance));
    }

    public static void dfs (int[][] matrix, int start) {
        boolean[] visited = new boolean[N];
        List<Integer> order = new ArrayList<>();
        dfsHelper(matrix, start, visited, order);
        System.out.println("Порядок обхода: " + order);
    }

    public static void dfsHelper (int[][] matrix, int u, boolean[] visited, List<Integer> order) {
        visited[u] = true;
        order.add(u);

        for (int v = 0; v < N; v++) {
            if(matrix[u][v] > 0 && !visited[v]) {
                dfsHelper(matrix, v, visited, order);
            }
        }
    }

    public static void dijkstra(int[][] matrix, int start, int target) {
        int[] dist = new int[N];
        int[] prev = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        for (int i = 0; i < N; i++) {
            int u = -1;
            int minDist = Integer.MAX_VALUE;

            for (int j = 0; j < N; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    u = j;
                }
            }

            if (u == -1 || dist[u] == Integer.MAX_VALUE) break;
            visited[u] = true;

            for (int v = 0; v < N; v++) {
                if (matrix[u][v] > 0 && !visited[v]) {
                    if (dist[u] + matrix[u][v] < dist[v]) {
                        dist[v] = dist[u] + matrix[u][v];
                        prev[v] = u;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int at = target; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        System.out.println("Кратчайшее расстояние до " + target + ": " + dist[target]);
        System.out.println("Путь: " + path);
    }
}
