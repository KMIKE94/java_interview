package google;

public class BST {
    class BinaryTreeNode {
        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode((rightValue));
            return this.right;
        }
    }

    public static void main(String... args) {
        int[] arr = {3,2,4,5,4,3,2,9,4,6,2,3};

        for(int elem:arr) {

        }
    }
}
