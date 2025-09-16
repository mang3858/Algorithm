/*
 점화식 정의
 DP[N][L][R]: 높이 1..n을 이용해 줄을 세웠을 때, 왼쪽에서 L개, 오른쪽에서 R개가 보이는 배치의 수
 
 수도 코드:
 dp 베열 선언
 
 초기값은 dp[1][1][1] = 1
 
 for n -> 2~N {
    for l -> 1~L {
        for r -> 1~R {
            val(헌재 경우의 수) 초기화

            //가장 큰 빌딩 n을 맨 왼쪽에 두는 경우
            val += dp[n-1][l-1][r]

            //가장 큰 빌딩 n을 맨 오른쪽에 두는 경우
            val += dp[n-1][l][r-1]

            //가장 큰 빌딩 n을 가운데(n-2 위치)에 두는 경우
            val += ( (n-2) * dp[n-1][l][r] ) % 1000000007
		}
	}
}

dp[N][L][R] 출력 
 */
import java.io.*;
import java.util.*;
public class P1328_빌딩순서구하기 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		long[][][] dp = new long[N+1][L+1][R+1];
		
		if(L>=1 && R>=1)
			dp[1][1][1] = 1;
		
		for(int n = 2; n <=N; n++) {
			for(int l = 1; l <= L; l++) {
				for(int r= 1; r <= R; r++) {
					long val = 0;
					
					if (l-1 >= 1)
						val += dp[n-1][l-1][r];
					if (r-1 >= 1)
						val += dp[n-1][l][r-1];
					if (n-2 >= 0)
						val += ((long)(n-2) * dp[n-1][l][r]) % 1000000007;
					
					dp[n][l][r] = val % 1000000007;
					
				}
			}
		}
		System.out.println(dp[N][L][R] % 1000000007);

	}

}
