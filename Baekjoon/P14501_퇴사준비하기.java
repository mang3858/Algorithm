/*
 D: 점화식 배열 저장
 T: 상담 필요한 일 수 배열 저장
 P: 수입 배열 저장
 
  for(N만큼 반복)
  	T와 P 배열 입력받기
  	
  for(i -> N~1 까지 반복){
  	if(i+T[i] > N+1)
  		D[i] = i+1 부터 퇴사일에 벌 수 있는 최대 수입
  	else
  		D[i] = Max(i+1 부터 퇴사일에 벌 수 있는 최대 수입과 i번째 상담 비용 + i번째 상담이 끝난 다음날부터 퇴사일까지의 최대 수입)
  		
  D[1](1일째부터 퇴사일까지 벌 수 있는 최대수입) 출력하기
 */
import java.util.Scanner;

public class P14501_퇴사준비하기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int D[] = new int[N+2];//D[N+1]를 쓰기 위해서 D의 크기를 N+2로 만듦
		int T[] = new int [N+1];
		int P[] = new int [N+1];
		
		for(int i = 1; i <=N; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i=N; i>0; i--) {
			if(i+T[i] > N+1) {
				D[i] = D[i+1];
			}
			else {
				D[i] = Math.max(D[i+1], P[i]+ D[i+T[i]]);
			}
		}
		
		System.out.println(D[1]);
	}

}
