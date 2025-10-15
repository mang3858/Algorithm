/*
 수도코드:
 String으로 N값까지 받아서 문자배열로 반환
 sum =0
 for
 	문자 배열 각 자릿값을 정수형으로 변환해서 sum에 더하기
 sum 출력
 */

import java.util.*;
public class P11720_숫자의합 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String sNum = sc.next();
		char[] cNum = sNum.toCharArray();
		int sum = 0;
		
		for(int i = 0; i <N; i++)
				sum+= cNum[i]- '0';
		System.out.println(sum);

	}

}
