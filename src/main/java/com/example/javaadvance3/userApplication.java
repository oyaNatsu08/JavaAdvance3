package com.example.javaadvance3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class userApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(userApplication.class.getResource("user-list.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 500, 500);
        stage.setTitle("ユーザー一覧");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }
}
