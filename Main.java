import java.util.*;

public final class Main {

    public static final class HeapSort {

        private void swap(final int[] a, final int i, final int j) {
            final int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        private void hipify(final int[] a, final int size, final int index) {

            int parent = index;
            final int left = (parent * 2) + 1;
            final int right = (parent * 2) + 2;

            if (left < size && (a[left] > a[parent]))
                parent = left;

            if (right < size && (a[right] > a[parent]))
                parent = right;

            if (parent != index) {
                this.swap(a, index, parent);
                this.hipify(a, size, parent);
            }
        }

        public void sortRecursive(final int[] a) {

            for (int i = a.length / 2; i >= 0; i--)
                this.hipify(a, a.length, i);

            for (int i = a.length - 1; i > 0; i--) {
                this.swap(a, i, 0);

                // Preserve max heap property
                this.hipify(a, i, 0);
            }
        }

        private void buildMaxHeap(final int[] a, final int size) {

            for (int i = 1; i < size; i++) {
                int j = i;

                while (a[j] > a[(j - 1) / 2]) {
                    this.swap(a, j, (j - 1) / 2);
                    j = (j - 1) / 2;
                }
            }
        }

        public void sortIterative(final int[] a) {

            this.buildMaxHeap(a, a.length);

            for (int i = a.length - 1; i > 0; i--) {
                this.swap(a, i, 0);

                // Preserve max heap property
                this.buildMaxHeap(a, i);
            }
        }
    }

    public static void main(String[] args) {

        final int[] a =  {2,4,1,7,55,6,88,3,9,0};
        new HeapSort().sortIterative(a);
        System.out.println(Arrays.toString(a));

        final int[] b =  {4,6,7,1,0,-3,8,5,22,4};
        new HeapSort().sortRecursive(b);
        System.out.println(Arrays.toString(b));

    }
}


