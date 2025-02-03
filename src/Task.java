import java.util.UUID;

public class Task {
    private final UUID uuid;

    public Task() {
        this.uuid = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return  " " + uuid;
    }
}
