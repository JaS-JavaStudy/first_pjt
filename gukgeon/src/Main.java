import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Node>[] graph;
    //노드의 크기, 출발지
    public static void Dijkstra(int n, int start) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            int nowVertex = pq.poll().index;

            if(check[nowVertex]) continue;
            check[nowVertex] = true;

            //index 의 연결된 정점 비교
            for(Node next : graph[nowVertex]) {
                if(dist[next.index] > dist[nowVertex]+ next.cost) {
                    dist[next.index] = dist[nowVertex] + next.cost;

                    pq.offer(new Node(next.index, dist[next.index]));
                }
            }
        }

        //최소거리 출력
        for(int i : dist) {
            if(i == INF) System.out.print(0 + " ");
            else System.out.print(i+" ");
        }
    }

    public static void main(String[] args) throws IOException {
        //그래프 입력 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //정점의 개수, 간선의 개수
        int n = Integer.parseInt(bf.readLine().trim());
        int m = Integer.parseInt(bf.readLine().trim());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++)  graph[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        int start = Integer.parseInt(bf.readLine());
        Dijkstra(n, start);

    }
}