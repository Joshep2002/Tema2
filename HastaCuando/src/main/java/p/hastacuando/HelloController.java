package p.hastacuando;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public CheckBox chcPop;
    public CheckBox chcRock;
    public CheckBox chcSalsa;
    public Pane panePop;
    public TextField txtTimeDurationPop;
    public TextField txtAutorPop;
    public TextField txtAñoPop;
    public ChoiceBox chcNacional;
    public Pane paneRock;
    public TextField txtTimeDurationRock;
    public TextField txtAutorRock;
    public TextField txtAñoRock;
    public ChoiceBox chcSexo;
    public Pane paneSalsa;
    public TextField txtTimeDurationSalsa;
    public TextField txtAutorSalsa;
    public TextField txtAñoSalsa;
    public ChoiceBox chcGrupo;

    public ObservableList <String>  nacionalOextranjero ;
    public ObservableList <String>  sexo ;
    public ObservableList <String>  grupoOsolista ;

    public static final ObservableList <Canciones> todasCanciones = FXCollections.observableArrayList();
    public static final ObservableList <Pop> todasPop = FXCollections.observableArrayList();
    public static final ObservableList <Rock> todasRock = FXCollections.observableArrayList();
    public static final ObservableList <Salsa> todasSalsa = FXCollections.observableArrayList();
    public TableColumn colAutorPop;
    public TableColumn colAñoPop;
    public TableColumn colTiempoPop;
    public TableColumn colSexo;
    public Label lblTipo;
    public TableView <Rock>tableViewRock;
    public TableColumn colAutorRock;
    public TableColumn colAñoRock;
    public TableColumn colTiempoRock;
    public TableColumn colNacional;
    public TableView <Salsa> tableViewSalsa;
    public TableColumn colAutorSalsa;
    public TableColumn colAñoSalsa;
    public TableColumn colTiempoSalsa;
    public TableColumn colGrupo;
    public TableView <Pop>tableViewPop;
    public TableView <Canciones>tableViewCanciones;
    public TableColumn colCanciones;
    public ObservableList<TableView> todasLasTablas = FXCollections.observableArrayList();
    public ObservableList<TextField> todoslosTextFields = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Anadiendo todas las tablas a el observable list de tableView
        todasLasTablas.addAll(tableViewCanciones,tableViewRock,tableViewPop,tableViewSalsa);

        nacionalOextranjero = FXCollections.observableArrayList();
        grupoOsolista = FXCollections.observableArrayList();
        sexo = FXCollections.observableArrayList();

        tableViewCanciones.setItems(todasCanciones);
        tableViewPop.setItems(todasPop);
        tableViewRock.setItems(todasRock);
        tableViewSalsa.setItems(todasSalsa);

        colCanciones.setCellValueFactory(new PropertyValueFactory("autor"));

        colAutorPop.setCellValueFactory(new PropertyValueFactory<Canciones,Pop>("autor"));
        colAutorRock.setCellValueFactory(new PropertyValueFactory<Canciones,Rock>("autor"));
        colAutorSalsa.setCellValueFactory(new PropertyValueFactory<Canciones,Salsa>("autor"));

        colAñoPop.setCellValueFactory(new PropertyValueFactory<Canciones,Pop>("year"));
        colAñoRock.setCellValueFactory(new PropertyValueFactory<Canciones,Rock>("year"));
        colAñoSalsa.setCellValueFactory(new PropertyValueFactory<Canciones,Salsa>("year"));

        colTiempoPop.setCellValueFactory(new PropertyValueFactory<Canciones,Pop>("timeDuration"));
        colTiempoRock.setCellValueFactory(new PropertyValueFactory<Canciones,Rock>("timeDuration"));
        colTiempoSalsa.setCellValueFactory(new PropertyValueFactory<Canciones,Salsa>("timeDuration"));

        colSexo.setCellValueFactory(new PropertyValueFactory("masculinoOfemenino"));
        colNacional.setCellValueFactory(new PropertyValueFactory("nacionalOextranjero"));
        colGrupo.setCellValueFactory(new PropertyValueFactory("grupo"));

      todoslosTextFields.addAll(txtAutorPop,txtAutorRock,txtAutorSalsa,txtTimeDurationPop,txtTimeDurationRock,txtTimeDurationSalsa,txtAñoPop,txtAñoRock,txtAñoSalsa);




        nacionalOextranjero.addAll("Nacional","Extranjero");
        chcNacional.setItems(nacionalOextranjero);
        chcNacional.setValue("Escoje");

        sexo.addAll("Masculino","Femenino");
        chcSexo.setItems(sexo);
        chcSexo.setValue("Escoje");

        grupoOsolista.addAll("Grupo","Solista");
        chcGrupo.setItems(grupoOsolista);
        chcGrupo.setValue("Escoje");
    }




    public void btnAgregar(MouseEvent mouseEvent) {
        if(panePop.isVisible()){
            String tiempo =txtTimeDurationPop.getText();
            String autor = txtAutorPop.getText();
            String year = txtAñoPop.getText();
            String sexo = (String) chcSexo.getSelectionModel().getSelectedItem();

            Pop p = new Pop (tiempo,autor,year,sexo);
            todasCanciones.add(p);
            todasPop.add(p);
            tableViewCanciones.setItems(todasCanciones);
            tableViewPop.setItems(todasPop);
            tableViewCanciones.refresh();
            tableViewPop.refresh();




        }else if(paneRock.isVisible()){
            String tiempoR = txtTimeDurationRock.getText();
            String autorR = txtAutorRock.getText();
            String yearR = txtAñoRock.getText();
            String nacionalOextranjero = (String) chcNacional.getSelectionModel().getSelectedItem();

            Rock r = new Rock (tiempoR,autorR,yearR,nacionalOextranjero);
            todasCanciones.add(r);
            todasRock.add(r);
            tableViewCanciones.setItems(todasCanciones);
            tableViewRock.setItems(todasRock);
            tableViewCanciones.refresh();
            tableViewRock.refresh();

        }else{

            String tiempoS = txtTimeDurationSalsa.getText();
            String autorS = txtAutorSalsa.getText();
            String yearS = txtAñoSalsa.getText();
            String grupoOsolista = (String) chcGrupo.getSelectionModel().getSelectedItem();

            Salsa s = new Salsa (tiempoS,autorS,yearS,grupoOsolista);
            todasCanciones.add(s);
            todasSalsa.add(s);
            tableViewCanciones.setItems(todasCanciones);
            tableViewSalsa.setItems(todasSalsa);
            tableViewCanciones.refresh();
            tableViewSalsa.refresh();

        }
    }

    public void btnMostrar(MouseEvent mouseEvent) {
    }



    public void popChc(MouseEvent mouseEvent) {
        chcPop.setSelected(true);

        panePop.setVisible(true);
        paneSalsa.setVisible(false);
        paneRock.setVisible(false);

        if(chcPop.isSelected()){
            chcRock.setSelected(false);
            chcSalsa.setSelected(false);
        }
        for(TableView p :todasLasTablas) {
            if(p == tableViewPop){
                lblTipo.setText("Canciones Pop");
                tableViewPop.setVisible(true);
                tableViewRock.setVisible(false);
                tableViewSalsa.setVisible(false);
                tableViewCanciones.setVisible(false);
            }
        }
        reset();



    }

    public void RockChc(MouseEvent mouseEvent) {
        chcRock.setSelected(true);

        paneRock.setVisible(true);
        panePop.setVisible(false);
        paneSalsa.setVisible(false);

        if(chcRock.isSelected()){
            chcPop.setSelected(false);
            chcSalsa.setSelected(false);
        }
        for(TableView p :todasLasTablas) {
            if(p == tableViewRock){
                lblTipo.setText("Canciones Rock");
                tableViewPop.setVisible(false);
                tableViewRock.setVisible(true);
                tableViewSalsa.setVisible(false);
                tableViewCanciones.setVisible(false);
        }
        }
        reset();
    }

    public void SalsaChc(MouseEvent mouseEvent) {
        chcSalsa.setSelected(true);

        paneSalsa.setVisible(true);
        panePop.setVisible(false);
        paneRock.setVisible(false);

        if(chcSalsa.isSelected()){
            chcPop.setSelected(false);
            chcRock.setSelected(false);
        }
        for(TableView p :todasLasTablas) {
            if(p == tableViewSalsa){
                lblTipo.setText("Canciones Salsa");
                tableViewPop.setVisible(false);
                tableViewRock.setVisible(false);
                tableViewSalsa.setVisible(true);
                tableViewCanciones.setVisible(false);
            }
        }
        reset();
    }

    public void reset(){
        for(TextField p : todoslosTextFields){
            p.setText("");
        }
    }

    public void onAtras(MouseEvent mouseEvent) {
        for(TableView p :todasLasTablas){
            if(p.equals(tableViewCanciones)){
                p.setVisible(true);
                tableViewRock.setVisible(false);
                tableViewSalsa.setVisible(false);
                tableViewPop.setVisible(false);
            }
        }
        lblTipo.setText("Todas las Canciones");
    }
}