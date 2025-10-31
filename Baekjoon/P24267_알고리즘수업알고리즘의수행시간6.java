/*
 수도코드:
 서로 다른 숫자 3개를 뽑으란 말과 같음 nC3
 그래서 조합 공식 쓰면 된당
 */

import java.io.*;

public class P24267_알고리즘수업알고리즘의수행시간6 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		System.out.println(n * (n-1)*(n-2) /6 );
		System.out.println(3);

	}

}
