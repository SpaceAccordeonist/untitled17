import java.io.IOException;
import java.util.Scanner;

public class Game {

    public static Character manager;
    public static Story story;

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        int u = 3, first = 0;
        System.out.println("Вы позвонили в службу спасения, ожидайте");
        for (int i = 0; i < 2; i++)
        {
            while (u != 0)
            {
                System.out.println("*");
                Thread.sleep(1000);
                u--;
            }
            u = 3;
            System.out.println("*Играет музыка*");
            Thread.sleep(1000);
            while (u != 0)
            {
                System.out.println("*");
                Thread.sleep(1000);
                u--;
            }
            Thread.sleep(100);
        }
        if (first == 1)
        {
            manager = new Character(in.next());
        }
        else
        {
            manager = new Character("12");
            first = 1;
        }
        story = new Story();
        while (true) {
            manager.A += story.current_situation.dA;
            manager.K += story.current_situation.dK;
            manager.R += story.current_situation.dR;
            /*System.out.println("=====\nКарьера:" + manager.K + "\tАктивы:"
                    + manager.A + "\tРепутация:" + manager.R + "\n=====");
            System.out.println("============="
                    + story.current_situation.subject + "==============");*/
            System.out.println(story.current_situation.text);
            if (story.isEnd()) {
                System.out
                        .println("====================the end!===================");
                return;
            }
            story.go(in.nextInt());
        }

    }

}