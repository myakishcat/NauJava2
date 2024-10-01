import tasks.*;
import tasks.Final.FinalTask;
import tasks.StreamApi.StreamAPITask;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите параметр для ArrayTask: ");
        int val1 = scanner.nextInt();
        System.out.println("Введите параметр для ListTask: ");
        int val2 = scanner.nextInt();

        ArrayTask.startTask(val1);
        ListTask.startTask(val2);
        StreamAPITask.startTask();
        HTTPTask.startTask();

        FinalTask task = new FinalTask("https://pic.rutubelist.ru/video/55/3b/553ba14bba9810cdf47252f651620686.jpg", "local_file.jpg");
        System.out.println("--Final Task--");
        task.start();
        task.stop();

        task.start();
    }
}
