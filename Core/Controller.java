package Core;

/**
 * Created by yuki_yanagi on 2014/04/22.
 */
public abstract class Controller {
    /**
     * running application
     */
    public void run(){
        run("");
    }
    public void run(String actionPath){
        String path = actionPath;
        while(true){
            path = action(path);
            if(path == null)
                break;
            else
                continue;
        }
    }

    protected abstract String action(String path);
}
