/*
 수도코드:
 N(수), M(나누어 떨어지는 값) 입력받기
 S(합배열)선언
 C(M으로 나눈 나머지 값이 같은 그 수의 인덱스 카운트,
 나머지 값이 0이면 이 0이 똑같이 나오는 합배열이 몇개인지
 3개이면 C[0]이 3개있는거)

 for(i->N)
 	S[i] = S[i-1] + A[i]

 for(i->N){
 	reminder =S[i] % M
 	if(reminder == 0) answer++
 	C[reminder]++
 }

 for(i->M)
 	//C[i](i가 나머지 값인 인덱스의 개수)에서 서로 다른 2개를 뽑는 경우의 수
 	C[i] * (C[i]-1) / 2

 answer 출력

 */
import java.util.*;
public class P10986_나머지합 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long S[] = new long[N];
        long C[] = new long[M];
        long answer = 0;
        S[0] = sc.nextInt();

        for(int i =1 ; i< N; i++)
            S[i] = S[i-1] + sc.nextInt();

        for(int i = 0; i < N; i++) {
            int reminder = (int)(S[i] % M);
            if(reminder == 0) answer++;
            C[reminder]++;
        }

        for(int i =0 ; i< M; i++)
            if (C[i] > 1)
                answer = answer + (C[i] * (C[i]-1) / 2);

        System.out.println(answer);
    }

}