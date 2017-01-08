package pomodoro.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import pomodoro.model.Attempt;
import pomodoro.model.AttemptKind;


/**
 * Created by konstantinos on 1/8/2017.
 */
public class Home {
    private Attempt currentAttempt;
    private StringProperty timerText;

    @FXML
    private VBox container;
    @FXML
    private Label title;

    public Home() {
        timerText = new SimpleStringProperty();
        setTimerText(0);
    }

    public String getTimerText() {
        return timerText.get();
    }

    public StringProperty timerTextProperty() {
        return timerText;
    }

    public void setTimerText(String timerText) {
        this.timerText.set(timerText);
    }

    public void setTimerText(int remainingSeconds) {
        int minutes = remainingSeconds / 60;
        int seconds = remainingSeconds % 60;
        setTimerText(String.format("%02d:%02d", minutes, seconds));
    }

    private void prepareAttempt(AttemptKind attemptKind) {
        clearAttemptStyles();
        currentAttempt = new Attempt(attemptKind, "");
        addAttemptStyle(attemptKind);
        title.setText(attemptKind.getDisplayName());
        setTimerText(currentAttempt.getRemainingSeconds());
    }

    private void addAttemptStyle(AttemptKind attemptKind) {
        container.getStyleClass().add(attemptKind.toString().toLowerCase());
    }

    private void clearAttemptStyles() {
        for (AttemptKind attemptKind : AttemptKind.values()) {
            container.getStyleClass().remove(attemptKind.toString());
        }
    }

    public void DEBUG(ActionEvent actionEvent) {
        System.out.println("HI MOM");
    }
}
