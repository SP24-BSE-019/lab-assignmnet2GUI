/*package com.example.ooplabtaskgui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class UniversityFormAppp extends Application {

    private final ArrayList<Person> personList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(50);
        grid.setStyle("-fx-background-color: #2c3e50;");

        ImageView bannerImageView = new ImageView(new Image("File:C:\\Users\\Abduallah\\Pictures\\Picture12.jpg"));
        bannerImageView.setFitWidth(800);
        bannerImageView.setFitHeight(150);
        bannerImageView.setPreserveRatio(false);
        grid.add(bannerImageView, 0, 0, 2, 1);

        HBox headingBox = new HBox();
        headingBox.setStyle("-fx-alignment: center; -fx-border-color: white; -fx-border-width: 2px 0 2px 0;");
        Label formHeadings = new Label("University Registration Form:");
        formHeadings.setStyle("-fx-font-size: 30px; -fx-text-fill:white; -fx-font-weight: bold;");
        headingBox.getChildren().add(formHeadings);
        grid.add(headingBox, 0, 1, 2, 1);

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        TextField nameField = new TextField();

        Label fatherNameLabel = new Label("Father Name:");
        fatherNameLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        TextField fatherNameField = new TextField();

        Label cnicLabel = new Label("CNIC:");
        cnicLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        TextField cnicField = new TextField();

        Label dateLabel = new Label("Date of Birth:");
        dateLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        DatePicker datePicker = new DatePicker();

        Label genderLabel = new Label("Gender:");
        genderLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        ComboBox<String> genderComboBox = new ComboBox<>();
        genderComboBox.getItems().addAll("Male", "Female", "Other");

        Label genderLabel = new Label("Gender:");
        genderLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");

// Create RadioButtons for gender selection
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setStyle("-fx-text-fill:white;");

        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setStyle("-fx-text-fill:white;");

        RadioButton otherRadio = new RadioButton("Other");
        otherRadio.setStyle("-fx-text-fill:white;");

// Add the RadioButtons to a ToggleGroup to ensure only one can be selected
        ToggleGroup genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        otherRadio.setToggleGroup(genderGroup);

// Arrange the RadioButtons in an HBox for a horizontal layout
        HBox genderBox = new HBox(10, maleRadio, femaleRadio, otherRadio);

        Label cityLabel = new Label("City:");
        cityLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Karachi", "Islamabad", "Other");

        Label fileLabel = new Label("Choose Image:");
        fileLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        Button fileButton = new Button("Upload");
        fileButton.setStyle("-fx-background-color: #007acc; -fx-text-fill:white;");
        Label fileChosenLabel = new Label("No file chosen");

        ImageView imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        fileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

            if (selectedFile != null) {
                fileChosenLabel.setText("File: " + selectedFile.getName());
                Image image = new Image("file:" + selectedFile.getAbsolutePath());
                imageView.setImage(image);
            } else {
                fileChosenLabel.setText("No file chosen");
            }
        });

        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
        Label resultLabel = new Label();

        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String cnic = cnicField.getText();
            String dob = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "";
            //String gender = genderComboBox.getValue();
            gender = selectedGender.getText();
            String city = cityComboBox.getValue();

            if (name.isEmpty() || fatherName.isEmpty() || cnic.isEmpty() || dob.isEmpty() || gender == null || city == null) {
                resultLabel.setText("Please fill all the fields!");
                resultLabel.setStyle("-fx-text-fill:white;");
            } else {
                Person newPerson = new Person(name, fatherName, cnic, dob, gender, city);
                personList.add(newPerson);

                resultLabel.setText("Form Saved for: " + name);
                resultLabel.setStyle("-fx-text-fill: pink;");
                System.out.println("Saved Person: " + newPerson);
                System.out.println("Person List: " + personList);
            }
        });

        grid.add(nameLabel, 0, 2);
        grid.add(nameField, 1, 2);

        grid.add(fatherNameLabel, 0, 3);
        grid.add(fatherNameField, 1, 3);

        grid.add(cnicLabel, 0, 4);
        grid.add(cnicField, 1, 4);

        grid.add(dateLabel, 0, 5);
        grid.add(datePicker, 1, 5);

        grid.add(genderLabel, 0, 6);
        grid.add(genderComboBox, 1, 6);

        grid.add(cityLabel, 0, 7);
        grid.add(cityComboBox, 1, 7);

        grid.add(fileLabel, 0, 8);
        grid.add(fileButton, 1, 8);
        grid.add(fileChosenLabel, 0, 9, 2, 1);

        grid.add(imageView, 1, 9);
        grid.add(saveButton, 0, 10);
        grid.add(resultLabel, 1, 10);

        Scene scene = new Scene(grid, 800, 800);
        primaryStage.setTitle("University Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}*/

