public class InsertionSort{
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
		int i,key;
		for(int j=1;j<a.length;j++){
			key = a[j];
			i=j-1;
			while(i>=0&&a[i]>key){
				a[i+1]=a[i];
				i--;
			}
			a[i+1]=key;
		}
	}
	/*public static void main(String[] args) {
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
	
	}	*/
}