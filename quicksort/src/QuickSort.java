public class QuickSort{
    public static void show(Comparable[] a) {
       for (int i = 0; i < a.length; i++)
           System.out.print(a[i]+" ");
       System.out.println(" ");
    }
	
	public static boolean isSorted(Integer[] a) {
       for (int i = 0; i < a.length-1; i++){
			if(a[i]>a[i+1]) return false;
	   }
        return true;
    }
	
	public static void sort(Integer[] a){
		quick_sort(a,0,a.length-1);
	}
	private static void quick_sort(Integer[] a, int p, int r){
		if(p < r){
			int q = partition(a,p,r);
			quick_sort(a,p,q-1);
			quick_sort(a,q+1,r);
		}
	}
	private static int partition(Integer[] a, int p, int r){
		int x = a[r];
		int i = p-1;
		int temp;
		for(int j = p; j<=r-1;j++){
			if(a[j]<=x){
				i++;
				temp = a[j];
				a[j] = a[i];
				a[i] = temp;
			}
		}
		temp = a[i+1];
		a[i+1] = a[r];
		a[r] = temp;
		return i+1;
	}
/*	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);
		long start = System.currentTimeMillis();
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
           a[i] = (int) (Math.random()*1000);
        long stop = System.currentTimeMillis();
        double elapsed = (stop - start) / 1000.0;
   System.out.println("------------------------------------------------");
       System.out.println("Generating input:  " + elapsed + " seconds");
   System.out.println("------------------------------------------------");
   //show(a);

      start = System.currentTimeMillis();
       sort(a);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;

       System.out.println("Sort: " + elapsed + " seconds");
       System.out.println(isSorted(a));
       //show(a);
   System.out.println("------------------------------------------------");
		
	}*/
}