package inhatc.cse.java.algorithm.days;

public class Day2 {
    public static void main(String[] args) {
        int[] data = {5, 12, 7, 20, 3, 15, 8, 10};
        int startIndex = 0;
        int dataLength = data.length;
        int maxSum = 0;
        if(dataLength < 3){
            System.out.println("배열의 길이가 3보다 작습니다.");
            for(int i = 0; i < dataLength; i++){
                maxSum += data[i];
            }
            startIndex = 0;
        } else {
            for (int i = 0; i < data.length; i++) {
                if (i + 2 < dataLength) {
                    int sum = data[i] + data[i + 1] + data[i + 2];
                    if (sum > maxSum) {
                        maxSum = sum;
                        startIndex = i;
                    }
                }
            }
        }
        System.out.println("연속된 세 수의 합이 가장 큰 값: " + maxSum);
        System.out.print("연속된 세 수: ");
        for (int i = startIndex; i < startIndex + 3 && i < dataLength; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
