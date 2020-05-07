import java.util.Arrays;

public class Main {

    private static void printArray(int[][] A) {
        for (int[] row: A) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    private static int computeCommonFacesAround(int[][] A, int i, int j) {
        int ref = A[i][j];
        int right = A[i][j + 1];
        int left = A[i][j - 1];
        int top = A[i + 1][j];
        int bottom = A[i - 1][j];
        return Math.min(ref, right) +
               Math.min(ref, left) +
               Math.min(ref, top) +
               Math.min(ref, bottom);
    }

    public static int solution(int[][] A, int cols, int rows) {

        int[][] newA = new int[rows + 2][cols + 2];

        for (int i = 0; i < rows; i++) {
            if (cols >= 0) System.arraycopy(A[i], 0, newA[i + 1], 1, cols);
        }

//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                newA[i + 1][j + 1] = A[i][j];
//            }
//        }

        System.out.println("Augmented Matrix: ");
        printArray(newA);

        int surfaceAreaAcc = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int height = newA[i + 1][j + 1];
                int area = height > 0 ? 2 * (2 * height + 1) : 0;
                int commonFaces = computeCommonFacesAround(newA, i + 1, j + 1);
                surfaceAreaAcc += area - commonFaces;
            }
        }

        return surfaceAreaAcc;
    }

    public static void main(String[] args) {

//        int rows = 3;
//        int cols = 3;
//
//        int[] row1 = {1, 3, 4};
//        int[] row2 = {2, 2, 3};
//        int[] row3 = {1, 2, 4};
//
//        int[][] A = {row1, row2, row3};
//



        int rows = 3;
        int cols = 3;

        int[] row1 = {1, 0, 0};
        int[] row2 = {0, 0, 0};
        int[] row3 = {1, 0, 0};

        int[][] A = {row1, row2, row3};



        System.out.println("Initial Matrix:");
        printArray(A);

        int totalArea = solution(A, cols, rows);

        System.out.println("Total Surface Area:");
        System.out.println(totalArea);
    }
}
