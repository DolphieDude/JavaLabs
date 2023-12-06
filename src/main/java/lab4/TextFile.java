package lab4;

public class TextFile {
    private final String path;

    private final String description;

    public TextFile(String path, String description) {
        this.path = path;
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }
}
