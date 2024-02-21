package edu.bip.clientlibproj.clientlibproj;

import edu.bip.clientlibproj.clientlibproj.Entity.BookEntity;
import edu.bip.clientlibproj.clientlibproj.controller.EditBookController;
import edu.bip.clientlibproj.clientlibproj.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        AnchorPane mainApp = (AnchorPane) fxmlLoader.load();

        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Library_App");
        stage.setScene(scene);


        MainController controller = fxmlLoader.getController();
        stage.show();
    }

    public static boolean showPersonEditDialog (BookEntity bookObj, int id) {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Application.class.getResource("editBook.fxml"));
            AnchorPane page = (AnchorPane) loader.load();



            Stage dialogStage = new Stage ();
            dialogStage.setTitle("Редактирование книги");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            EditBookController controller = loader.getController();
            // controller.setDialogStage(dialogStage);
           // controller.setLabels(bookObj, id);


            dialogStage.showAndWait();
         return false;   // return controller.isOkClicked();
        }

        catch (IOException e)
        {
            throw new RuntimeException(e);

        }
    }

    public static void main(String[] args) {
        launch();
    }
}