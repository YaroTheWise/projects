import java.util.List;

import com.company.AerageOfLevels;
import com.company.TreeNode;
import org.junit.jupiter.api.Test;

public class AerageOfLevelsTest {

    @Test
    public void first(){
//        3,9,20,null,null,15,7;




        TreeNode left = new TreeNode(9,null,null);
        TreeNode rightleft = new TreeNode(15,null,null);
        TreeNode rightright = new TreeNode(7,null,null);
        TreeNode right = new TreeNode(20, rightleft,rightright);
        TreeNode root = new TreeNode(3,left,right);

        AerageOfLevels aerageOfLevels = new AerageOfLevels();

        aerageOfLevels.averageOfLevels(root);

    }
}
