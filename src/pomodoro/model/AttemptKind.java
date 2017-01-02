package pomodoro.model;

/**
 * Created by konstantinos on 1/2/2017.
 */
public enum AttemptKind {
   FOCUS(25 * 60), BREAK(5 * 60);

   private int totalSeconds;

   AttemptKind(int totalSeconds) {
       this.totalSeconds = totalSeconds;
   }

   public int getTotalSeconds() {
       return totalSeconds;
   }
}
