module com.example.animation {
    requires javafx.controls;
    requires javafx.fxml;
            
                        requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.animation to javafx.fxml;
    exports com.example.animation;
    exports com.example.animation.controller;
    opens com.example.animation.controller to javafx.fxml;
    exports com.example.animation.object;
    opens com.example.animation.object to javafx.fxml;
}