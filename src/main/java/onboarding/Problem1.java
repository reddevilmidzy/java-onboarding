package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        Validator validator = new Validator();
        Calculator calculator = new Calculator();

        if (validator.isValidate(pobi) && validator.isValidate(crong)) {
            return calculator.compare(pobi, crong);
        }
        return -1;
    }
}

class Calculator {

    public int compare(List<Integer> pobi, List<Integer> crong) {
        int pobiVal = maxValue(pobi);
        int crongVal = maxValue(crong);

        if (pobiVal > crongVal) {
            return 1;
        } else if (pobiVal < crongVal) {
            return 2;
        }
        return 0;
    }

    private int maxValue(List<Integer> pages) {
        return pages.stream()
                .mapToInt(val -> Math.max(maxAddValue(val), maxMulValue(val)))
                .max()
                .orElse(0);
    }

    private int maxAddValue(Integer integerVal) {
        return String.valueOf(integerVal)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

    private int maxMulValue(Integer integerVal) {
        return String.valueOf(integerVal)
                .chars()
                .map(Character::getNumericValue)
                .reduce(1, (a, b) -> (a * b));
    }
}

class Validator {
    public boolean isValidate(List<Integer> pages) {
        if (pages.size() != 2) {
            return false;
        }
        if (pages.get(0) % 2 != 1) {
            return false;
        }
        if (pages.get(1) % 2 != 0) {
            return false;
        }
        if (pages.get(1) - pages.get(0) != 1) {
            return false;
        }
        return 1 < pages.get(0) && pages.get(1) < 400;
    }
}