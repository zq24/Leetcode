package qinz;

public class RectangleOverlapSolution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !isRectangleNotOverlap(rec1, rec2);
    }

    public boolean isRectangleNotOverlap(int[] rec1, int[] rec2) {
        return true;
    }
}
