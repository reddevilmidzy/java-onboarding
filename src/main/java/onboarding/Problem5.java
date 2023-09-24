package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        int[] wonList = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        Money coin = new Money(wonList);
        return coin.change(money);
    }
}

class Money {
    private final int[] wonList;

    public Money(int[] wonList) {
        this.wonList = wonList;
    }

    public List<Integer> change(int money) {
        List<Integer> res = new ArrayList<>(9);

        for (int won : wonList) {
            res.add(changedMoney(money, won));
            money = leftMoney(money, won);
        }

        return res;
    }

    private int leftMoney(int money, int won) {
        return money % won;
    }

    private int changedMoney(int money, int won) {
        return money / won;
    }
}