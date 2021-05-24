public class StepNumber {
    public int numberOfSteps(int num) {
        int step = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num >> 1;
                step++;
            }

            else {
                num--;
                step++;
            }
        }
        return step;
    }
}

/**
 * Recursive solution using ternary operator :
 *     public int numberOfSteps(int num) {
        if(num == 0)
            return 0;
        else
            return 1 + numberOfSteps(num % 2 == 0 ? num >> 1 : num - 1);
    }
}

 */

/**
 * num is given find #steps to reduce it to 0
 * 
 * 
 * Logic: 1. if num is even then num>>1
 * 
 * num/2 = num>>1 2. if num is odd then num--
 * 
 */