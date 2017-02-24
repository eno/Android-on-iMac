public class AllSorts {

    public static void show(Comparable[] a) {
       for (int i = 0; i < a.length; i++)
           System.out.print(a[i]+" ");
       System.out.println(" ");
    }

    // test client
    public static void main(String[] args) {
       int N = Integer.parseInt(args[0]);

       // generate N random real numbers between 0 and 1
       long start = System.currentTimeMillis();
       Integer[] a = new Integer[N];
       for (int i = 0; i < N; i++)
           a[i] = (int) (Math.random()*1000);
       long stop = System.currentTimeMillis();
       double elapsed = (stop - start) / 1000.0;
   System.out.println("------------------------------------------------");
       System.out.println("Generating input:  " + elapsed + " seconds");
   System.out.println("------------------------------------------------");
   show(a);

       // Merge sort them
     /*  start = System.currentTimeMillis();
       MergeSort.sort(a);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;

       System.out.println("Mergesort: " + elapsed + " seconds");
       System.out.println(MergeSort.isSorted(a));
       MergeSort.show(a);*/
   System.out.println("------------------------------------------------");

       // generating another a[]
       start = System.currentTimeMillis();
       a = new Integer[N];
       for (int i = 0; i < N; i++)
           a[i] = (int) (Math.random()*1000);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;
       System.out.println("Generating input:  " + elapsed + " seconds");
   System.out.println("------------------------------------------------");
   show(a);
   System.out.println("------------------------------------------------");

       // Quick sort them
       /*start = System.currentTimeMillis();
       QuickSort.sort(a);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;

       System.out.println("Quicksort: " + elapsed + " seconds");
       System.out.println(QuickSort.isSorted(a));
   System.out.println("------------------------------------------------");*/

       // generating another a[]
       start = System.currentTimeMillis();
       a = new Integer[N];
       for (int i = 0; i < N; i++)
           a[i] = (int) (Math.random()*1000);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;
       System.out.println("Generating input:  " + elapsed + " seconds");
   System.out.println("------------------------------------------------");
   show(a);
   System.out.println("------------------------------------------------");

       // ins sort them
       start = System.currentTimeMillis();
       InsertionSort.sort(a);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;

       System.out.println("Insertion sort: " + elapsed + " seconds");
       System.out.println(InsertionSort.isSorted(a));
   System.out.println("------------------------insertionSorted------------------------");
   show(a);
   System.out.println("-----------------------insertionSorted-------------------------");

       // generating another a[]
       start = System.currentTimeMillis();
       a = new Integer[N];
       for (int i = 0; i < N; i++)
           a[i] = (int) (Math.random()*1000);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;
       System.out.println("Generating input:  " + elapsed + " seconds");
   System.out.println("------------------------------------------------");
   show(a);
   System.out.println("------------------------------------------------");

       // sel sort them
       start = System.currentTimeMillis();
       SelectionSort.sort(a);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;

       System.out.println("Selection sort: " + elapsed + " seconds");
       System.out.println(SelectionSort.isSorted(a));
   System.out.println("-----------------------selectionSorted-------------------------");
   show(a);
   System.out.println("------------------------selectionSorted------------------------");

       // generating another a[]
       start = System.currentTimeMillis();
       a = new Integer[N];
       for (int i = 0; i < N; i++)
           a[i] = (int) (Math.random()*1000);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;
       System.out.println("Generating input:  " + elapsed + " seconds");
   System.out.println("------------------------------------------------");
   show(a);
   System.out.println("------------------------------------------------");

       // Quick sort them
       start = System.currentTimeMillis();
       QuickSort.sort(a);
       stop = System.currentTimeMillis();
       elapsed = (stop - start) / 1000.0;

       System.out.println("Quick sort: " + elapsed + " seconds");
       System.out.println(QuickSort.isSorted(a));
   System.out.println("-----------------Quicksorted-------------------------------");
   show(a);
   System.out.println("----------------------Quicksorted--------------------------");
    }
}
