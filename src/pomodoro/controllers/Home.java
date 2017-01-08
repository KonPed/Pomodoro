package pomodoro.controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;
import pomodoro.model.Attempt;
import pomodoro.model.AttemptKind;

/**
 * Created by konstantinos on 1/8/2017.
 */
public class Home {
    private Attempt currentAttempt;
    private StringProperty timerText;
    private Timeline timeLine;
    private AudioClip applause;

    @FXML
    private VBox container;
    @FXML
    private Label title;
    @FXML
    private TextArea message;

    public Home() {
        timerText = new SimpleStringProperty();
        setTimerText(0);
        applause = new AudioClip(getClass().getResource("/sounds/applause.mp3").toExternalForm());
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
        reset();
        timeLine = new Timeline();
        timeLine.setCycleCount(attemptKind.getTotalSeconds());
        timeLine.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            currentAttempt.tick();
            setTimerText(currentAttempt.getRemainingSeconds());
        }));
        currentAttempt = new Attempt(attemptKind, "");
        addAttemptStyle(attemptKind);
        title.setText(attemptKind.getDisplayName());
        setTimerText(currentAttempt.getRemainingSeconds());
        timeLine.setOnFinished(event -> {
            saveCurrentAttempt();
            applause.play();
            prepareAttempt(currentAttempt.getKind() == AttemptKind.FOCUS ? AttemptKind.BREAK : AttemptKind.FOCUS);
        });
    }

    public void saveCurrentAttempt() {
        currentAttempt.setMessage(message.getText());
        currentAttempt.save();
    }

    private void reset() {
        clearAttemptStyles();
        if (timeLine != null && timeLine.getStatus() == Animation.Status.RUNNING) {
            timeLine.stop();
        }
    }

    public void playTimer() {
        timeLine.play();
    }

    public void pauseTimer() {
        timeLine.pause();
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
        System.out.println("HI");
    }

    public void handleRestart(ActionEvent actionEvent) {
        prepareAttempt(AttemptKind.FOCUS);
        playTimer();
    }
}
