package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Sample5 extends Application {
    // displaying menu bar with menu items
    private Label lb;
    private MenuBar mb;
    private Menu[] mn = new Menu[4];
    private MenuItem[] mi = new MenuItem[7];
    private SeparatorMenuItem sm;

    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage stage) throws Exception {
        lb = new Label("いらっしゃいませ。");
        mb = new MenuBar();

        mn[0] = new Menu("メイン１");
        mn[1] = new Menu("メイン２");
        mn[2] = new Menu("サブ１");
        mn[3] = new Menu("サブ２");

        mi[0] = new MenuItem("乗用車");
        mi[1] = new MenuItem("トラック");
        mi[2] = new MenuItem("オープンカー");
        mi[3] = new MenuItem("タクシー");
        mi[4] = new MenuItem("スポーツカー");
        mi[5] = new MenuItem("ミニカー");
        mi[6] = new SeparatorMenuItem();

        mn[0].getItems().addAll(mi[0], mi[1]);
        mn[2].getItems().addAll(mi[2], mi[3]);
        mn[3].getItems().addAll(mi[4], mi[5]);

        mn[1].getItems().addAll(mn[2]);
        mn[1].getItems().addAll(mi[6], mn[3]);

        mb.getMenus().addAll(mn[0], mn[1]);

        BorderPane bp = new BorderPane();

        bp.setTop(mb);
        bp.setCenter(lb);

        for(int i = 0; i < mi.length; i++) {
            mi[i].setOnAction(new SampleEventHandler());
        }

        Scene sc = new Scene(bp, 300, 200);

        stage.setScene(sc);

        stage.setTitle("サンプル");
        stage.show();

    }

    class SampleEventHandler implements EventHandler<ActionEvent> {
        public void handle(ActionEvent e) {
            MenuItem tmp = (MenuItem) e.getSource();
            String str = tmp.getText();
            lb.setText(str + "ですね。");
        }
    }

}
