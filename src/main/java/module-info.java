module clinetLibraryProject {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.google.gson;
    requires okhttp3;
    requires static lombok;
    requires annotations;
    requires java.desktop;

    opens edu.bip.clientlibproj.clientlibproj to javafx.fxml;
    exports edu.bip.clientlibproj.clientlibproj;
    exports edu.bip.clientlibproj.clientlibproj.Entity;
    opens edu.bip.clientlibproj.clientlibproj.Entity to com.google.gson;
    exports edu.bip.clientlibproj.clientlibproj.controller;
    opens edu.bip.clientlibproj.clientlibproj.controller to javafx.fxml;
    exports edu.bip.clientlibproj.clientlibproj.response;
    opens edu.bip.clientlibproj.clientlibproj.response to com.google.gson;
}