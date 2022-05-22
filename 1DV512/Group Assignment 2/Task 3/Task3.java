import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Task3 {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss-SS");

    public static void main(String[] args) throws IOException, InterruptedException {
        //create directory
        File dir = new File("/home/mehmetcbk/test+dir");
        System.out.println("directory created: " + dir.mkdir());
        //create file
        for (int i = 0; i < 500; i++) {
            //file name in format hour-minute-second-ms.txt
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String time = sdf.format(timestamp);
            File file = new File("/home/mehmetcbk/test+dir/" + time + ".txt");
            System.out.println("file " + i + " created:" + file.createNewFile());
            FileWriter fw = new FileWriter(file);
            //write time in hour-minute-second-ms format in this file 10000 times
            for (int j = 0; j < 10000; j++) {
                timestamp = new Timestamp(System.currentTimeMillis());
                time = sdf.format(timestamp);
                fw.write(time + "\n");
                System.out.println("file: " + i + " line: " + j);
            }
            fw.close();
            //delete the content of the created file and close
            /*fw=new FileWriter(file,false);
            fw.write("");
            fw.close();
            System.out.println("file "+i+" content deleted");*/
            Thread.sleep(10);
        }
    }

}
