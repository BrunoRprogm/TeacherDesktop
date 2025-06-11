package com.senai.teacherdesktop.Controllers;

import com.senai.teacherdesktop.DAO.SchoolClassDAO;
import com.senai.teacherdesktop.Models.SchoolClass;
import com.senai.teacherdesktop.Models.User;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//Classe da tela principal do professor.
public class PrincipalViewController {
    @FXML
    public Button btnExit;
    @FXML
    public Button btnExcluirTurma;

    @FXML
    private TableView<SchoolClass> tableListStudent;

    @FXML
    private TableColumn<SchoolClass, Integer> tableID;

    @FXML
    private TableColumn<SchoolClass, String> tableName;

    @FXML
    private Label txtNomeProfessor;

    @FXML
    public void initialize(){
        tableID.setCellValueFactory(new PropertyValueFactory<>("idTurma"));
        tableName.setCellValueFactory(new PropertyValueFactory<>("nm_turma"));

        try{
            ObservableList<SchoolClass> listaTurma = FXCollections.observableArrayList(SchoolClassDAO.listClass()) ;
            tableListStudent.setItems(listaTurma);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnExit(ActionEvent actionEvent) {
        Platform.exit();
    }

    public boolean confirmLogout(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //

        alert.setTitle("Confirmação de saída");
        alert.setHeaderText(null); // Deixando null para que não haja subtitulo
        alert.setContentText("Realmente deseja sair ?");

        ButtonType buttonYes =new ButtonType ("Sim");
        ButtonType buttonNo = new ButtonType("Não");

        alert.getButtonTypes().setAll(buttonYes,buttonNo);

        Optional<ButtonType> resultado = alert.showAndWait(); //Optional = "Pode haver algo" mas "Pode não haver algo"

        if (resultado.isPresent() && resultado.get() == buttonYes) {
            Platform.exit();
            return true;
        }

        return false;
    }
    @FXML
    void btnRegistration (ActionEvent event) throws IOException{
        System.out.println(getClass().getResource("/com/senai/teacherdesktop/user-registration.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/senai/teacherdesktop/views/user-registration.fxml"));
        Parent root = fxmlLoader.load();

        UserRegistration controllerCadastro = fxmlLoader.getController();

        controllerCadastro.setMainController(this);



        Scene scene = new Scene (root);
        Stage stage = new Stage();
        stage.setTitle("Cadastro de Turma");
        stage.setScene(scene);
        stage.show();
    }

    public void atualizarLista(){
        try{
            List<SchoolClass> turmas = SchoolClassDAO.listClass();

            tableListStudent.getItems().setAll(turmas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void btnExcluirTurma(ActionEvent event) throws  IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/senai/teacherdesktop/views/delete-class.fxml"));
        Parent root = loader.load();

        DeleteClassController controller = loader.getController();
        controller.setMainController(this); //passa o controller principal

        Stage stage = new Stage();
        stage.setTitle("Excluir Turma");
        stage.setScene(new Scene(root));
        stage.show();


    }

    public void setTxtNameProfessor(User user) {
        if(user != null){
            txtNomeProfessor.setText("Bem-vindo (a) , " + user.getNome());
        }

    }









}
