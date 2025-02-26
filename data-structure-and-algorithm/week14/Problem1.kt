package `data-structure-and-algorithm`.`Week 14`

class Problem1 {
    public void rotate(int[] nums, int k) {
    int n = nums.length;

    // Rotating k = p * n + q times is equivalent
    // to rotatin     g just q times. q = k % n.
    // Hence, replace k with q, i.e. k = k % n.
    k %= n;

    // Let nums = [1, 2, 3, 4, 5, 6, 7]
    // and k = 3

    // Reverse the whole array.
    // nums = [**7, 6, 5, 4, 3, 2, 1**]
    reverse(nums, 0, nums.length - 1);

    // Reverse the first k elements of the array.
    // nums = [**5, 6, 7**, 4, 3, 2, 1]
    reverse(nums, 0, k - 1);

    // Reverse the rest of the array.
    // nums = [5, 6, 7, **1, 2, 3, 4**]
    reverse(nums, k, nums.length - 1);

    // Final result = [5, 6, 7, 1, 2, 3, 4] as intended.
}

    // Simple (sub-)array reversing algorithm.
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            // swap(nums[start], nums[end]);
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            // Move to the next pair of numbers.
            start++;
            end--;
        }
    }
}
}