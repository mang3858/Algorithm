class Solution {
    public int solution(int n, int w, int num) {//3, 6
        int answer = 1; //자기꺼 일단 포함 
        int row = (num-1)/w; 
        int position = (num-1)%w;
        int col;
        
        if(row %2 == 0){
            col = position;
        }   
        else{
            col = w - 1 - position;
        }
        
        // 현재 num(6): 1의 위층부터 검사함 floor = 2
        for (int floor = row + 1;  floor* w < n; floor++) {
            
            /*              idx
            0층: 1 2 3      0 1 2
            1층: 6 5 4      3 4 5
            2층: 7 8 9      6 7 8
            3층: 12 11 10   9 10 11
            4층: 13
            
            짝수층이면 그대로 홀수층이면 반대로 
            */
            int idx;
            if (floor % 2 == 0) { 
                idx = floor * w + col;
            } else {
                idx = floor * w + (w - 1 - col);
            }
            if (idx < n) answer++;
        }
        
        return answer;
    }
}