package gfg;

//https://www.geeksforgeeks.org/problems/binary-tree-to-dll/1

/* class Node
class Node
{
	Node left, right;
	int data;

	Node(int d)
	{
		data = d;
		left = right = null;
	}

}*/
class NodePair {
    Node head;
    Node tail;

    NodePair(Node head, Node tail) {
        this.head = head;
        this.tail = tail;
    }
}

public class BinaryTreeToDoublyLinkedList {
    Node bToDLL(Node root) {
        return convertBinaryTreeToDoublyLinkedList(root).head;
    }

    NodePair convertBinaryTreeToDoublyLinkedList(Node root) {
        if (root == null) {
            return new NodePair(null, null);
        }
        NodePair leftSubTree = convertBinaryTreeToDoublyLinkedList(root.left);
        NodePair rightSubTree = convertBinaryTreeToDoublyLinkedList(root.right);

        Node linkedListHead = root;
        Node linkedListTail = root;

        root.left = leftSubTree.tail;
        if (leftSubTree.tail != null) {
            leftSubTree.tail.right = linkedListHead;
            linkedListHead = leftSubTree.head;
        }

        root.right = rightSubTree.head;
        if (rightSubTree.head != null) {
            rightSubTree.head.left = root;
            linkedListTail = rightSubTree.tail;
        }
        return new NodePair(linkedListHead, linkedListTail);
    }

}
