import java.io.*;
import java.util.StringTokenizer;

public class P11404 {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;
    static int distance[][];

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        //도시 개수
        N= Integer.parseInt(br.readLine());
        //노션 개수
        M = Integer.parseInt(br.readLine());

        distance = new int[N+1][N+1];

        //인접 행렬 초기화
        for(int i = 1; i<= N; i++) {
            for(int j= 1; j<= N; j++) {
                if(i ==j)
                    distance[i][j] = 0;
                else
                    distance[i][j] = Integer.MAX_VALUE;
            }
        }

        //노선 정보
        for(int i = 0; i< M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //중복 간선이 존재할 시, 최소 비용으로 갱신해야 함
            if (distance[s][e] > v) distance[s][e] = v;
        }

        //플로이드 워셜
        for(int k = 1; k<=N; k++) {
            for(int i = 1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(distance[i][j] > distance[i][k] + distance[k][j])
                        distance[i][j] = distance[i][k] + distance[k][j];
                }
            }
        }

        for(int i=1; i<=N; i++) {
            for(int j=1; j<= N; j++) {
                if(distance[i][j] == Integer.MAX_VALUE)
                    System.out.print("0 ");
                else System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
    }

}
