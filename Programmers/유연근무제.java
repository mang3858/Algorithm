class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int n = schedules.length;

        for (int i = 0; i < n; i++) {
            boolean success = true;

            for (int j = 0; j < 7; j++) {
                int weekday = (startday - 1 + j) % 7;
                if (weekday == 5 || weekday == 6) continue;

                int limit = addTenMinutes(schedules[i]);
                int actual = timelogs[i][j];

                if (actual > limit) {
                    success = false;
                    break;
                }
            }

            if (success) answer++;
        }

        return answer;
    }

    private int addTenMinutes(int time) {
        int hour = time / 100;
        int min = time % 100;

        min += 10;
        if (min >= 60) {
            hour += 1;
            min -= 60;
        }

        return hour * 100 + min;
    }
}