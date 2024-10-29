package March2023;
/*
 * @lc app=leetcode id=912 lang=java
 *
 * [912] Sort an Array
 */

// @lc code=start
class Solution {
    private void merge(int[] arr, int left, int mid, int right, int[] tempArr) {
        int start1 = left;
        int start2 = mid + 1;
        int size1 = mid - left + 1;
        int size2 = right - mid;
        for (int i = 0; i < size1; i++) {
            tempArr[start1 + i] = arr[start1 + i];
        }
        for (int i = 0; i < size2; i++) {
            tempArr[start2 + i] = arr[start2 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < size1 && j < size2) {
            if (tempArr[start1 + i] <= tempArr[start2 + j]) {
                arr[k] = tempArr[start1 + i];
                i++;
            } else {
                arr[k] = tempArr[start2 + j];
                j++;
            }
            k++;
        }
        while (i < size1) {
            arr[k] = tempArr[start1 + i];
            i++;
            k++;
        }
        while (j < size2) {
            arr[k] = tempArr[start2 + j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] arr, int left, int right, int[] tempArr) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, tempArr);
        mergeSort(arr, mid + 1, right, tempArr);
        merge(arr, left, mid, right, tempArr);
    }

    public int[] sortArray(int[] nums) {
        int[] tempArr = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, tempArr);
        return nums;
    }
}
// @lc code=end