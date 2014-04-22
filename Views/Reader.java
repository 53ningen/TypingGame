package Views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yuki_yanagi on 2014/04/22.
 */
public class Reader {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String waitStart(){
        while(true){
            try {
               String input = reader.readLine();
                if(input.equals("イ") || input.equals("ロ"))
                    return input;
                else
                    continue;
            }
            catch(IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
            break;
        }
        return null;
    }

    public static void waitEnter(){
         try {
            reader.readLine();
         }
         catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static String waitAnswer(String answer){
        while(true){
            try {
                String input = reader.readLine();
                if(input.equals(answer))
                    return input;
                else
                    continue;
            }
            catch(IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
            break;
        }
        return null;
    }
}
