import java.util.Scanner;

public class QuickSorting{

	static int partition(int a[],int low,int high){
		int pivot = high;
		int i = low-1;
		for(int j=low;j<=high;j++){
			if(a[j]<a[pivot]){
				i++;
				int temp = a[i];
				a[i]=a[j];
				a[j]=temp;
			}	
		}
		int temp=a[i+1];
		a[i+1]=a[pivot];
		a[pivot]=temp;
		return i+1;
	}

	static void quickSort(int a[],int low, int high){
		if(low<high){
			int pivot = partition(a,low,high);
			quickSort(a,low,pivot-1);
			quickSort(a,pivot+1,high);
		}
	}


	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n=s.nextInt();
		int[] a = new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		s.close();

		quickSort(a,0,n-1);

		System.out.println("Sorted Array:");
		for(int i=0;i<n;i++)
		{
			System.out.println(a[i]);
		}

	}
}

