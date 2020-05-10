import javax.swing.SwingUtilities;

public class Sorting {

    public static void bubbleSort(Visualizer visualizer, Chooser chooser) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                int[] arr = visualizer.getArray();
                boolean swapped = true;

                chooser.turnOffAll();

                while (swapped == true) {
                    swapped = false;

                    for (int i = 0; i < arr.length - 1; i++) {
                        if (arr[i] > arr[i + 1]) {
                            int temp = arr[i];
                            arr[i] = arr[i + 1];
                            arr[i + 1] = temp;

                            swapped = true;

                            SwingUtilities.invokeLater(new Runnable() {

                                @Override
                                public void run() {
                                    visualizer.setArray(arr);
                                }
                            });

                            try {
                                Thread.sleep(1);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                chooser.turnOn();
            }
        };
        thread.start();
    }

    public static void mergeSort(Visualizer visualizer, Chooser chooser) {
        Thread thread = new Thread() {

            @Override
            public void run() {
                int[] arr = visualizer.getArray();

                chooser.turnOffAll();

                merge(visualizer, arr, 0, arr.length - 1);

                chooser.turnOn();
            }
        };
        thread.start();
    }

    private static void merge(Visualizer visualizer, int[] arr, int start, int end) {
        int mid = (start + end) / 2;

        if (start < end) {
            merge(visualizer, arr, start, mid);
            merge(visualizer, arr, mid + 1, end);
            mergeHelper(visualizer, arr, start, mid, end);
        }
    }

    private static void mergeHelper(Visualizer visualizer, int[] arr, int start, int mid, int end) {

        int[] leftArr = new int[(mid + 1) - start];
        int[] rightArr = new int[end - mid];
        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = arr[start + i];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[mid + i + 1];
        }

        int i = start;
        while (leftIndex < leftArr.length && rightIndex < rightArr.length) {
            if (leftArr[leftIndex] > rightArr[rightIndex]) {
                arr[i] = rightArr[rightIndex];
                rightIndex++;
            } else {
                arr[i] = leftArr[leftIndex];
                leftIndex++;
            }
            i++;

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    visualizer.setArray(arr);
                }
            });

            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while (leftIndex < leftArr.length) {
            arr[i] = leftArr[leftIndex];
            leftIndex++;
            i++;

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    visualizer.setArray(arr);
                }
            });

            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        while (rightIndex < rightArr.length) {
            arr[i] = rightArr[rightIndex];
            rightIndex++;
            i++;

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    visualizer.setArray(arr);
                }
            });

            try {
                Thread.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void quickSort(Visualizer visualizer, Chooser chooser) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                int[] arr = visualizer.getArray();
                chooser.turnOffAll();

                System.out.println("quickSort");

                chooser.turnOn();
            }
        };
        thread.run();
    }
}