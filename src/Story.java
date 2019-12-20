public class Story {

    private Situation start_story;
    public Situation current_situation;

    Story() {
        start_story = new Situation(
                "Звонок в 911\n",
                "Здравствуйте, вы позвонили в 911, какую службу вы хотели бы вызвать?\n"
                        + "1) 101 - Пожарные\n"
                        + "2) 102 - Полиция\n"
                        + "3) 103 - Скорая помощь\n",
                3, 0, 31, 0);
        start_story.direction[0] = new Situation(
                "Пожарные",
                "Извините, у нас технический проблемы. "
                        + "Мы Вам перезвоним.",
                0, 0, -10, 2);
        start_story.direction[1] = new Situation(
                "Полиция",
                "Извините, у нас технические проблемы, могли бы вы перезвонить позже?"
                        + "*пи-пи-пи*",
                0, 1, 100, 2);
        start_story.direction[2] = new Situation(
                "Скорая помощь",
                "Оператор : Здравствуйте, что у вас произошло?\n\n" + "Вы : чшш, помогите, у меня в доме неизвестный мне человек... он лежит рядом в крови, я не знаю, что делать...\n\n" + "Оператор : У вас есть под рукой какое-либо оружие?\n\n" + "1) да, есть нож\n" + "2) нет, откуда у меня оружие?"
, 2, 0,
                23, 1);
        start_story.direction[2].direction[0] = new Situation(
                "Продолжение 1",
                "Оператор : Пробуйте зарезать гада\n\n" + "1) Попробовать убить человека\n" + "2) Нет, я не.. не смогу",
                0, 1, 100, 0);
        start_story.direction[2].direction[0].direction[0] = new Situation(
                "Продолжение 2",
                "AAAAAAAAAAAAAAAA\n" +"AAAAAAAAAAAAA\n" +"AAAAAAAAA\n" + "<конец связи>",
                0, 1, 100, 0);
        start_story.direction[2].direction[0].direction[1] = new Situation(
                "Продолжение 2",
                "Ладно, я пошел, пока \n <конец связи>",
                0, 1, 100, 0);
        start_story.direction[2].direction[1] = new Situation(
                "Продолжение 2",
                "Оператор : У вас обычного кухонного ножа нет, вы вообще кто?\n\n" + "Я? Какая разница?... Вы можете прислать наряд или еще кого-нибудь?\n\n" + "Оператор : Все. Пока, конец связи",
                0, 1, 100, 0);
        current_situation = start_story;
    }

    public void go(int num) {
        if (num <= current_situation.direction.length)
            current_situation = current_situation.direction[num - 1];
        else
            System.out.println("Вы можете выбирать из "
                    + current_situation.direction.length + " вариантов");
    }

    public boolean isEnd() {
        return current_situation.direction.length == 0;
    }
}