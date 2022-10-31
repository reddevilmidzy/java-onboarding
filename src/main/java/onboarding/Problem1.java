/*
 * 클래스명: Problem1
 *
 * 시작 날짜: 2022-10-27
 */

package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        MaxPoint maxPoint = new MaxPoint();

        int pobiMaxPoint = maxPoint.maxPoint(pobi);
        int crongMaxPoint = maxPoint.maxPoint(crong);
        int answer;

        if (pobiMaxPoint==-1 || crongMaxPoint==-1){
            return -1;
        }
        if (pobiMaxPoint>crongMaxPoint){
            return 1;
        }
        if (pobiMaxPoint<crongMaxPoint){
            return 2;
        }
        if (pobiMaxPoint==crongMaxPoint) {
            return 0;
        }
        return -1;
    }
}

class MaxPoint {
    public int maxPoint(List<Integer> player) {
        String leftPage = String.valueOf(player.get(0));
        String rightPage = String.valueOf(player.get(1));
        int myPoint;

        if (Math.abs(Integer.parseInt(leftPage) - Integer.parseInt(rightPage)) == 1) {
            int leftPlus = 0;
            int leftTimes = 1;
            int rightPlus = 0;
            int rightTimes = 1;

            for (int i = 0; i < leftPage.length(); i++) {
                //nSystem.out.println("Before leftPlus: "+leftPlus);
                leftPlus += (int) leftPage.charAt(i) - '0';
                leftTimes *= ((int) leftPage.charAt(i) - '0');
            }

            for (int i = 0; i < rightPage.length(); i++) {
                rightPlus += (int) rightPage.charAt(i) - '0';
                rightTimes *= ((int) rightPage.charAt(i) - '0');
            }

            myPoint = Math.max(Math.max(leftPlus, leftTimes), Math.max(rightPlus, rightTimes));

        } else {
            myPoint = -1;
        }

        return myPoint;
    }
}

class IsValidPage {
    public boolean isValidPage(List<Integer> player1, List<Integer> player2) {
        //왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수인지 확인
        int leftPage1 = player1.get(0);
        int leftPage2 = player2.get(0);
        int rightPage1 = player1.get(1);
        int rightPage2 = player2.get(1);
        
        if(leftPage1 % 2 == 0 || leftPage2 % 2 == 0) {
            return false;
        }
        if(rightPage1 % 2 != 0 || rightPage2 % 2 != 0) {
            return false;
        }
        return true;
    }
}