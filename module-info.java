module package_path {
    requires javafx.controls;
    requires javafx.fxml;


    opens package_path to javafx.fxml;
    exports PackagePath;
}
