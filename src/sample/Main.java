package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        VBox vBox = new VBox();


        Menu settingsMenu = new Menu("Settings");
        Menu primaryKeyMenu = new Menu("Extra Key");
        settingsMenu.getItems().add(primaryKeyMenu);

        TextField primaryKeyTextField = new TextField();

        CustomMenuItem textField = new CustomMenuItem(primaryKeyTextField);

        primaryKeyMenu.getItems().add(textField);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(settingsMenu);




        vBox.getChildren().add(menuBar);




        HBox hBox1 = new HBox();
        hBox1.setPadding(new Insets(10, 5, 5, 15));
        TextField keyTextField = new TextField("Key");
        keyTextField.setPadding(new Insets(0, 0, 0, 5));
        Label keyLabel = new Label("Key");
        keyLabel.setPadding(new Insets(0, 10, 0, 0));



        hBox1.getChildren().addAll(keyLabel, keyTextField);



        vBox.getChildren().add(hBox1);


        HBox hBox2 = new HBox();


        Button button1 = new Button("Encrypt");
        button1.setMinWidth(70);





        //button1.setPadding(new Insets(0, 50, 0, 0));
        TextArea encryptionTextArea = new TextArea();
        encryptionTextArea.setPadding(new Insets(0, 0, 0, 5));
        hBox2.setPadding(new Insets(10, 15, 5, 15));

        hBox2.getChildren().addAll(button1, new Label("  "), encryptionTextArea);

        vBox.getChildren().add(hBox2);


        HBox hBox3 = new HBox();


        Button button2 = new Button("Decrypt");
        button2.setMinWidth(70);
        //button1.setPadding(new Insets(0, 50, 0, 0));
        TextArea decryptionTextArea = new TextArea();
        decryptionTextArea.setPadding(new Insets(0, 0, 0, 5));
        hBox3.setPadding(new Insets(10, 15, 25, 15));

        hBox3.getChildren().addAll(button2, new Label("  "), decryptionTextArea);


        vBox.getChildren().add(hBox3);




        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String pKey = primaryKeyTextField.getText();
                String key = keyTextField.getText();

                Encryption encryption = new Encryption();

                try {
                    decryptionTextArea.setText(encryption.encrypt(key, encryptionTextArea.getText().trim()));

                } catch (Exception e1) {
                    decryptionTextArea.setText(e1.getMessage());
                    e1.printStackTrace();
                }



            }
        });


        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                String pKey = primaryKeyTextField.getText();
                String key = keyTextField.getText();

                Decryption decryption = new Decryption();

                try {
                    encryptionTextArea.setText(decryption.decrypt(key, decryptionTextArea.getText().trim()));

                } catch (Exception e1) {
                    encryptionTextArea.setText(e1.getMessage());
                    e1.printStackTrace();
                }



            }
        });


        primaryStage.setTitle("AES 256 - En / Decryption");
        primaryStage.setScene(new Scene(vBox, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
