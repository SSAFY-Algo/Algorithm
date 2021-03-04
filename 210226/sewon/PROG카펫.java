class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        for(int num = yellow; num > 0; num--) {
            if(yellow % num == 0) { // 약수
                int width = num;
                int height = yellow / num;
                int count = (width*2) + (height*2) + 4;
                
                if(brown == count) {
                    answer[0] = width + 2;
                    answer[1] = height + 2;
                    return answer;
                }
            }
        }
        return answer;
    }
}
