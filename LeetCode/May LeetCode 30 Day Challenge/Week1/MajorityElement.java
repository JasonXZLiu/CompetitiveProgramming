class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums)
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        
        for (Map.Entry<Integer, Integer> entry : counts.entrySet())
            if (entry.getValue() > nums.length / 2)
                return entry.getKey();
        
        return -1;
    }
}
