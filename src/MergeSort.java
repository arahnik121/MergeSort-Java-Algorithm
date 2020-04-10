import java.util.Arrays;

public class MergeSort {
    public int[] sortArray(int[] A) {
        if (A == null) {
            System.out.println("Array is epmty!");
            return null;
        }

        if (A.length < 2) {
            return A;
        }

        int[] B = new int[A.length / 2];
        System.arraycopy(A, 0, B, 0, A.length / 2);

        int[] C = new int[A.length - A.length / 2];
        System.arraycopy(A, A.length / 2, C, 0, A.length - A.length / 2);

        B = sortArray(B);
        C = sortArray(C);

        return mergeArray(B, C);
    }

    public int[] mergeArray(int[] B, int[] C) {
        int[] A = new int[B.length + C.length];
        int posB = 0, posC = 0;

        for (int i = 0; i < A.length; i++) {
            if (posB == B.length) {
                A[i] = C[posC];
                posC++;
            } else if (posC == C.length) {
                A[i] = B[posB];
                posB++;
            } else if (B[posB] < C[posC]) {
                A[i] = B[posB];
                posB++;
            } else {
                A[i] = C[posC];
                posC++;
            }
        }
        return A;
    }

    public int[] fillArray() {
        int[] A = new int[6];
        for (int i = 0; i < A.length; i++) {
            A[i] = (int) (Math.random() * 10) + 1;
        }
        return A;
    }

    public static void main(String[] args) {
        MergeSort a = new MergeSort();
        int[] Array = a.fillArray();
        System.out.println(Arrays.toString(Array));
        System.out.println(Arrays.toString(a.sortArray(Array)));
    }
}
