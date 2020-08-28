import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.Arrays;

public class AlgoVisualizer {
//控制器
    // TODO: 创建自己的数据
    private int[] money;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        money = new int[100];
        for (int i = 0 ; i < money.length; i++)
            money[i] = 100;


        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Money Problem", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){

        int count = 0;
        while (true){

//            Arrays.sort(money);
            frame.render(money,count);
            count++;
            if(count >= 10000){
                AlgoVisHelper.pause(400000);
            }
            AlgoVisHelper.pause(40);
            for (int k = 0; k < 1; k++){
                for (int i = 0; i < money.length;i++)
                    if (money[i] > 0){
                        int j = (int)(Math.random() * money.length);
                        money[i] -= 1;
                        money[j] += 1;
                    }
            }

        }

    }


    public static void main(String[] args) {

        int sceneWidth = 1000;
        int sceneHeight = 800;

        // TODO: 根据需要设置其他参数，初始化visualizer
        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
