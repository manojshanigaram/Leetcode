class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int x=Math.max(x1,Math.min(x2,xCenter));
        int y=Math.max(y1,Math.min(y2,yCenter));
        int dx=xCenter-x;
        int dy=yCenter-y;
        return dx*dx+dy*dy<=radius*radius;
    }
}