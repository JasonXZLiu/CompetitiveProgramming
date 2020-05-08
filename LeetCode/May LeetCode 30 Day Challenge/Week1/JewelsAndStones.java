class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels = new HashSet<>();
        for (char j : J.toCharArray())
            jewels.add(j);
        
        int count = 0;
        for (char s : S.toCharArray())
            if (jewels.contains(s))
                count ++;
        
        return count;
    }
}
