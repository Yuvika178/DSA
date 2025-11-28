class Solution {
    public int removeElement(int[] nums, int val) {
     
        int k = 0; // Pointer to track position for valid elements

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Place valid element at position k
                k++; // Increment k for next valid element
            }
        }

        return k; // Return the count of valid elements
    }
}


        
    
