/* 
 점화식 D[i][j]
 : i, j 위치에서 왼쪽 위로 만들 수 있는 최대 정사각형 변의 길이를 저장하는 배열
 
  수도 코드
  D 배열 선언
  n, m 입력 받기
  max 값 초기화
  for(i -> 0~n){
  	for(j -> 0~m){
  		D[i][j] 값이 1이면 자신의 대각선, 왼쪽, 위의 값들 중 최솟값에 +1
  		D[i][j] 값이 최댓값보다 크면 이 최댓값으로 업데이트
  	}
  }
  
  max*max 출력
 */
import java.util.*;
public class P1915_가장큰정사각형찾기 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		long[][] D = new long[1001][1001];
		int n = sc.nextInt();
		int m = sc.nextInt();
		long max = 0;
		for(int i = 0; i < n; i++) {
			String mline = sc.next();
			for(int j = 0; j< m; j++) {
				D[i][j] = Long.parseLong(String.valueOf(mline.charAt(j)));
				if(D[i][j] == 1 && j > 0 && i > 0) //인덱스 오류 주의  j > 0 && i > 0
					D[i][j] = Math.min(D[i-1][j-1], Math.min(D[i-1][j], D[i][j-1])) + 1;
				if(max< D[i][j])
					max = D[i][j];		
			}
		}
		System.out.println(max*max);

	}

}
