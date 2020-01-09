package weekend_12_13_XX.zad_1_ChuckNorris;

public class Joke {
    private String id;
    private String value;

    public Joke(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {

        return id;
    }

    public String getValue() {
        return value;
    }
}