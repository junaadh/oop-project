module oopsdg {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens oopsdg to javafx.fxml;
    exports oopsdg;
}
