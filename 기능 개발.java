import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
       
        int n = progresses.length; // 많이 사용할 것 같아서 변수로 간단하게 선언
        int[] days = new int [n]; // 배열 선언
        
        for (int i=0; i<n; i++) {
            int count = 0;
            while (progresses[i] < 100) {
            	progresses[i] += speeds[i];
            	count++;
            }
            days[i] += count;
        }
        
        // 배포 순서 
        int[] temp = new int[n];
        int count = 0;
        int idx = 0;
        int prev = days[0];
        
        for (int i=0; i<n; i++) {
            if (days[i] <= prev){
                    count++;
                } else {
                    temp[idx++] = count;
                    count = 1;
                    prev = days[i];
                }
        }
        temp[idx++] = count; // 마지막으로 count를 저장해줘야 하기 때문에 사용
        
        // answer에 배열에 맞게 넣기
        int[] answer = new int [idx];
        for (int i = 0; i<idx; i++) {
            answer[i] = temp[i];
        }
        
        return answer;
    }
}
