package Views;

/**
 * Created by yuki_yanagi on 2014/04/22.
 */

/**
 * Because this class is stateless, all methods declared as static.
 */
public class Front {
    public static void showInformation(){
        System.out.println(
                "====================================================\n" +
                "================タイピングゲームです================\n" +
                "本ツールは、日本語入力が基本となっています。\n" +
                "日本語入力になっているか確認してください。\n" +
                "====================================================\n"
                );
    }

    public static void waitStart(){
        System.out.println(
                "¥n↓↓↓↓↓選択してください↓↓↓↓↓¥n\n" +
                "イ：スタート\n" +
                "ロ：終了\n"
        );
    }

    public static void showStartMsg(){
        System.out.println("タイピング練習を開始します。[Enter]キーを押下してください。");
    }

    public static void showIntroduction(){
        System.out.println(
                "表示された文章と全く同じ語句を入力すること。（全５問）\n" +
                "※[ギブアップ]　が入力された場合、ギブアップとなります。"
        );
    }
   public static void showQuestion(int index, String question){
        System.out.println("【第" + index + "問】");
        System.out.println(question);
    }

    public static void exit(long startTimeMill, long stopTimeMill){
        int min = (int)((int)((stopTimeMill - startTimeMill)/1000) / 60 );
        int sec = (int)((stopTimeMill - startTimeMill)/1000) % 60 ;

        System.out.printf("お疲れ様でした。あなたのスコアは【%d分 %d秒】です。\n", min, sec);
        System.out.println("タイトルへ戻ります。[Enter]を押下して下さい。");
    }

    public static void quit(){
        System.out.println("終了します。");
    }
}
