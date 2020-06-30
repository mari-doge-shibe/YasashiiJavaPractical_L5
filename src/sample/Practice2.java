package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Practice2 extends Application {
    // clicking the 購入 button displays an alert.
    private Label lb;
    private Button bt;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        lb = new Label("いらっしゃいませ。");
        bt = new Button("購入");

        BorderPane bp = new BorderPane();

        bp.setTop(lb);
        bp.setCenter(bt);

        bt.setOnAction(new SampleEventHandler());

        Scene sc = new Scene(bp, 300, 200);

        stage.setScene(sc);

        stage.setTitle("サンプル");
        stage.show();

    }

    class SampleEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setTitle("購入");
            al.getDialogPane().setHeaderText(("大変ありがとうございました。"));
            al.show();
        }
    }

}
