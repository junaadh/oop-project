module oopsdg {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens oopsdg to javafx.fxml;
    exports oopsdg;
}
