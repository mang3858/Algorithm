/*
 LCS(최장공통부분수열) 알고리즘 구하는 문제
 
 수도 코드:
 2차원 dp 배열 선언
 A 문자열 선언(1번째 문자열)
 B 문자열 선언(2번째 문자열)
 path 선언(LCS 저장 리스트)
 
 for(i-> 1~A문자열 길이){
 	for(j -> 1~B 문자열 길이){
 		A[i]와 B[i]가 같으면 배열의 대각선 왼쪽 위의 값에 +1
 		다르면 배열의 완쪽값과 위의 값 중 큰 값으로 저장
 	}
 }
 
 dp의 마지막 값 출력(이게 LCS 길이)
 getText 호출
 LCS 문자열 출력
 
 //LCS 문자열 구하는 함수

 getText(row, clo){
 	엣지값
 
 	//A[row]와 B[col]이 같으면 LCS에 기록 후 대각선 왼쪽으로 이동
 	path.add(A[row-1]);
 	getText(row-1, col-1)
 	
 	//다른 경우 완쪽값과 위의 값 중 큰 값으로 저장
 	getText(row-1, col) 또는 getText(row, col-1)
 	
 
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P9252_LCS2 {
	private static long[][] dp;
	private static char[] A;
	private static char[] B;
	private static ArrayList<Character> path;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		dp = new long[A.length + 1][ B.length + 1];
		path = new ArrayList<Character>();
		
		for(int i = 1; i<= A.length; i++) {
			for(int j = 1; j<= B.length; j++) {
				if(A[i-1] == B[j-1])
					dp[i][j] = dp[i-1][j-1] +1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		System.out.println(dp[A.length][B.length]);
		getText(A.length, B.length);//끝에서부터 시작하니까
		for(int i = path.size()- 1; i>=0; i--)
			System.out.print(path.get(i));
		
		System.out.println();
}
	
	private static void getText(int row, int col) {
		if(row == 0 || col == 0)
			return;
		
		if(A[row-1] == B[col-1]) {
			path.add(A[row-1]);
			getText(row-1, col-1);
		}
		else {
			if(dp[row-1][col] > dp[row][col-1])
				getText(row-1, col);
			else
				getText(row, col-1);
		}
			
	}

}
