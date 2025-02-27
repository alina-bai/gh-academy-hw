package `data-structure-and-algorithm`.`Week 14`

class Problem2 {
    public void sortColors(int[] nums) {
        // We want to insert 0s one-by-one into their positions
        // starting from index 0.
        int zeroInsertPos = 0;

        // We want to insert 2s one-by-one into their positions
        // starting from the last index (nums.length - 1).
        int twoInsertPos = nums.length - 1;

        // Initialize iterator.
        int i = 0;

        // Everything to the right of twoInsertPos is rightfully
        // filled with 2s. When iterator goes into the territory of
        // 2s, stop.
        while (i <= twoInsertPos) {
            if (nums[i] == 0) {
                // If we see a 0, put it into its respective position,
                // i.e. we do swap(nums[zeroInsertPos], nums[i]).
                swap(nums, zeroInsertPos, i);
                zeroInsertPos++;
                i++;
            } else if (nums[i] == 1) {
                // If we see a 1, just leave it to be where it is.
                i++;
            } else { // nums[i] == 2
                // If we see a 2, put it into its respective position,
                // i.e. we do swap(nums[i], nums[twoInsertPos]).
                swap(nums, i, twoInsertPos);
                twoInsertPos--;
                // Don't advance i to (i + 1) because if nums[i] AFTER SWAP
                // equals 0, then we should put that 0 to its respective position,
                // so don't advance yet – wait until the next iteration on i.
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
