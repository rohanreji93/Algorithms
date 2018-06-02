import java.util.Scanner;
public class RadixSorting {
    static int getMax(int a[]){
        int max = a[0];
        for(int i=1;i<a.length;i++){
            if(max < a[i]){
                max = a[i];
            }
        }
        return max;
    }
    static void radixSort(int a[], int exp){
        int[] count=new int[10];
        int pos;
        int size = a.length;
        int[] helper = new int[size];
        for(int i=0;i<size;i++){
            count[(a[i]/exp)%(10)]++;
        }
        
        for(int i=1;i<10;i++){
            count[i]=count[i]+count[i-1];
        }
       
        for(int i=size-1; i>=0; i--){
            pos=(a[i]/exp)%(10);
            helper[count[pos]-1]=a[i];
            count[pos]--;
        }
        for(int i=0;i<size;i++){
            a[i]=helper[i];
        }
    }
    static void radix(int a[]){
        int max = getMax(a);
        int exp=1;
        while(max/exp>0){
            //sort based on exp th bit.
            radixSort(a, exp);
            exp=exp*10;
        }
        
    }
    public static void main(String args[]) {
        int n,a[];
        Scanner s = new Scanner(System.in);
        //get elements
        System.out.println("Enter number of elements");
        n=s.nextInt();
        a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=s.nextInt();
        }
        s.close();
        //call radix - which will do sorting based on each digit.
        radix(a);
        //display sorted array
        System.out.println("The Sorted Array");
        for(int i=0;i<n;i++){
            System.out.println(a[i]);
        }
    }
}
