class Solution {
    public int firstUniqChar(String s) {
        int[] countChars = new int[26];
        for (char c : s.toCharArray())
            countChars[c - 'a'] ++;
        
        for (int i = 0; i < s.length(); i++)
            if (countChars[s.charAt(i) - 'a'] == 1)
                return i;
        
        return -1;
    }
}
