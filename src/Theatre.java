public class Theatre {
    public static void main(String[] args) {
        System.out.println("Открываем театральный сезон!\n");

        // Создаём актёров
        Actor actor1 = new Actor("Иван", "Петров", Gender.MALE, 180.5);
        Actor actor2 = new Actor("Мария", "Сидорова", Gender.FEMALE, 165.0);
        Actor actor3 = new Actor("Алексей", "Иванов", Gender.MALE, 175.2);

        // Создаём режиссёров
        Director director1 = new Director("Сергей", "Кузнецов", Gender.MALE, 15);
        Director director2 = new Director("Ольга", "Васильева", Gender.FEMALE, 8);

        // Создаём автора музыки и хореографа
        String musicAuthor = "Пётр Чайковский";
        String choreographer = "Мариус Петипа";

        // Создаём спектакли
        Show regularShow = new Show("Ревизор", 120, director1);
        Opera opera = new Opera("Евгений Онегин", 180, director2, musicAuthor,
                "Опера в трёх действиях по роману А.С. Пушкина", 30);
        Ballet ballet = new Ballet("Лебединое озеро", 150, director1, musicAuthor,
                "Волшебная история о заколдованной принцессе-лебеде", choreographer);

        // Распределяем актёров по спектаклям
        System.out.println("Распределение актёров:");
        regularShow.addActor(actor1);
        regularShow.addActor(actor2);

        opera.addActor(actor2);
        opera.addActor(actor3);

        ballet.addActor(actor1);
        ballet.addActor(actor3);

        // Пробуем добавить дубликат
        ballet.addActor(actor1);

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Выводим списки актёров для каждого спектакля
        System.out.println("Состав спектаклей:");
        regularShow.printActors();
        System.out.println();
        opera.printActors();
        System.out.println();
        ballet.printActors();

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Заменяем актёра
        System.out.println("Замена актёров:");
        ballet.replaceActor(actor2, "Иванов"); // Успешная замена
        ballet.replaceActor(actor1, "Несуществующий"); // Неудачная замена

        System.out.println("\nОбновлённый состав балета:");
        ballet.printActors();

        System.out.println("\n" + "=".repeat(50) + "\n");

        // Выводим либретто
        System.out.println("Либретто музыкальных спектаклей:");
        opera.printLibretto();
        System.out.println();
        ballet.printLibretto();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("Представление начинается! Приятного просмотра!");
    }
}