package pomodoro.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
    @FXML
    private Label title;


    private void prepareAttempt(AttemptKind attemptKind) {
        clearAttemptStyles();
        currentAttempt = new Attempt(attemptKind, "");
        addAttemptStyle(attemptKind);
        title.setText(attemptKind.getDisplayName());
    }

    private void addAttemptStyle(AttemptKind attemptKind) {
        container.getStyleClass().add(attemptKind.toString().toLowerCase());
    }

    private void clearAttemptStyles() {
        for (AttemptKind attemptKind : AttemptKind.values()) {
            container.getStyleClass().remove(attemptKind.toString());
        }
    }
}
