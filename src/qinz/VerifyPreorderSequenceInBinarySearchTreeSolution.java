package qinz;

public class VerifyPreorderSequenceInBinarySearchTreeSolution {
    public boolean verifyPreorder(int[] preorder) {
        return false;
    }

    public boolean verifyPreorderHelper(int[] preorder, int lo, int hi, int currentRootIndex) {
        if (preorder[currentRootIndex] < lo || preorder[currentRootIndex] > hi) {
            return false;
        }
        return false;
    }
}
