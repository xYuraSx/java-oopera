import java.util.ArrayList;

public class Show {
    protected String title;
    protected int duration;
    protected Director director;
    protected ArrayList<Actor> listOfActors;

    public Show(String title, int duration, Director director) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.listOfActors = new ArrayList<>();
    }

    public void addActor(Actor actor) {
        if (listOfActors.contains(actor)) {
            System.out.println("Актёр " + actor + " уже участвует в спектакле!");
            return;
        }
        listOfActors.add(actor);
        System.out.println("Актёр " + actor + " добавлен в спектакль '" + title + "'");
    }

    public void replaceActor(Actor newActor, String oldActorSurname) {
        // Учитываем, что может быть несколько актеров с одной фамилией
        ArrayList<Actor> foundActors = new ArrayList<>();

        // Заменяем обычный for на enhanced for
        for (Actor actor : listOfActors) {
            if (actor.getSurname().equals(oldActorSurname)) {
                foundActors.add(actor);
            }
        }

        if (foundActors.isEmpty()) {
            System.out.println("Актёр с фамилией '" + oldActorSurname + "' не найден в спектакле '" + title + "'");
        } else if (foundActors.size() > 1) {
            System.out.println("Найдено несколько актёров с фамилией '" + oldActorSurname +
                    "'. Замена невозможна из-за неоднозначности.");
        } else {
            Actor oldActor = foundActors.getFirst(); // Используем getFirst() вместо get(0)
            int index = listOfActors.indexOf(oldActor);
            listOfActors.set(index, newActor);
            System.out.println("Актёр " + oldActor + " заменён на " + newActor);
        }
    }

    public void printActors() {
        System.out.println("Актёры спектакля '" + title + "':");
        if (listOfActors.isEmpty()) {
            System.out.println("  В спектакле пока нет актёров");
        } else {
            for (Actor actor : listOfActors) {
                System.out.println("  - " + actor);
            }
        }
    }

    @Override
    public String toString() {
        return "Спектакль: " + title + " (" + duration + " мин), режиссёр: " + director;
    }
}