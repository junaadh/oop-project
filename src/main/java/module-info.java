module oopsdg {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires javafx.web;

    opens oopsdg to javafx.fxml;
    exports oopsdg;
}
