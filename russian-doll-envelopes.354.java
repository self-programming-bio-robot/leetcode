import java.util.LinkedList;
import java.util.List;

public class RussianDollEnvelopes354 {
    public static void main(String[] args) {
        int[][] inp = {{1,1},{1,1},{1,1},{1,1}}; 
        System.out.println(new Solution().maxEnvelopes(inp));
    }
}

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Node root = makeGraph(envelopes);

        return print(root, 0);
        //return 0;           
    }

    private int print(Node node, int deep) {
        //System.out.println(" ".repeat(deep) + node.w + ":" + node.h);
        int max = deep;
        for (int i = 0; i < node.nodes.size(); i++) {
            int d = print(node.nodes.get(i), deep+1);
            max = max < d ? d : max;
        }
        return max;
    }

    private Node makeGraph(int[][] envelopes) {
        Node root = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE);
        List<Node> leaves = new LinkedList<>();
        for (int i = 0; i < envelopes.length; i++) {
            Node nn = new Node(envelopes[i][0], envelopes[i][1]);

            for (int j = 0; j < root.nodes.size(); j++) {
                if (nn.w > root.nodes.get(j).w && nn.h > root.nodes.get(j).h) {
                    nn.nodes.add(root.nodes.get(j));
                }
                if (nn.w < root.nodes.get(j).w && nn.h < root.nodes.get(j).h) {
                    root.nodes.get(j).nodes.add(nn);
                }
            }
            root.nodes.add(nn);
        }

        return root;
    }

    static class Node {
        int w;
        int h;

        List<Node> nodes = new LinkedList<Node>();

        public Node(int w, int h) {
            this.w = w;
            this.h = h;
        }
    }
}
