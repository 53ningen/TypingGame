package Models;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;

/**
 * Created by yuki_yanagi on 2014/04/22.
 */
public class TypingData {
    private TypingData(){};

    public static ArrayList<String> getTypingDataOf(String filePath) throws FileNotFoundException{
        ArrayList<String> typingData = new ArrayList<String>();

        File file = new File(filePath);
        FileReader filereader;

        try {
            filereader = new FileReader(file);
        }
        catch(FileNotFoundException e){
            throw new FileNotFoundException();
        }
        BufferedReader reader = new BufferedReader(filereader);

        try{
            String str = reader.readLine();
            while(str != null){
                typingData.add(str);
                str = reader.readLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        finally {
            try {
                reader.close();
                filereader.close();
            }
            catch (IOException e){
                e.printStackTrace();
                System.exit(1);
            }
        }
        return typingData;
    }
}
