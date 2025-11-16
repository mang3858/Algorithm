/*
 수도 코드:
 N 입력 받고
 
 //사용할 변수 초기화
 cnt = 1 //N값 미리 넣고 초기화, N 값이 15면 15 이 숫자 하나를 미리 넣고 시작
 start_idx = 1
 end_idx = 1
 sum = 1
 
 while(end_idx != N){
 	if(sum == N) 
 		cnt++, end_idx++, sum 값 변경
 	else if(sum > N)
 		sum 값 변경 ,start_idx++
 	else if(sum < N)
 		end_idx++, sum 값 변경
 }
 
 cnt 값 출력
 */
import java.util.*;
public class P2018_수들의합5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int cnt = 1;
		int start_idx = 1;
		int end_idx = 1;
		int sum = 1;
		
		while(end_idx != N) {
			if(sum == N) {
				cnt++;
				end_idx++;
				sum = sum + end_idx;
			}
			else if(sum > N) {
				sum = sum - start_idx;
				start_idx++;
			}
			else if(sum < N) {
				end_idx++;
				sum = sum + end_idx;
			}
				
		}
		
		System.out.println(cnt);

	}

}
