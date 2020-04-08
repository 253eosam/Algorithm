import java.util.Arrays;

public class HeepTest {

	public static void main(String[] args) {
		MaxHeapTree heap = new MaxHeapTree();
		heap.insert(3);
		heap.insert(1);
		heap.insert(5);
		heap.insert(4);
		heap.delete();
		heap.delete();
		heap.delete();
		heap.print();
	}
	
	static class MaxHeapTree
	{
		int[] datas;
		int MAX_SIZE;
		int pointer;
		MaxHeapTree()
		{
			this(100);
		}
		MaxHeapTree(int maxSize)
		{
			MAX_SIZE = maxSize;
			datas = new int[MAX_SIZE + 1];
			pointer = 0;
		}
		public int delete()
		{
			if(isEmpty()) return -1;
			int result = datas[1];
			datas[1] = datas[pointer];
			datas[pointer] = 0;
			pointer--;
			heapify();
			return result;
			
		}
		private void heapify()
		{
			int index = 1;
			while(true)
			{
				if(datas[index] >= datas[index*2] && datas[index] >= datas[index*2 + 1])
				{
					break;
				}
				else
				{
					if(datas[index] < datas[index*2])
					{
						swap(index, index * 2);
						index = index  * 2;
					}
					else
					{
						swap(index,index * 2 + 1);
						index = index * 2 + 1;
					}
				}
			}
		}
		public void print()
		{
			System.out.println(Arrays.toString(datas));
		}
		public boolean isEmpty()
		{
			return pointer == 0;
		}
		public boolean isFull()
		{
			return MAX_SIZE == pointer;
		}
		public void insert(int data)
		{
			if(isFull()) {
				System.out.println("overflow");
			}
			else
			{
				datas[++pointer] = data;
				int idx = pointer;
				while(idx > 1 && datas[idx] > datas[idx/2])
				{
					swap(idx, idx/2);
					idx /= 2;
				}
			}
		}
		
		public void swap(int i , int j)
		{
			int tmp = datas[i];
			datas[i] = datas[j];
			datas[j] = tmp;
		}
	}

}
