public class ArrayTask {
    static final long INF = 10000;
    public static void startTask(int capacity) {
        System.out.println("--Array Task--");
        int[] arr = new int[capacity];
        for(int i = 0; i < capacity; i++){
            arr[i] = (int) (Math.random()*INF - Math.random()*INF);
        }

        int minValue = Math.abs(arr[0]);
        System.out.println("Исходный массив:");
        for (int i = 0; i < capacity; i++){
            System.out.print(arr[i] + "   ");

            if(Math.abs(arr[i]) < minValue){
                minValue = Math.abs(arr[i]);
            }
        }
        System.out.println();
        System.out.println("Min abs value: " + minValue);
        System.out.println();
    }

}
