package hashingpackage;

public class MyTree {
	final int D_L=1;
	final int D_R=-1;
	final int D_L_L=1;
	final int D_R_R=2;
	final int D_L_R=3;
	final int D_R_L=4;
	// private ObjectNode current;
	public ObjectNodeTree root;

	/// add mot phan tu vao cuoi danh sach
	public void add(ObjectNodeTree item) {
		ObjectNodeTree nodeTmp = new ObjectNodeTree();
		nodeTmp = item;
		if (this.root == null) {
			this.root = nodeTmp;
			return;
		}
		
		ObjectNodeTree current = root;
		while (current != null)
			if (nodeTmp.index > current.index) {
				if (current.rightNext == null) {
					current.rightNext = nodeTmp;
					// Check AVl
					
					
					
					//
					return;
				} else {
					current = current.rightNext;
				}
			} else if (nodeTmp.index == current.index) {
				System.out.println("Key is duplication, don't add!");
				return;
			} else {
				if (current.letfNext == null) {
					current.letfNext = nodeTmp;
					// Check AVl
					//nếu độ cao của cây không thay đổi thì out

					
					
					//
					return;
				} else {
					current = current.letfNext;
				}
			}
	}

	// add mot phan tu co gia tri la value vao cuoi anh sach
	public void add(long index, Object classCode, Object name, Object className, Object department,
			Object instructorName, Object numberPhone) {
		// ObjectNodeList nodeTmp = new ObjectNodeList();
		// nodeTmp.index = index;
		// nodeTmp.classCode = classCode;
		// nodeTmp.className = className;
		// nodeTmp.name = name;
		// nodeTmp.department = department;
		// nodeTmp.instructorName = instructorName;
		// nodeTmp.numberPhone = numberPhone;
		// if (this.root == null) {
		// this.root = nodeTmp;
		// return;
		// }
		// ObjectNodeList current = this.root;
		// while (current.next != null)
		// current = current.next;
		// current.next = nodeTmp;
	}

	// Tim mot phan tu co gia tri x
	public ObjectNodeTree SearchValue(long index) {
		if (this.root == null) {
			return null;
		}
		ObjectNodeTree current = this.root;
		while (current != null) {
			if (current.index == index) {
				return current;
			} else if (index > current.index) {
				current = current.rightNext;
			} else {
				current = current.letfNext;
			}
		}
		return null;
	}

	// add mot phan tu vao dau danh sach
	public void addFirst(ObjectNodeList item) {
	}

	// add mot phan tu vao ngay sau phan tu co x=value
	public void addAfterValue(ObjectNodeList item, long index) {
	}

	// remove mot phan tu dau tien co gia tri la x=value
	public void remove(long index) {

	}

	// remove mot phan tu dau tien co tri tri x=item.x
	public void remove(ObjectNodeList item) {
	}

	// remove phan tu dau tien
	public void removeFirst() {
	}

	// remove phan tu cuoi cung
	public void removeLast() {
	}

	// show all cac phan tu
	public void show() {
	}

	// Height Tree
	public int heightTree(ObjectNodeTree tree) {
		if (tree == null)
			return 0;
		else {
			return Math.max(heightTree(tree.letfNext), heightTree(tree.rightNext)) + 1;
		}
	}

	// Check AVL
	public int checkAVL(ObjectNodeTree tree) {
		int avl = heightTree(tree.letfNext) - heightTree(tree.rightNext);
		if (avl > -2 && avl < 2)
			return 0;
		else if (avl <= -2)
			return D_R;
		else
			return D_L;
	}
	
	// Check AVL lệch L-L, L-R. R-R, R-L
	public int checkAVLRL(ObjectNodeTree tree)
	{
		if (checkAVL(tree) == D_L) {
			if (checkAVL(tree.letfNext) == D_L)
				return D_L_L;
			else
				return D_L_R;
		} else {
			if (checkAVL(tree.rightNext) == D_L)
				return D_R_L;
			else
				return D_R_R;
		}
	}
	
	// Find node root
	public ObjectNodeTree findRoot(ObjectNodeTree tree, ObjectNodeTree p) {
		if (tree == null)
			return null;
		else {
			if (p == null)
				return null;
			else {
				if(tree.letfNext!=null)
					return findRoot(tree.letfNext, p);
				if(tree.letfNext==p||tree.rightNext==p)
					return tree;
				if(tree.rightNext!=null)
					return findRoot(tree.rightNext, p);
				return null;
			}
		}
	}
}
