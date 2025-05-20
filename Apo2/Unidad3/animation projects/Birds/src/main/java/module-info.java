module co.icesi.animation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens co.icesi.animation to javafx.fxml;
    opens co.icesi.animation.imgs.birds;
    exports co.icesi.animation;
}