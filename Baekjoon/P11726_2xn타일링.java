/*
 아이디어: 
 2*5를 직사각형으로 채우는 경우의 수는
 2*4에 직사각형 하나 붙이는 경우의 수와 같다!
 
 수도코드
 D[N] = 2*n을 직사각형으로 채우는 경우의 수로 정의.
 
 D[1] = 1//N이 1일 때 타일 경우의 수(세로 직사각형 하나)
 D[2] = 2//N이 2일 때 타일 경우의 수)세로, 가로 직사각형  총 두 개)
 
 for(i = 3~N){
 	D[i] = (D[N-1]+D[N-2]) %10007
 }
 
 D(N) 프린트
 * */
import java.util.*;
public class P11726_2xn타일링 {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		long D[] = new long[1001];
		
		D[1] = 1;
		D[2] = 2;
		
		for(int i = 3; i<= N; i++) {
			D[i] = (D[i-1] + D[i-2]) % 10007;
		}
		
		System.out.println(D[N]);
	}

}
