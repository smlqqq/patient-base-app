module com.example.patientbaseapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires lombok;
//    requires org.postgresql.jdbc;

    opens com.example.patientbaseapp to javafx.fxml;
    exports com.example.patientbaseapp;

}