package tasks.Final;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
public class FinalTask implements Task {
    private final String fileUrl;
    private final String destinationPath;
    private volatile boolean running = false;
    private Thread downloadThread;

    public FinalTask(String fileUrl, String destinationPath) {
        this.fileUrl = fileUrl;
        this.destinationPath = destinationPath;
    }

    @Override
    public void start() {
        running = true;
        downloadThread = new Thread(() -> {
            System.out.println("download started");
            try (BufferedInputStream in =
                         new BufferedInputStream(new URL(fileUrl).openStream());
                 FileOutputStream fileOutputStream =
                         new FileOutputStream(destinationPath)) {

                byte dataBuffer[] = new byte[1024];
                int bytesRead;
                while (running && (bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                    fileOutputStream.write(dataBuffer, 0, bytesRead);
                    Thread.sleep(10);
                }
            } catch (IOException e) {
                System.err.println("Download error: " + e.getMessage());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
              running = false;
            }
        });

        downloadThread.start();
    }

    @Override
    public void stop() {
        running = false;
        if (downloadThread != null) {
            try{
                downloadThread.interrupt();
                try {
                    downloadThread.join(); // Ждем завершения потока
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Восстанавливаем прерывание
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("thread stopped");
    }
}
