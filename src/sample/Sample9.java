package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Sample9 extends Application {
    // drawing random-color dots on canvas at random locations

    private Canvas cv;

    public static void main(String[] args) {
        launch(args);
    }

    public void start (Stage stage) throws Exception {
        cv = new Canvas(300, 200);

        GraphicsContext gc = cv.getGraphicsContext2D();

        for(int i = 0; i < 100; i++) {
            int r = (int) (Math.random() * 256);
            int g = (int) (Math.random() * 256);
            int b = (int) (Math.random() * 256);

            double x = Math.random() * 300;
            double y = Math.random() * 200;

            gc.setFill(Color.rgb(r,g,b, 1.0));
            gc.fillOval(x, y, 10, 10);
        }

        BorderPane bp = new BorderPane();

        bp.setCenter(cv);

        Scene sc = new Scene(bp, 300, 200);

        stage.setScene(sc);

        stage.setTitle("サンプル");
        stage.show();

    }

}
