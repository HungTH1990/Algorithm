package hashingpackage;

public class MyList {
	// private ObjectNode current;
	public ObjectNodeList root;

	/// add mot phan tu vao cuoi danh sach
	public void add(ObjectNodeList item) {
		if(item.index==20122838)
		{
			item.index=20122838;
		}
		ObjectNodeList nodeTmp = new ObjectNodeList();
		nodeTmp = item;
		if (this.root == null) {
			this.root = nodeTmp;
			return;
		}
		ObjectNodeList current = this.root;
		while (current.next != null)
			current = current.next;
		current.next = nodeTmp;
	}

	// add mot phan tu co gia tri la value vao cuoi anh sach
	public void add(long index, Object classCode, Object name, Object className, Object department, Object instructorName, Object numberPhone) {
		ObjectNodeList nodeTmp = new ObjectNodeList();
		nodeTmp.index = index;
		nodeTmp.classCode = classCode;
		nodeTmp.className = className;
		nodeTmp.name = name;
		nodeTmp.department = department;
		nodeTmp.instructorName = instructorName;
		nodeTmp.numberPhone = numberPhone;
		if (this.root == null) {
			this.root = nodeTmp;
			return;
		}
		ObjectNodeList current = this.root;
		while (current.next != null)
			current = current.next;
		current.next = nodeTmp;
	}

	// Tim mot phan tu co gia tri x
	public ObjectNodeList SearchValue(long index) {
		if(this.root==null)
		{
			return null;
		}
		ObjectNodeList current = this.root;
		if (current.index == index)
			return current;
		do {
			if (current.next != null)
				current = current.next;
			if (current.index == index)
				return current;
		} while (current.next != null);
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
}
