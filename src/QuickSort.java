public class QuickSort {

    static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

        public static void quickSort(int[] arr, int start, int end) {

            if (start >= end) return;

            int pivot = arr[start];
            int i = start;
            int j = end;

            while (i < j) {

                while (i < j && arr[j] >= pivot) {
                    j--;
                }
                while (i < j && arr[i] <= pivot) {
                    i++;
                }

                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

            // place pivot at correct position
            arr[start] = arr[i];
            arr[i] = pivot;

            quickSort(arr, start, i - 1);
            quickSort(arr, i + 1, end);
        }

        public static void main(String[] args) {
            int[] arr = {5, 3, 8, 4, 2};

            quickSort(arr, 0, arr.length - 1);

            printArray(arr);
        }
    }

