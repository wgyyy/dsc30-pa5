/*
 * NAME: Gaoying Wang
 * PID:  A16131629
 */
import java.util.ArrayList;

/**
 * Sorts class.
 * @param <T> Generic type
 * @author Gaoying Wang
 * @since  ${2022-0202}
 */
public class Sorts<T extends Comparable<? super T>> {

    private static final int MIDDLE_IDX = 2;

    /**
     * This method performs insertion sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The initial index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void InsertionSort(ArrayList<T> list, int start, int end) {
        T temp;
        for (int i = start + 1; i <= end;i ++) {
            int j = i;
            while (j > start && list.get(j).compareTo(list.get(j - 1)) < 0){
                temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                --j;
            }
        }
    }

    /**
     * This method performs merge sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void MergeSort(ArrayList<T> list, int start, int end) {

        if (start < end)
        {
            int mid = start + (end - start) / MIDDLE_IDX;
            MergeSort(list, start, mid);
            MergeSort(list, mid + 1, end);

            merge(list, start, mid, end);
        }
    }

    /**
     * merge helper function for MergeSort
     *
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param m the middle index we want to merge
     * @param r right-most index we want to merge
     */
    private void merge(ArrayList<T> arr, int l, int m, int r) {

        int mergedSize = r - l + 1;

        ArrayList<T> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            }
            else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    /**
     * This method performs quick sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void QuickSort(ArrayList<T> list, int start, int end) {
        if (start >= end) {
            return;
        }
        int endindex = this.partition(list, start, end);
        QuickSort(list, start, endindex);
        QuickSort(list, endindex + 1, end);

    }

    /**
     * partition helper function for QuickSort
     *
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param h right-most index we want to merge
     */
    private int partition(ArrayList<T> arr, int l, int h) {
        int mid = l + (h - l) / 2;
        T pivot = arr.get(mid);
        boolean done = false;
        while (!done) {
            while (arr.get(l).compareTo(pivot) < 0) {
                l += 1;
            }
            while (pivot.compareTo(arr.get(h)) < 0) {
                h -= 1;
            }
            if (l >= h) {
                done = true;
            } else {
                T temp = arr.get(l);
                arr.set(l, arr.get(h));
                arr.set(h, temp);
                l += 1;
                h -= 1;
            }
        }
        return h;
    }

    /**
     * This method performs a modified QuickSort that switches to insertion sort
     * after a certain cutoff
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     * @param cutoff the minimum length of an subsection of the arraylist
     *               such that we switch to Insertion Sort
     */
    public void Modified_QuickSort(ArrayList<T> list, int start, int end, int cutoff) {
        if (start >= end) {
            return;
        }
        int endindex = this.partition(list, start, end);
        if ((endindex - start) > cutoff - 1) {
            Modified_QuickSort(list, start, endindex, cutoff);
        } else {
            InsertionSort(list, start, endindex);
        }
        if ((end - endindex - 1)> cutoff - 1){
            Modified_QuickSort(list, endindex + 1, end, cutoff);
        } else {
            InsertionSort(list,endindex - 1, end);
        }
    }

    /**
     * This method performs cocktail sort on the input list
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist we want to sort
     * @param end The final index of the subsection of Arraylist we want to sort
     */
    public void cocktailSort(ArrayList<T> list, int start, int end){
        boolean condition = true;
        while (condition){
            condition = false;
            for (int x = start; x < end; x++){
                if ((list.get(x).compareTo(list.get(x + 1)) > 0)){
                    T temp = list.get(x);
                    list.set(x, list. get(x + 1));
                    list.set(x + 1, temp);
                    condition = true;
                }
            }
            if (condition == false) {
                break;
            }
            condition = false;
            for (int y = end; y > start; y--){
                if ((list.get(y).compareTo(list.get(y - 1))) < 0){
                    T temp = list.get(y);
                    list.set(y,list.get(y - 1));
                    list.set(y - 1,temp);
                    condition = true;
                }
            }
        }
    }

}