public class ProblemSet13 {

    public boolean groupSum(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start > numbers.length - 1) {
            return false;
        }

        if (numbers[start] > target) {
            return groupSum(start + 1, numbers, target);
        }
        else {
            return groupSum(start + 1, numbers, target) || groupSum(start + 1, numbers, target - numbers[start]);
        }
    }

    public boolean groupSum6(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start > numbers.length - 1) {
            return false;
        }

        if (numbers[start] == 6) {
            return groupSum6(start + 1, numbers, target - numbers[start]);
        }
        else if (numbers[start] > target) {
            return groupSum6(start + 1, numbers, target);
        }
        else {
            return groupSum6(start + 1, numbers, target) || groupSum6(start + 1, numbers, target - numbers[start]);
        }
    }

    public boolean groupNoAdj(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start > numbers.length - 1) {
            return false;
        }

        if (numbers[start] > target) {
            return groupNoAdj(start + 1, numbers, target);
        }
        else {
            return groupNoAdj(start + 1, numbers, target) || groupNoAdj(start + 2, numbers, target - numbers[start]);
        }
    }

    public boolean groupSum5(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start > numbers.length - 1) {
            return false;
        }

        if (numbers[start] % 5 == 0) {
            return groupSum5(start + 1, numbers, target - numbers[start]);
        }
        else if (start != 0 && numbers[start] == 1 && numbers[start - 1] % 5 == 0) {
            return groupSum5(start + 1, numbers, target);
        }
        else if (numbers[start] > target) {
            return groupSum5(start + 1, numbers, target);
        }
        else {
            return groupSum5(start + 1, numbers, target) || groupSum5(start + 1, numbers, target - numbers[start]);
        }
    }

    public boolean groupSumClump(int start, int[] numbers, int target) {
        if (target == 0) {
            return true;
        }
        if (start > numbers.length - 1) {
            return false;
        }

        if (numbers[start] > target) {
            return groupSumClump(start + 1, numbers, target);
        }
        else if (start < numbers.length - 1 && numbers[start] == numbers[start + 1]) {
            int count = 1;
            int current = start;
            while (start < numbers.length - 1 && numbers[start] == numbers[start + 1]) {
                start ++;
                count ++;
            }
            return groupSumClump(start + 1, numbers, target) || groupSumClump(start + 1, numbers, target - (numbers[current]*count));
        }
        else {
            return groupSumClump(start + 1, numbers, target) || groupSumClump(start + 1, numbers, target - numbers[start]);
        }
    }

    public boolean splitArray(int[] numbers) {
        if (numbers.length == 1) {
            return false;
        }
        else if (numbers.length == 0) {
            return true;
        }
        return splitArrayHelper(numbers, 0, numbers[0]);
    }

    public boolean splitArrayHelper(int[] numbers, int start, int rightSum) {
        if (start > numbers.length - 1) {
            return false;
        }

        int leftSum = 0;
        for (int i = start + 1; i < numbers.length; i++) {
            leftSum += numbers[i];
        }

        if (rightSum == leftSum) {
            return true;
        }
        else {
            return splitArrayHelper(numbers, start + 1, rightSum + numbers[start]);
        }
    }

    public boolean splitOdd(int[] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        else if (numbers.length == 1) {
            return true;
        }
        return splitOddHelper(numbers, 0, numbers[0]);
    }

    public boolean splitOddHelper(int[] numbers, int start, int rightSum) {
        if (start > numbers.length - 1) {
            return false;
        }

        int leftSum = 0;
        for (int i = start + 1; i < numbers.length; i++) {
            leftSum += numbers[i];
        }

        if (rightSum % 10 == 0 && leftSum % 2 == 1) {
            return true;
        }
        else {
            return splitOddHelper(numbers, start + 1, rightSum + numbers[start]);
        }
    }
}
