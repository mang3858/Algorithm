/*
 수도코드:
 표의 크기 M, 합을 구해야 하는 횟수 M 입력 
 
 for(N만큼)
 	for(N만큼)
 		배열 입력
 
 for(N만큼){
 	for(N만큼){
 		합배열 저장
 		D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j]
 	}
 }
 
 for(M만큼){
 	질의 계산 및 출력
 	result = D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1]
 }
 */
import java.io.*;
import java.util.StringTokenizer;
public class P11660_구간합구하기5 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int A[][] = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j <=N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int D[][] = new int[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			for(int j =1; j <=N; j++) {
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
			}
		}
		
		for(int i = 0; i <M; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int result 
			         = D[x2][y2] - D[x2][y1-1] - D[x1-1][y2] + D[x1-1][y1-1];
			System.out.println(result);
		}
		

	}

}
