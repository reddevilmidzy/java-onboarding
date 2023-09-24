package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        Decryption decryption = new Decryption();
        return decryption.decoding(cryptogram);
    }
}

class Decryption {

    public String decoding(String password) {
        int cnt = password.length()/2;
        String res = decoded(password);

        while (cnt-->0) {
            if (password.equals(res)) {
                break;
            }
            password = res;
            res = decoded(password);
        }

        return res;
    }

    private String decoded(String password) {
        StringBuilder res = new StringBuilder();
        char pre = ' ';
        boolean duplicated = false;
        int n = password.length();

        for (int i = 0; i < n; i++) {
            if (password.charAt(i) != pre) {
                if (!duplicated && pre != ' ') {
                    res.append(pre);
                }
                pre = password.charAt(i);
                duplicated = false;
            } else {
                duplicated = true;
            }
        }
        if (!duplicated && pre != ' ') {
            res.append(pre);
        }

        return res.toString();
    }
}
