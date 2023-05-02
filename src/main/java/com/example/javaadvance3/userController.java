package com.example.javaadvance3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class userController {
    @FXML
    private TableView<User> table;
    @FXML
    private TableColumn<User, Integer> idColumn;
    @FXML
    private TableColumn<User, String> companyColumn;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, Integer> scoreColumn;

    @FXML
    private ComboBox<String> addCompany;
    @FXML
    private TextField addName;
    @FXML
    private TextField addScore;

    @FXML
    private ComboBox<String> editCompany;
    @FXML
    private TextField editName;
    @FXML
    private TextField editScore;

    @FXML
    private Label addError;

    @FXML
    private Label editError;

    int editId;

    int clickId;

    ObservableList<User> userList;

    //IDの最下部を保持する
    private int count = 4;

    @FXML
    public void initialize() {

        //テーブルリストの初期設定
        userList = FXCollections.observableArrayList();
        userList.add(new User(1, "RN社", "NN", 60, 1));
        userList.add(new User(2, "TC社", "BB", 80, 2));
        userList.add(new User(3, "BE社", "KK", 40, 3));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));

        table.setItems(userList);

        //追加処理の初期設定
        ObservableList<String> items = FXCollections.observableArrayList("RN社", "TC社", "BE社");
        addCompany.setItems(items);
        editCompany.setItems(items);

    }

    //追加ボタン
    @FXML
    public void addButtonClick() {

        try {
            int id = count;
            String companyName = this.addCompany.getValue();
            String addName = this.addName.getText();
            int addScore = Integer.parseInt(this.addScore.getText());
            int delId = userList.get(userList.size() - 1).delId + 1;

            //空白値チェック
            if (companyName == null || "".equals(addName)) {
                addError.setText("値を入力してください");
                return;
            } else if (addScore < 0 || addScore > 100) {          //スコア値チェック
                addError.setText("正しいスコアを入力してください");
                return;
            }

            userList.add(new User(id, companyName, addName, addScore, delId));
            table.setItems(userList);
            count++;

            addError.setText("");

        } catch (NumberFormatException e) {         //数値チェック
            addError.setText("スコアに数値を入力してください");
        }
    }

    @FXML
    public void onListClick() {
        User clickItems = table.getSelectionModel().getSelectedItem();
        clickId = clickItems.id;
        editId = clickItems.delId;
        String company = clickItems.company;
        String name = clickItems.name;
        Integer score = clickItems.score;

        editCompany.setValue(company);
        editName.setText(name);
        editScore.setText(score.toString());

    }

    @FXML
    public void deleteButtonClick() {
        try {
            String companyName = this.editCompany.getValue();
            String editName = this.editName.getText();
            int editScore = Integer.parseInt(this.editScore.getText());

            //空白値チェック
            if (companyName == null || "".equals(editName)) {
                editError.setText("値を入力してください");
                return;
            } else if (editScore < 0 || editScore > 100) {          //スコア値チェック
                editError.setText("正しいスコアを入力してください");
                return;
            }

            //リストから削除
            userList.remove(editId - 1);

            //delete用のidを修正
            for (int i = editId - 1; i < userList.size(); i++) {
                userList.get(i).delId -= 1;
            }

            table.setItems(userList);

            editError.setText("");

        } catch (NumberFormatException e) {
            editError.setText("スコアに数値を入力してください");
        }
    }

    @FXML
    public void editButtonClick() {
        try {
            String companyName = this.editCompany.getValue();
            String editName = this.editName.getText();
            int editScore = Integer.parseInt(this.editScore.getText());
            int delId = editId;

            //空白値チェック
            if (companyName == null || "".equals(editName)) {
                editError.setText("値を入力してください");
                return;
            } else if (editScore < 0 || editScore > 100) {          //スコア値チェック
                editError.setText("正しいスコアを入力してください");
                return;
            }

            userList.set(editId - 1, new User(clickId, companyName, editName, editScore, delId));
            table.setItems(userList);

            editError.setText("");

        } catch (NumberFormatException e) {
            editError.setText("スコアに数値を入力してください");
        }
    }
}
