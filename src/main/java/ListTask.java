import java.util.ArrayList;

public class ListTask {
    static final long INF = 100;
    public static void startTask(int capacity) {
        System.out.println("--List Task--");
        ArrayList<Double> list = new ArrayList<>(capacity);

        System.out.println("Исходный список:");
        for(int i = 0; i < capacity; i++){
            Double value = Math.random()*INF - Math.random()*INF;
            list.add(value);
            System.out.print(value + "   ");
        }

        quickSort(list, 0, capacity - 1);
        System.out.println();
        System.out.println("Отсортированный список:");
        for(int i = 0; i < capacity; i++){
            System.out.print(list.get(i) + "   ");
        }
        System.out.println("\n");
    }

    public static ArrayList<Double> quickSort
            (ArrayList<Double> list, int leftIdx, int rightIdx){
        if(leftIdx == rightIdx){
            return list;
        }

        int endIdx = rightIdx;
        int startIdx = leftIdx;
        double pivot = list.get((leftIdx+rightIdx) / 2);
        while(leftIdx <= rightIdx){
            while(list.get(leftIdx) < pivot){
                leftIdx++;
            }
            while(list.get(rightIdx) > pivot){
                rightIdx--;
            }

            if(leftIdx <= rightIdx){
                double temp = list.get(leftIdx);
                list.set(leftIdx, list.get(rightIdx));
                list.set(rightIdx, temp);
                leftIdx = Math.min(endIdx, ++leftIdx);
                rightIdx = Math.max(startIdx, --rightIdx);
            }
        }
        quickSort(list, startIdx, rightIdx);
        quickSort(list, leftIdx, endIdx);
        return list;
    }
}