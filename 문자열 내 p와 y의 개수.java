import java.util.Arrays;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        String [] solve = s.split("");
        
        int p = 0;
        int y = 0;
        
        for (int i=0; i<s.length(); i++) {
            if (solve[i].equals("p") || solve[i].equals("P")) {
                p += 1;
            } else if (solve[i].equals("y") || solve[i].equals("Y")) {
                y += 1;
            }
        }
        
        if (p == y) {
            answer = true;
        } else if (p != y) {
            answer = false;
        }

        return answer;
    }
}
