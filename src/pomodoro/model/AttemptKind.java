package pomodoro.model;

/**
 * Created by konstantinos on 1/2/2017.
 */
public enum AttemptKind {
   FOCUS(5, "Focus Time"), BREAK(5, "Break Time");

   private int totalSeconds;
   private String displayName;

   AttemptKind(int totalSeconds, String displayName) {
       this.totalSeconds = totalSeconds;
       this.displayName = displayName;
   }

   public int getTotalSeconds() {
       return totalSeconds;
   }

   public String getDisplayName() {
       return displayName;
   }
}
