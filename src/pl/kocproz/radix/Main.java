package pl.kocproz.radix;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


//        Random r = new Random();
//        for (int i = 0; i < 30; i++) {
//            inputList[i] = r.nextInt(999);
//            System.out.print(inputList[i] + ",");
//        }
//        System.out.println();
//
//
//        for (int i : outputList) {
//            System.out.print(i + ",");
//        }

    }

    public static int[] radixSort(int[] inputList) {
        int[] numbersList = new int[10];
        int[] outputList = new int[inputList.length];
        int digitBuffer;

        for (int j = 1; j < ("" + Integer.MAX_VALUE).length(); j++) {
            for (int i = 0; i < inputList.length; i++) {
                numbersList[getDigit(inputList[i], j)]++;
            }

            for (int i = 1; i < 10; i++) {
                numbersList[i] += numbersList[i - 1];
            }

            for (int i = inputList.length - 1; i > -1; i--) {
                digitBuffer = getDigit(inputList[i], j);
                numbersList[digitBuffer]--;
                outputList[numbersList[digitBuffer]] = inputList[i];
            }
            System.arraycopy(outputList, 0, inputList, 0, inputList.length);
            Arrays.fill(numbersList, 0);
        }
        return outputList;
    }

    public static int[] radixSortBinary(int[] inputList) {
        int[] numbersList = new int[2];
        int[] outputList = new int[inputList.length];
        int digitBuffer;

        for (int j = 0; j < 32; j++) {
            for (int i = 0; i < inputList.length; i++) {
                numbersList[getBinaryDigit(inputList[i], j)]++;
            }

            numbersList[1] += numbersList[0];

            for (int i = inputList.length - 1; i > -1; i--) {
                digitBuffer = getBinaryDigit(inputList[i], j);
                numbersList[digitBuffer]--;
                outputList[numbersList[digitBuffer]] = inputList[i];
            }
            System.arraycopy(outputList, 0, inputList, 0, inputList.length);
            Arrays.fill(numbersList, 0);
        }
        return outputList;
    }

    public static int getBinaryDigit(int number, int digit) {
        return (number >> digit) & 1;
    }

    public static int getFirstDigit(int number) {
        return number % 10;
    }

    public static int getSecondDigit(int number) {
        return ((number / 10)) % 10;
    }

    public static int getThirdDigit(int number) {
        return ((number / 100)) % 10;
    }

    public static int getDigit(int number, int digit) {
        int divider = (int) Math.pow(10, digit - 1);
        return (number / divider) % 10;
    }

}
