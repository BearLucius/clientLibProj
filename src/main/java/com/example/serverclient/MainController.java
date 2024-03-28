package com.example.serverclient;

import com.example.serverclient.entity.AuthorEntity;
import com.example.serverclient.entity.BookEntity;
import com.example.serverclient.entity.GenreEntity;
import com.example.serverclient.entity.PublisherEntity;
import com.example.serverclient.service.BookService;
import com.example.serverclient.service.HttpService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    private final BookService service = new BookService();

    @FXML
    private TableView<BookEntity> bookTable;

    @FXML
    private TableColumn<BookEntity, String> columnAuthor;

    @FXML
    private TableColumn<BookEntity, String> columnGenre;

    @FXML
    private TableColumn<BookEntity, String> columnNumber;

    @FXML
    private TableColumn<BookEntity, String> columnPublisher;

    @FXML
    private TableColumn<BookEntity, String> columnTitle;

    public MainController() {
    }

    @FXML
    void addBookAction(ActionEvent event) {

    }

    @FXML
    void addOrChangeAuthorAction(ActionEvent event) {

    }

    @FXML
    void addOrChangeCityAction(ActionEvent event) {

    }

    @FXML
    void addOrChangeGenreAction(ActionEvent event) {

    }

    @FXML
    void addOrChangePublisherAction(ActionEvent event) {

    }

    @FXML
    void changeBookAction(ActionEvent event) {

    }

    @FXML
    void closeAction(ActionEvent event) {

    }

    @FXML
        void deleteAuthorAction(ActionEvent event) {

    }

    @FXML
    void deleteBookAction(ActionEvent event) {
        HttpService service = new HttpService();
        System.out.println(service.get("http://localhost:2825/api/v1/books/all"));
    }

    @FXML
    void deleteCityAction(ActionEvent event) {

    }

    @FXML
    void deleteGenreAction(ActionEvent event) {

    }

    @FXML
    void deletePublisherAction(ActionEvent event) {

        }
    @FXML
    private void initialize(){
        service.getAll();

        columnAuthor.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("author"));
        columnGenre.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("genre"));
        columnNumber.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("year"));
        columnTitle.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("title"));
        columnPublisher.setCellValueFactory(new PropertyValueFactory<BookEntity, String>("publisher"));
        bookTable.setItems(service.getData());
    }
}
