class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        double slope = getSlope(coordinates[1], coordinates[0]);
        
        for (int i = 2; i < coordinates.length; i++) {
            if (getSlope(coordinates[i], coordinates[0]) != slope) return false;
        }
        
        return true;
    }
    
    public double getSlope(int[] a, int[] b) {
        return (a[1] - b[1]) / ((double) (a[0] - b[0]));
    } 
}
