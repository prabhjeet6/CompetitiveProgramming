package gfg.sorting;

class SegregateEvenAndOddNumbers {
    void segregateEvenOdd(int[] nums) {
        int odd = 0, even = 0;
        for (int num : nums) {
            if (num % 2 == 1) odd++;
            else even++;
        }
        if (!(odd == 0 || even == 0)) {
            int left = 0, right = even - 1;
            while (left < odd - 1 || right < nums.length) {
                if (right >= nums.length) break;
                if (nums[left] % 2 == 0) {
                    left++;
                }
                if (nums[right] % 2 == 1) {
                    right++;
                }
                if (nums[left] % 2 == 1) {
                    if (right < nums.length && nums[right] % 2 == 0) {
                        swap(nums, left, right);
                    }
                }
            }
            quickSort(nums, 0, even - 1);
            quickSort(nums, even, nums.length - 1);

        }
    }

    void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    void quickSort(int arr[], int low, int high) {
        if (low > high) {
            return;
        }
        int p = partition(arr, low, high);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

    int partition(int arr[], int low, int high) {
        int pivot = low;
        int left = low + 1;
        int right = high;
        while (left <= right) {
            while (left <= high && arr[left] <= arr[pivot]) {
                left++;
            }
            while (right >= low && arr[right] > arr[pivot]) {
                right--;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, pivot, right);
        return right;
    }
}