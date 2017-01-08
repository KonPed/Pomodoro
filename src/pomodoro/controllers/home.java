package pomodoro.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import pomodoro.model.Attempt;
import pomodoro.model.AttemptKind;

/**
 * Created by konstantinos on 1/8/2017.
 */
public class home {
    private Attempt currentAttempt;

    @FXML
    private VBox container;

    private void prepareAttempt(AttemptKind attemptKind) {
        currentAttempt = new Attempt(attemptKind, "");
    }

    public void addAttemptStyle(AttemptKind attemptKind) {
        container.getStyleClass().add(attemptKind.toString().toLowerCase());
    }
}
