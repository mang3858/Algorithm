/*
 수도코드:
 숫자개수 N 입력
 합 횟수 M 입력
 
 for(M까지)
  합배열 생성(S[i] = S[i-1]+A[i]
  
  for(M까지){
  	구간 받아서(i~j)
  	구간 합 출력(S[j]-S[i-1])
  }
 */
import java.io.*;
import java.util.StringTokenizer;
public class P11659_구간합구하기4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] S = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<= N; i++)
			S[i] = S[i-1] + Integer.parseInt(st.nextToken());
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			System.out.println(S[j]- S[i-1]);
		}
	}

}

