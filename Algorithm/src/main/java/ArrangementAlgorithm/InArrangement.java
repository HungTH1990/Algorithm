package ArrangementAlgorithm;

import java.util.Random;

public class InArrangement {
	public static void main(String[] args) {
		long star, end;
		Double[] a = new Double[10];
		Random rd = new Random();
		for (int i = 0; i < 10; i++) {
			a[i] = (double) rd.nextInt(40);
		}
		star = System.currentTimeMillis();
		a = QuickSort(a);
		end = System.currentTimeMillis();
		System.out.println("thời gian là" + (end - star));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i].toString() + " ");
		}

		star = System.currentTimeMillis();
		a = InterSort(a);
		end = System.currentTimeMillis();
		System.out.println("\r\n thời gian là" + (end - star));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i].toString() + " ");
		}

		star = System.currentTimeMillis();
		a = BubbleSort(a);
		end = System.currentTimeMillis();
		System.out.println("\r\n thời gian là" + (end - star));
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i].toString() + " ");
		}
	}

	/* Sắp xếp 3 phần tử */
	public static Double[] ThreeSort(Double a[]) {
		if (a.length > 3)
			return a;
		Double t;
		if (a[0] > a[1]) {
			t = a[0];
			a[0] = a[1];
			a[1] = t;
		}
		if (a[0] > a[2]) {
			t = a[0];
			a[0] = a[2];
			a[2] = t;
		}
		if (a[1] > a[2]) {
			t = a[1];
			a[1] = a[2];
			a[2] = t;
		}
		return a;
	}
	 /* Sắp xếp 4 phần tử */
	public static Double[] FourSort(Double a[]) {
		Double t;
		if(a[0]>a[1]){
			t=a[0]; a[0]=a[1];a[1]=t;
			if(a[0]>a[2]){
				t=a[0]; a[0]=a[2];a[2]=t;
			}
			if(a[0]>a[3]){
				t=a[0]; a[0]=a[3];a[3]=t;
			}
		}
		if(a[1]>a[2]){
			t=a[1]; a[1]=a[2];a[2]=t;
			if(a[1]>a[3]){
				t=a[1]; a[1]=a[3];a[3]=t;
			}
		}
		if(a[2]>a[3]){
			t=a[2]; a[2]=a[3];a[3]=t;
		}
		return a;
	}
	 /* Sắp xếp chọn */
	public static Double[] SelectSort(Double a[]) {
		Double t;
		int count = a.length;
		int min = 0;
		for (int i = 0; i < count; i++) {
			min = i;
			for (int j = i + 1; j < count; j++) {
				if (a[min] > a[j]) {
					t = a[min];
					a[min] = a[j];
					a[j] = t;
				}
			}
		}
		return a;
	}

	/* Sắp xếp chèn */
	public static Double[] InterSort(Double a[]) {
		Double t;
		int count = a.length;
		for (int i = 1; i < count; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
		return a;
	}

	/* Sắp xếp nổi bọt */
	public static Double[] BubbleSort(Double a[]) {
		Double t;
		int count = a.length;
		for (int i = 0; i < count; i++) {
			for (int j = 1; j < count - i; j++) {
				if (a[j - 1] > a[j]) {
					t = a[j - 1];
					a[j - 1] = a[j];
					a[j] = t;
				}
			}
		}
		return a;
	}
	
	/* Sắp xếp nhanh */
	public static Double[] QuickSort(Double a[])
	{
		int count=a.length,i=0;
		Double t;

			for(int j=i;j<count-1;j++)
			{
				if(a[count-1]>a[j])
				{
					t=a[j];a[j]=a[i];a[i]=t;
					i++;
				}
				else
				{
					continue;
				}
			}
			t=a[i];a[i]=a[count-1];a[count-1]=t;
		return a;
	}

}
