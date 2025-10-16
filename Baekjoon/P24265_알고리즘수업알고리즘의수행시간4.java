/*
 안쪽 루프 j가 몇번 도는가?
 j는 i+1 ~ n까지 도는데 그 횟수가 
 
 n -(i+1) + 1 = n-i
 
 따라서 
 i =1, n-1
 i =2, n-2
 i =3, n-3
 ...
 i= n-1, 1
 
 정답은 총 몇번 도는지 수행 횟수를 물어봤으니
 n-1, n-2, ~ ,1까지 모두 더하면
 n(n-1)/2 이렇게 나옴
 */

import java.io.*;

public class P24265_알고리즘수업알고리즘의수행시간4 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		System.out.println(n*(n-1)/2);
		System.out.println(2);
	}

}
