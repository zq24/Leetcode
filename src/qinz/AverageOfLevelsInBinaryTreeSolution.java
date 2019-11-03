package qinz;

import java.util.ArrayList;
import java.util.List;

public class AverageOfLevelsInBinaryTreeSolution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Double>> result = new ArrayList<>();
        LevelTreeHelper(root, result, 0);
        List<Double> res = new ArrayList<>();
        for(int i = 0; i < result.size(); i++) {
            res.add(result.get(i).get(0) / result.get(i).get(1));
        }
        return res;
    }

    private void LevelTreeHelper(TreeNode root, List<List<Double>> res, int height) {
        if(root == null)
            return;
        if(height >= res.size()) {
            List<Double> newLevel = new ArrayList<>();
            newLevel.add(0.0);
            newLevel.add(0.0);
            res.add(newLevel);
        }
        double changeSum = res.get(height).get(0);
        changeSum += root.val;
        res.get(height).set(0, changeSum);
        double changeNumOfElement = res.get(height).get(1);
        changeNumOfElement++;
        res.get(height).set(1, changeNumOfElement);
        LevelTreeHelper(root.left, res, height + 1);
        LevelTreeHelper(root.right, res, height + 1);
    }
}
