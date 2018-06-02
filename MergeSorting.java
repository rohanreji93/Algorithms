import java.util.Scanner;
public class MergeSorting{
	private static int[] helper;	
	static void merge(int a[], int low, int middle, int high){
		int helperLeft = low;
		int helperRight = middle+1;
		for(int i=low;i<=high;i++){
			helper[i]=a[i];
		}
		int current = low;
		while(helperLeft <= middle && helperRight <=high){
			if(helper[helperLeft]<helper[helperRight]){
				a[current]= helper[helperLeft];
				current++;
				helperLeft++;
			}
			else{
				a[current]=helper[helperRight];
				current++;
				helperRight++;
			}
		}
		int remaining = middle - helperLeft + 1;
		for(int i=0;i<remaining;i++){
			a[current+i] = helper[helperLeft+i];
		}
	}

	static void mergeSort(int a[],int low, int high){
		if(low < high){
			int middle = (low+high)/2;
			mergeSort(a,low,middle);
			mergeSort(a,middle+1,high);
			merge(a,low,middle,high);
		}
	}
	
	public static void main(String args[]){
		Scanner s =new Scanner(System.in);
		System.out.println("Enter number of elements:");
		int n=s.nextInt();
		int[] a = new int[n];
		helper = new int[n];
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		s.close();

		mergeSort(a,0,n-1);

		System.out.println("Sorted Array:");
		for(int i=0;i<n;i++){
			System.out.println(a[i]);
		}
	}
}
