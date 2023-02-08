module p.hastacuando {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens p.hastacuando to javafx.fxml;
    exports p.hastacuando;
}