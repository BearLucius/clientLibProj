package edu.bip.clientlibproj.clientlibproj.controller;
import edu.bip.clientlibproj.clientlibproj.Entity.BookEntity;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import static edu.bip.clientlibproj.clientlibproj.controller.ApplicationController.booksData;
import static edu.bip.clientlibproj.clientlibproj.controller.MainController.booksData;
import static edu.bip.clientlibproj.clientlibproj.controller.MainController.updateBook;

public class EditBookController {
    @FXML
    private TextField bookName_field;
    @FXML
    private TextField bookAuthor_field;
    @FXML
    private TextField bookPublisher_field;
    @FXML
    private TextField bookYear_field;
    @FXML
    private TextField bookChapter_field;

    private Stage editBookStage;
    private BookEntity book;
    private int bookID;
    private boolean okClicked = false;

    public void setDialog(Stage dialogStage) {
        this.editBookStage = dialogStage;
    }

    public boolean isOkClicked()
    {
        return okClicked;
    }

    public void setLabels(BookEntity bookIn, int book_id) {
        this.book = bookIn;
        this.bookID = book_id;
        bookName_field.setText(book.getTitle());
        bookAuthor_field.setText(book.getAuthor());
        bookPublisher_field.setText(book.getPublishing());
        bookYear_field.setText(book.getYear());
        bookChapter_field.setText(book.getYear());
    }

@FXML
private void handleOk () throws IOException {
        if (isInputValid()) {
            book.setTitle(bookName_field.getText());
            book.setAuthor(bookAuthor_field.getText());
            book.setPublishing(bookPublisher_field.getText());
            book.setYear(bookYear_field.getText());
            book.setKind(bookChapter_field.getText());

            okClicked = true;
            editBookStage.close();
            booksData.set(bookID, book);
        }
}

    private boolean isInputValid() {
        return false;
    }

    @FXML
private void handleCancel() {
        private boolean isInputValid() {
            String errorMessage = "";

            if (bookName_field.getText() == null || bookName_field.getText().length() == 0) errorMessage+= "Не обнаружено название книги!\n";
            if (bookAuthor_field.getText() == null || bookAuthor_field.getText().length() == 0) errorMessage+= "Не обнаружен автор книги!\n";
            if (bookPublisher_field.getText() == null || bookPublisher_field.getText().length() == 0) errorMessage += "Не обнаружено издание книги!\n";
            if (bookYear_field.getText() == null || bookYear_field.getText().length() == 0) errorMessage += "Не обнаружен год выпуска книги!\n";
            else {
                try{
                    Integer.parseInt(bookYear_field.getText());
                } catch (NumberFormatException e) {
                    errorMessage += "Не корректное значение года выпуска книги (Должно быть целочисленным)!\n";
                }
            }
            if (bookChapter_field.getText() == null || bookChapter_field.getText().length() == 0) errorMessage+= "Не обнаружен раздел содержания книги!\n";


    }
}

@FXML
void addBook(ActionEvent event) throws IOException {
    //Application.showPersonDialog();
}
}
