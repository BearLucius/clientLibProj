package edu.bip.clientlibproj.clientlibproj.controller;

import edu.bip.clientlibproj.clientlibproj.Entity.BookEntity;
import edu.bip.clientlibproj.clientlibproj.util.HTTPUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


import javax.swing.text.TabableView;

public class ApplicationController {
    public static ObservableList<BookEntity> booksData = FXCollections.observableArrayList();
    HTTPUtils http = new HTTPUtils();

    @FXML
    public TableView<BookEntity> tableBooks;

    @FXML
    private TableColumn<BookEntity, String> bookName;
    @FXML
    private TableColumn<BookEntity, String> bookAuthor;

    @FXML
    private TableColumn<BookEntity, String> bookPublisher;
    @FXML
    private TableColumn<BookEntity, String> bookYear;

    @FXML
    private TableColumn<BookEntity, String> bookChapter;

    @FXML

    private void initialize() throws Exception {
       System.out.println(http.get("http://localhost:28242/api/v1/all"));
    }

}
