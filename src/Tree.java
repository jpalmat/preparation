
public class Tree {

	private Node root;

	public Tree() {
		root = null;
	}

	public boolean insert(Integer item) {
		Node n = new Node();

		n.data = item;

		n.lc = null;

		n.rc = null;
		if (root == null) {
			root = n;
			return true;

		}

		Node p = root;
		Node c = root;
		while (c != null) {
			p = c;
			if (item < c.data) {
				c = c.lc;
			} else {
				c = c.rc;
			}
		}

		if (item < p.data) {
			p.lc = n;
		} else {
			p.rc = n;
		}

		return true;

	}

	public void showAll(Node n) {
		Node p = n;
		if (p != null) {
			System.out.print(" " + p.data);
			showAll(p.lc);
			showAll(p.rc);
		}

	}

	public Node findNode(Integer key) {

		Node c = root;
		while (c != null) {
			if (key == c.data) {
				break;
			} else if (key < c.data) {
				c = c.lc;
			} else {
				c = c.rc;
			}
		}
		return c;
	}

	public Node findParent(Integer key) {
		Node p = root;
		Node c = root;
		do {

			if (key == c.data) {
				break;

			}
			p = c;
			if (key < c.data) {
				c = c.lc;
			} else {
				c = c.rc;

			}

		} while (c != null);
		System.out.println(">>" + p.data);
		if (c != null) {
			return p;
		} else {
			return null;

		}
	}

	public Integer getData(Node c) {
		return c.data;
	}

	public class Node {
		private Node lc;
		private Integer data;
		private Node rc;
	}
}
