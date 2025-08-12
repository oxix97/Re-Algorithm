package programmers.kit.hash;

import java.util.*;

class 길찾기게임 {
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];

            nodes.add(new Node(i + 1, y, x));
        }

        Collections.sort(nodes);

        Btree tree = new Btree();
        for (Node node : nodes) {
            tree.add(node);
        }

        int[][] answer = new int[2][nodeinfo.length];
        List<Integer> preOrder = tree.getPreOrder();
        List<Integer> postOrder = tree.getPostOrder();

        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = preOrder.get(i);
        }

        for (int i = 0; i < nodeinfo.length; i++) {
            answer[1][i] = postOrder.get(i);
        }

        return answer;
    }

    class Btree {
        Node root;

        public void add(Node node) {
            root = addRecursive(root, node);
        }

        private Node addRecursive(Node current, Node node) {
            if (current == null) {
                return node;
            }

            if (current.x > node.x) {
                current.left = addRecursive(current.left, node);
            } else {
                current.right = addRecursive(current.right, node);
            }

            return current;
        }

        public List<Integer> getPreOrder() {
            List<Integer> result = new ArrayList<>();
            preOrderRecursive(root, result);
            return result;
        }

        private void preOrderRecursive(Node current, List<Integer> result) {
            if (current != null) {
                result.add(current.idx);
                preOrderRecursive(current.left, result);
                preOrderRecursive(current.right, result);
            }
        }

        public List<Integer> getPostOrder() {
            List<Integer> result = new ArrayList<>();
            postOrderRecursive(root, result);
            return result;
        }

        private void postOrderRecursive(Node current, List<Integer> result) {
            if (current != null) {
                postOrderRecursive(current.left, result);
                postOrderRecursive(current.right, result);
                result.add(current.idx);
            }
        }
    }

    class Node implements Comparable<Node> {
        int idx;
        int y;
        int x;
        Node left;
        Node right;

        public Node(int idx, int y, int x) {
            this.idx = idx;
            this.y = y;
            this.x = x;
            left = null;
            right = null;
        }

        @Override
        public int compareTo(Node node) {
            if (this.y == node.y) {
                return this.x - node.x;
            }
            return node.y - this.y;
        }
    }
}