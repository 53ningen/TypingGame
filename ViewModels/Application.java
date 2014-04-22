package ViewModels;

import Core.Controller;
import Models.TypingData;
import Views.Front;
import Views.Reader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by yuki_yanagi on 2014/04/22.
 */
public class Application extends Controller{
    private final String TYPING_DATA_FILE_PATH = "/Users/yuki_yanagi/IdeaProjects/TypingGame/Resources/typingData.txt";
    private long startTimeMill;
    private long stopTimeMill;
    private ArrayList<String> data;

    public static void main(String[] args){
        Application app = new Application();
        app.run();
        System.exit(0);
    }

    @Override
    protected String action(String path) {
        if(path==null)
            return null;

        switch(path){
            case "":
                startTimeMill = System.currentTimeMillis();
                Front.showInformation();
                return "readFile";

            case "readFile":
                try {
                    data = TypingData.getTypingDataOf(TYPING_DATA_FILE_PATH);
                }
                catch(FileNotFoundException e){
                    e.printStackTrace();
                    System.exit(1);
                }
                return "waitStart";

            case "waitStart":
                String returnVal = Reader.waitStart();
                if(returnVal.equals("イ"))
                    return "waitEnter";
                else
                    return "exit";

            case "waitEnter":
                Front.showStartMsg();
                Reader.waitEnter();
                return "gameStart";

            case "gameStart":
                Collections.shuffle(data);
                for(int i = 1; i <= 5; i++){
                    Front.showQuestion(i,data.get(i));
                    Reader.waitAnswer(data.get(i));
                }
                return "exit";

            case "exit":
                stopTimeMill = System.currentTimeMillis();
                Front.exit(startTimeMill, stopTimeMill);
        }
        return null;
    }
}
