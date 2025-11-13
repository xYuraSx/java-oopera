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
        for (int i = 0; i < listOfActors.size(); i++) {
            if (listOfActors.get(i).surname.equals(oldActorSurname)) {
                Actor oldActor = listOfActors.get(i);
                listOfActors.set(i, newActor);
                System.out.println("Актёр " + oldActor + " заменён на " + newActor);
                return;
            }
        }
        System.out.println("Актёр с фамилией '" + oldActorSurname + "' не найден в спектакле '" + title + "'");
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