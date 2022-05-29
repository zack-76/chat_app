package Server;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class ServerApplication extends Application {

        public void start(Stage stage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(ServerApplication.class.getResource("ServerApp.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setResizable(false);
            stage.setTitle("Chat Server");
            stage.setScene(scene);
            stage.show();
        }

        public static void main(String[] args) {

            launch();
        }
}
