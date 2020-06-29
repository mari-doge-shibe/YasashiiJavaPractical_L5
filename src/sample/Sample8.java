package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Optional;

public class Sample8 extends Application {
    private Label lb;
    private Button bt;

    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage stage) throws Exception {
        lb = new Label("いらっしゃいませ");
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
            Alert al1 = new Alert(Alert.AlertType.CONFIRMATION);
            al1.setTitle("確認");
            al1.getDialogPane().setHeaderText("本当に購入しますか？");
            Optional<ButtonType> res = al1.showAndWait();

            if(res.get() == ButtonType.OK) {
                Alert al2 = new Alert(Alert.AlertType.INFORMATION);
                al2.setTitle("購入");
                al2.getDialogPane().setHeaderText("ご購入ありがとうございました。");
                al2.show();
            }
        }
    }

}
