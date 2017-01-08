package pomodoro.controllers;

import pomodoro.model.Attempt;
import pomodoro.model.AttemptKind;

/**
 * Created by konstantinos on 1/8/2017.
 */
public class home {
    private Attempt currentAttempt;

    private void prepareAttempt(AttemptKind attemptKind) {
    currentAttempt = new Attempt(attemptKind, "");
    }
}
