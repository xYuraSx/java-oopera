public class MusicalShow extends Show {
    protected String musicAuthor;
    protected String librettoText;

    public MusicalShow(String title, int duration, Director director, String musicAuthor, String librettoText) {
        super(title, duration, director);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    // Геттеры для полей
    public String getMusicAuthor() {
        return musicAuthor;
    }

    public String getLibrettoText() {
        return librettoText;
    }

    public void printLibretto() {
        System.out.println("Либретто спектакля '" + title + "':");
        System.out.println(librettoText);
    }

    @Override
    public String toString() {
        return super.toString() + ", композитор: " + musicAuthor;
    }
}