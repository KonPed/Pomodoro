package pomodoro.model;

/**
 * Created by konstantinos on 1/2/2017.
 */
public class Attempt {
    private String message;
    private int remainingSeconds;
    private AttemptKind kind;

    public Attempt(AttemptKind kind, String message) {
        this.kind = kind;
        this.message = message;
        remainingSeconds = kind.getTotalSeconds();
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public AttemptKind getKind() {
        return kind;
    }

    public void tick() {
        remainingSeconds--;
    }

    public void save() {
        System.out.printf("Saving: %s%n", this);
    }

    @Override
    public String toString() {
        return "Attempt{" +
                "message='" + message + '\'' +
                ", remainingSeconds=" + remainingSeconds +
                ", kind=" + kind +
                '}';
    }
}
