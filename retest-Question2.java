package PractiseTest2_java;

public class Test {
    public static void main(String[] args) {

        System.out.println(solve(12, new int[]{2, 3, 7, 8, 7, 6, 3, 8, 12, 11, 12, 10})); // 5
        System.out.println(solve(7, new int[]{3, 7, 8, 12, 4, 9, 8}));  //3
        System.out.println(solve(5, new int[]{8, 2, 11, 4, 1})); // 1
        System.out.println(solve(10, new int[]{7, 2, 2, 5, 1, 11, 3, 1, 5, 9}));    //1
    }

    public static int solve(int N, int[] workloads) {
        int longest = 0;
        int current = 1;
        for (int i = 1; i < N; i++) {
            if (workloads[i - 1] > 6 && workloads[i] > 6) {
                current++;
            } else {
                longest = Math.max(current, longest);
                current = 1;
            }
            longest = Math.max(current, longest);
        }
        return longest;
    }
}
