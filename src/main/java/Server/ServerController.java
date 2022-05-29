package Server;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ServerController implements Initializable {

    public Server server;
    @FXML
    private Button btn_launch ;
    @FXML
    private Button btn_close ;
    @FXML
    private VBox vb_client;
    @FXML
    private ScrollPane sp_client;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btn_launch.setOnAction(actionEvent -> {
            try {
                server=new Server();
                server.start();
                btn_launch.setOpacity(0.5);
                btn_close.setOpacity(1);
                btn_close.setDisable(false);
                btn_launch.setDisable(true);
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        btn_close.setOnAction((actionEvent -> {

            try {
                server.serverClosed();
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("okkkkkkkkkkkk");
            }
            btn_close.setOpacity(0.5);
            btn_launch.setOpacity(1);
            btn_close.setDisable(true);
            btn_launch.setDisable(false);

        }));
    }

}
