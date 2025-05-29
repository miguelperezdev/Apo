module co.icesi.agar {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens co.icesi.agar to javafx.fxml;
    exports co.icesi.agar;
}