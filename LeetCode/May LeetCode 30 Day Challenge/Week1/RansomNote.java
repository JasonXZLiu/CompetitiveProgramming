class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCount = new int[26];
        int totalCount = ransomNote.length();
        
        for (char c : ransomNote.toCharArray()) 
            charCount[c - 'a'] ++;
        
        for (char c : magazine.toCharArray()) {
            if (charCount[c - 'a'] != 0) {
                charCount[c - 'a'] --;
                totalCount --;
            }
            
            if (totalCount == 0) return true;
        }
        
        return totalCount == 0;
    }
}
