import java.util.UUID;

public class Task {
    UUID uuid;

    public Task() {
        this.uuid = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return  " "+ uuid;
    }
}
