package com.example.myfirstproject;


import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OtherLabs1Controller {

    @FXML
    private CheckBox ChBDruz;

    @FXML
    private CheckBox ChBGnuch;

    @FXML
    private CheckBox ChBPogod;

    @FXML
    private CheckBox ChBSklad;

    @FXML
    private ChoiceBox<String> choiceB;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label lblTrueAnswer;

    @FXML
    private Label lblAnswerChoise;

    @FXML
    private Label lblAnwerCombo;

    @FXML
    private Label lblRadio;

    @FXML
    private RadioButton radioCode;

    @FXML
    private RadioButton radioHier;

    @FXML
    private RadioButton radioLay;

    @FXML
    private RadioButton radioProp;

    private ToggleGroup radiotoggleGroup;


    public void initialize() {
        lblTrueAnswer.setText("");
        lblAnswerChoise.setText ("");
        lblAnwerCombo.setText("");
        lblRadio.setText("");

        choiceB.getItems().addAll("Правильно" , "Неправильно");
        comboBox.getItems().addAll("BorderPane", "AncorePane", "VBox", "HBox");


        radiotoggleGroup = new ToggleGroup () ;
        this.radioProp.setToggleGroup (radiotoggleGroup) ;
        this.radioLay.setToggleGroup (radiotoggleGroup);
        this.radioHier.setToggleGroup (radiotoggleGroup);
        this.radioCode.setToggleGroup (radiotoggleGroup) ;
    }

    @FXML
    void choiceBoxAnswer(ActionEvent event) {
        lblAnswerChoise.setText(choiceB.getValue().toString());
    }

    @FXML
    void comboBoxPressed (ActionEvent event) {
        lblAnwerCombo.setText("Відповідь:" + comboBox.getValue().toString());
    }

    @FXML
    void handlechoiceBoxAnswer (ActionEvent event) {
        lblAnswerChoise.setText("Відповідь: " + choiceB.getValue().toString());
    }

    @FXML
    void checkBoxAnswer(ActionEvent event) {
        String answer = "Ваша відповідь:";
        if (ChBPogod.isSelected())
            answer += "\nПогодженість";
        if (ChBGnuch.isSelected())
            answer += "\nГнучкість";
        if (ChBDruz.isSelected())
            answer += "\nДружність";
        if (ChBSklad.isSelected())
            answer += "\nСкладність";

        this.lblTrueAnswer.setText(answer);
    }


    @FXML
    void RadioAnswer(ActionEvent event) {
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radioCode))
            lblRadio.setText("Відповідь: Code");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radioHier))
            lblRadio.setText("Відповідь: Hierarchy");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radioLay))
            lblRadio.setText("Відповідь: Layout");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radioProp))
            lblRadio.setText ("Відповідь: Properties");
    }

}