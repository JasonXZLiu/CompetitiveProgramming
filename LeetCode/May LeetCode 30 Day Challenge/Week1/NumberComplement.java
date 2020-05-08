class Solution {
    public int findComplement(int num) {
        int exp = (int) (Math.log(num) / Math.log(2)) + 1;
        return (1 << exp) + ~num;
    }
}
