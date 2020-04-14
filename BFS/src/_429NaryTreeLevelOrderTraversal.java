import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _429NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()){
            resultList.add(new ArrayList<>());
            int size = queue.size();
            while (size-- > 0){
                Node node = queue.poll();
                resultList.get(level).add(node.val);
                if (node.children != null){
                    queue.addAll(node.children);
                }
            }
            level++;
        }
        return resultList;
    }
}
