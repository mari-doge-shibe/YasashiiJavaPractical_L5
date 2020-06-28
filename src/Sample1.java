import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Sample1 extends Application {
    // displaying a combo box and showing a selected item in the label
    private Label lb;
    private ComboBox<String> cb;
    private ObservableList<String> ol;

    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage stage) throws Exception {
        lb = new Label("いらっしゃいませ。");
        cb = new ComboBox<String>();

        ObservableList<String> ol = FXCollections.observableArrayList("乗用車", "トラック", "オープンカー", "タクシー", "スポーツカー", "ミニカー");
        cb.setItems(ol);

        BorderPane bp = new BorderPane();

        bp.setTop(lb);
        bp.setCenter(cb);

        cb.setOnAction(new SampleEventHandler());

        Scene sc = new Scene(bp, 300, 200);

        stage.setScene(sc);

        stage.setTitle("サンプル");
        stage.show();

    }

    class SampleEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
            ComboBox tmp = (ComboBox) e.getSource();
            String str = tmp.getValue().toString();
            lb.setText(str + "ですね。");
        }
    }
}
