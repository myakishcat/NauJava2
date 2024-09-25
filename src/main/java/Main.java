public class Main {
    public static void main(String[] args) {
        /*ArrayTask.startTask(Integer.parseInt(args[0]));
        ListTask.startTask(Integer.parseInt(args[1]));*/

        ArrayTask.startTask(4);
        ListTask.startTask(6);
        StreamAPITask.startTask();
        HTTPTask.startTask();

        FinalTask task = new FinalTask("https://pic.rutubelist.ru/video/55/3b/553ba14bba9810cdf47252f651620686.jpg", "local_file.jpg");
        task.start();
    }
}
