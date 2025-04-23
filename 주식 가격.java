class Solution {
    public int[] solution(int[] prices) {
        int p = prices.length;
        int[] answer = new int[p];
        
        for (int i=0; i<p; i++) {
            int count = 0;
            for (int j= i+1; j<p; j++){
                count++;
                if (prices[i] > prices[j]) { // 값이 떨어질때 멈추기 : 떨어지지 않은 기간 이므로 
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