package com.example.ooplabtaskgui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class UniversityFormAppp extends Application {

    private final ArrayList<Person> personList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(50);
        grid.setStyle("-fx-background-color: #2c3e50;");

        ImageView bannerImageView = new ImageView(new Image("File:C:\\Users\\Abduallah\\Pictures\\Picture12.jpg"));
        bannerImageView.setFitWidth(800);
        bannerImageView.setFitHeight(150);
        bannerImageView.setPreserveRatio(false);
        grid.add(bannerImageView, 0, 0, 2, 1);

        HBox headingBox = new HBox();
        headingBox.setStyle("-fx-alignment: center; -fx-border-color: white; -fx-border-width: 2px 0 2px 0;");
        Label formHeadings = new Label("University Registration Form:");
        formHeadings.setStyle("-fx-font-size: 30px; -fx-text-fill:white; -fx-font-weight: bold;");
        headingBox.getChildren().add(formHeadings);
        grid.add(headingBox, 0, 1, 2, 1);

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        TextField nameField = new TextField();

        Label fatherNameLabel = new Label("Father Name:");
        fatherNameLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        TextField fatherNameField = new TextField();

        Label cnicLabel = new Label("CNIC:");
        cnicLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        TextField cnicField = new TextField();

        Label dateLabel = new Label("Date of Birth:");
        dateLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        DatePicker datePicker = new DatePicker();

        Label genderLabel = new Label("Gender:");
        genderLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");

        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setStyle("-fx-text-fill:white;");
        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setStyle("-fx-text-fill:white;");
        RadioButton otherRadio = new RadioButton("Other");
        otherRadio.setStyle("-fx-text-fill:white;");

        ToggleGroup genderGroup = new ToggleGroup();
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        otherRadio.setToggleGroup(genderGroup);

        HBox genderBox = new HBox(10, maleRadio, femaleRadio, otherRadio);

        Label cityLabel = new Label("City:");
        cityLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Karachi", "Islamabad", "Other");

        Label fileLabel = new Label("Choose Image:");
        fileLabel.setStyle("-fx-font-size: 14px; -fx-text-fill:white;");
        Button fileButton = new Button("Upload");
        fileButton.setStyle("-fx-background-color: #007acc; -fx-text-fill:white;");
        Label fileChosenLabel = new Label("No file chosen");

        ImageView imageView = new ImageView();
        imageView.setFitWidth(400);
        imageView.setFitHeight(200);
        imageView.setPreserveRatio(true);

        fileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

            if (selectedFile != null) {
                fileChosenLabel.setText("File: " + selectedFile.getName());
                Image image = new Image("file:" + selectedFile.getAbsolutePath());
                imageView.setImage(image);
            } else {
                fileChosenLabel.setText("No file chosen");
            }
        });

        Button saveButton = new Button("Save");
        saveButton.setStyle("-fx-background-color: #28a745; -fx-text-fill: white;");
        Label resultLabel = new Label();

        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String cnic = cnicField.getText();
            String dob = (datePicker.getValue() != null) ? datePicker.getValue().toString() : "";
            RadioButton selectedGender = (RadioButton) genderGroup.getSelectedToggle();
            String gender = (selectedGender != null) ? selectedGender.getText() : null;
            String city = cityComboBox.getValue();

            if (name.isEmpty() || fatherName.isEmpty() || cnic.isEmpty() || dob.isEmpty() || gender == null || city == null) {
                resultLabel.setText("Please fill all the fields!");
                resultLabel.setStyle("-fx-text-fill:white;");
            } else {
                Person newPerson = new Person(name, fatherName, cnic, dob, gender, city);
                personList.add(newPerson);

                resultLabel.setText("Form Saved for: " + name);
                resultLabel.setStyle("-fx-text-fill: pink;");
                System.out.println("Saved Person: " + newPerson);
                System.out.println("Person List: " + personList);
            }
        });

        grid.add(nameLabel, 0, 2);
        grid.add(nameField, 1, 2);

        grid.add(fatherNameLabel, 0, 3);
        grid.add(fatherNameField, 1, 3);

        grid.add(cnicLabel, 0, 4);
        grid.add(cnicField, 1, 4);

        grid.add(dateLabel, 0, 5);
        grid.add(datePicker, 1, 5);

        grid.add(genderLabel, 0, 6);
        grid.add(genderBox, 1, 6);

        grid.add(cityLabel, 0, 7);
        grid.add(cityComboBox, 1, 7);

        grid.add(fileLabel, 0, 8);
        grid.add(fileButton, 1, 8);
        grid.add(fileChosenLabel, 0, 9, 2, 1);

        grid.add(imageView, 1, 9);
        grid.add(saveButton, 0, 10);
        grid.add(resultLabel, 1, 10);

        Scene scene = new Scene(grid, 800, 800);
        primaryStage.setTitle("University Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}



