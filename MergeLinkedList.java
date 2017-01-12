/**
* Problem 1A
*/


public class MergeLinkedList<E extends Comparable<E>> {
Node<E> head;

	/**
	* merges two sorted linked lists and returns node of the merged list
	*/

        private Node<E> merge(Node<E> node1, Node<E> node2) {
		Node<E> merged = null; // pointer for merged list
		Node<E> resp = null; // head of merged list

            if (node1 == null)
				return node2;
            if (node2 == null)
				return node1;

            int cmp = 0;
				while (node1 != null && node2 != null) {
					cmp = node1.compareTo(node2);
				if (merged == null) {
					if (cmp < 0) {
						merged = node1;
						node1 = node1.next;
                        
					} else {
                        merged = node2;
						node2 = node2.next;
                        }
                        
                        resp = merged; // points to head of merged list
                        
                        } else {
                        
                        if (cmp < 0) {
							merged.next = node1;
							node1 = node1.next;
							merged = merged.next;

                        } else {
							merged.next = node2;
							node2 = node2.next;
							merged = merged.next;
                        
                        }
                }
        }

        /**
        * append the remaining nodes of the either list
        */
            
            if (node1 == null)
				merged.next = node2;

                else
					merged.next = node1;

            return resp;
            
        }

/**
* Node implementation which forms linked list
*/
    
        private static class Node<E extends Comparable<E>> implements Comparable<Node<E>> {
		E data;
		Node<E> next;

            public Node(E data, Node<E> next) {
				super();
				this.data = data;
				this.next = next;
            }


            public String toString() {
				return "Node [data=" + data + "]";
            }


            public int compareTo(Node<E> node) {
				return this.data.compareTo(node.data);
            }
        }

        public void addNodeLast(E d) {
			if (head == null) {
			head = new Node<E>(d, null);
			return;
            }
            Node<E> h = head;
            while (h.next != null)
				h = h.next;
            h.next = new Node<E>(d, null);
        }

        public void print() {
            Node<E> h = head;
            while (h != null) {
				System.out.print(h.data + " -->");
				h = h.next;
            }
            
            System.out.println("null");
        }

        public void print(Node<E> head) {
            Node<E> h = head;
            while (h != null) {
				System.out.print(h.data + " -->");
				h = h.next;
            }
            
			System.out.println("null");
        }

    /**
* Main method for testing
*/
    
        public static void main(String[] args) {
/**
* First linked list
*/
        
	MergeLinkedList<Integer> l1 = new MergeLinkedList<>();
		l1.addNodeLast(9);
		l1.addNodeLast(17);
		l1.addNodeLast(21);
		l1.addNodeLast(29);
		l1.addNodeLast(82);
		l1.addNodeLast(83);
		l1.addNodeLast(88);
		System.out.print("First Linked List :");
		l1.print(l1.head);

/**
* Second linked list
*/
            
	MergeLinkedList<Integer> l2 = new MergeLinkedList<>();
		l2.addNodeLast(32);
		l2.addNodeLast(39);
		l2.addNodeLast(42);
		l2.addNodeLast(55);
		l2.addNodeLast(72);
		l2.addNodeLast(93);
		l2.addNodeLast(99);
		System.out.print("Second Linked List :");
		l2.print(l2.head);

/**
* Final, merged linked list
*/
			MergeLinkedList<Integer> mergedList = new MergeLinkedList<>();
			mergedList.head = mergedList.merge(l1.head, l2.head);
			System.out.print("Merged Linked List :");
			mergedList.print(mergedList.head);
        }
}
