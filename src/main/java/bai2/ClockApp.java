package bai2;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ClockApp extends Application {
    private Label clockLabel;

    @Override
    public void start(Stage primaryStage) {
        clockLabel = new Label();
        clockLabel.setStyle("-fx-font-size: 48px;");

        StackPane root = new StackPane(clockLabel);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Clock App");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Update the clock every second
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateClock()));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateClock() {
        Date now = new Date();
        String time = new SimpleDateFormat("HH:mm:ss").format(now);
        clockLabel.setText(time);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
