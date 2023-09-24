package onboarding;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> emails = new HashSet<>();
        LongestCommonSubstring lcs = new LongestCommonSubstring();


        for (int i = 0; i < forms.size(); i++) {
            for (int j = i+1; j < forms.size(); j++) {
                if (lcs.isDuplicate(forms.get(i).get(1), forms.get(j).get(1))) {
                    emails.add(forms.get(i).get(0));
                    emails.add(forms.get(j).get(0));
                }
            }
        }

        return emails.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}

class LongestCommonSubstring {
    public boolean isDuplicate(String crew1, String crew2) {
        int crew1Length = crew1.length();
        int crew2Length = crew2.length();
        int[][] LCS = new int[crew1Length + 1][crew2Length + 1];
        char[] crew1Array = crew1.toCharArray();
        char[] crew2Array = crew2.toCharArray();

        for (int i = 1; i <= crew1Length; i++) {
            for (int j = 1; j <= crew2Length; j++) {
                if (crew1Array[i - 1] == crew2Array[j - 1] && LCS[i - 1][j - 1] >= 1) {// 두개 이상 중복이라면
                    return true;
                }
                if (crew1Array[i - 1] == crew2Array[j - 1]) {
                    LCS[i][j] = 1;
                }
            }
        }
        return false;
    }
}