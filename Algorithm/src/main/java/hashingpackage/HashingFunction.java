package hashingpackage;

public class HashingFunction {
	public MyList[] arrayNodeList=new MyList[2];
	
	public MyTree[] arrayNodeTree=new MyTree[2];
	
	// add một phần tử tới bảng /Phuong phap danh sach lien ket
	public void putToChaining(ObjectNode objectNode) {
		ObjectNodeList objectNodeList=converToList(objectNode);
		long index = objectNodeList.index;
		int count = indexFor(index, arrayNodeList.length);
		if(arrayNodeList[count]==null)
		{
			arrayNodeList[count] = new MyList();
		}
		arrayNodeList[count].add(objectNodeList);
	}
	
	// add một phần tử tới bảng /Phuong phap danh cây
	public void putToTree(ObjectNode objectNode)
	{
		ObjectNodeTree objectNodeTree=converToTree(objectNode);
		long index = objectNodeTree.index;
		int count = indexFor(index, arrayNodeTree.length);
		if(arrayNodeTree[count]==null)
		{
			arrayNodeTree[count] = new MyTree();
		}
		arrayNodeTree[count].add(objectNodeTree);
	}
	//add một phần tử tới bảng /Phuong phap dò tuyến tính/
	public void putToOpenAddress(ObjectNode objectNode) {
		ObjectNodeList objectNodeList=converToList(objectNode);
		long index = objectNodeList.index;
		int count = indexFor(index, arrayNodeList.length);
		int checkOut;
		int lenght = arrayNodeList.length;
		// Khoi tao
		if(arrayNodeList[count]==null)
		{
			arrayNodeList[count] = new MyList();
		}
		// Kiểm tra null
		checkOut = count;
		while (arrayNodeList[count].root != null) {
			count++;
			if (checkOut == count) {
				System.out.println("Hash table full!");
				return;
			}
			if (count == lenght)
				count = 0;
		}
		arrayNodeList[count].add(objectNodeList);
	}

	// Tim kiem theo phuong phap List
	public ObjectNode searchList(long x) {
		return converToObject(arrayNodeList[indexFor(x, arrayNodeList.length)].SearchValue(x));
	}
	
	// Tim kiem theo phuong phap Tree
	public ObjectNode searchTree(long x) {
		return converToObject(arrayNodeTree[indexFor(x, arrayNodeList.length)].SearchValue(x));
	}
	// Tim kiem theo phuong phap Open Address
	public ObjectNodeList searchOpenAddress(long x) {
		int count = indexFor(x, arrayNodeList.length);
		int checkOut;
		int lenght = arrayNodeList.length;
		checkOut = count;
		while (arrayNodeList[count].SearchValue(x) == null) {
			count++;
			if (checkOut == count)
				return null;
			if (count == lenght - 1)
				count = 0;
		}
		return arrayNodeList[count].SearchValue(x);
	}
	
	// Ham Hashing
	public int indexFor(long x, int length) {
		// x=hash(x);
		return (int) (x % length);
	}
	
	// Tao du lieu tu nhien
	public int hash(int x) {
		x ^= (x >>> 20) ^ (x >>> 12);
		return x ^ (x >>> 7) ^ (x >>> 4);
	}
	
	// Conver to List
	public ObjectNodeList converToList(ObjectNode objectNode)
	{
		ObjectNodeList objectNodeList =new ObjectNodeList();
		objectNodeList.classCode=objectNode.classCode;
		objectNodeList.className=objectNode.className;
		objectNodeList.department=objectNode.department;
		objectNodeList.index=objectNode.index;
		objectNodeList.instructorName=objectNode.instructorName;
		objectNodeList.name=objectNode.name;
		objectNodeList.numberPhone=objectNode.numberPhone;
		return objectNodeList;
	}
	
	// Conver to Tree
	public ObjectNodeTree converToTree(ObjectNode objectNode)
	{
		ObjectNodeTree objectNodeTree =new ObjectNodeTree();
		objectNodeTree.classCode=objectNode.classCode;
		objectNodeTree.className=objectNode.className;
		objectNodeTree.department=objectNode.department;
		objectNodeTree.index=objectNode.index;
		objectNodeTree.instructorName=objectNode.instructorName;
		objectNodeTree.name=objectNode.name;
		objectNodeTree.numberPhone=objectNode.numberPhone;
		return objectNodeTree;
	}
	
	public ObjectNode converToObject(ObjectNodeList objectNodeList)
	{
		if(objectNodeList==null)
			return null;
		ObjectNode objectNode =new ObjectNode();
		objectNode.classCode=objectNodeList.classCode;
		objectNode.className=objectNodeList.className;
		objectNode.department=objectNodeList.department;
		objectNode.index=objectNodeList.index;
		objectNode.instructorName=objectNodeList.instructorName;
		objectNode.name=objectNodeList.name;
		objectNode.numberPhone=objectNodeList.numberPhone;
		return objectNode;
	}
	
	public ObjectNode converToObject(ObjectNodeTree objectNodeTree)
	{
		if(objectNodeTree==null)
			return null;
		ObjectNode objectNode =new ObjectNode();
		objectNode.classCode=objectNodeTree.classCode;
		objectNode.className=objectNodeTree.className;
		objectNode.department=objectNodeTree.department;
		objectNode.index=objectNodeTree.index;
		objectNode.instructorName=objectNodeTree.instructorName;
		objectNode.name=objectNodeTree.name;
		objectNode.numberPhone=objectNodeTree.numberPhone;
		return objectNode;
	}
}
