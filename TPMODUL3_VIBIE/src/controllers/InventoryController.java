package controllers;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Album;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class InventoryController {

    @FXML
    private TableView<Album> albumTableData;

    @FXML
    private TableColumn<Album, String> albumNameColumn;

    @FXML
    private TableColumn<Album, String> artistColumn;

    @FXML
    private TableColumn<Album, Integer> availableColumn;

    @FXML
    private TableColumn<Album, Integer> totalColumn;

    private ObservableList<Album> albumList = FXCollections.observableArrayList();

    private Album selectedAlbum = null;

    public void initialize() {
        albumNameColumn.setCellValueFactory(new PropertyValueFactory<>("albumName"));
        artistColumn.setCellValueFactory(new PropertyValueFactory<>("artist"));
        availableColumn.setCellValueFactory(new PropertyValueFactory<>("available"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        albumTableData.setItems(albumList);

        albumTableData.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                Album selectedAlbum = albumTableData.getSelectionModel().getSelectedItem();
                if (selectedAlbum != null) {
                    populateFields(selectedAlbum);
                }
            }
        });
    }

    @FXML
    private TextField tfAlbumName;

    @FXML
    private TextField tfArtist;

    @FXML
    private TextField tfTotal;

    @FXML
    private TextField tfRented;

    @FXML
    void AddFunction(ActionEvent event) throws IOException {
        String albumName = tfAlbumName.getText();
        String artist = tfArtist.getText();
        String totalText = tfTotal.getText();
        String rentedText = tfRented.getText();

        if (albumName.isEmpty() || artist.isEmpty() || totalText.isEmpty() || rentedText.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Input Validation Error");
            alert.setContentText("All fields must be filled out!");
            alert.showAndWait();
            return;
        }

        if (isAlbumNameExists(albumName)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Duplicate Album Name");
            alert.setContentText("An album with this name already exists!");
            alert.showAndWait();
            return;
        }

        try {
            int total = Integer.parseInt(totalText);
            int rented = Integer.parseInt(rentedText);

            if (rented > total) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Rented cannot exceed Total.");
                alert.showAndWait();
                return;
            }

            int available = total - rented;

            Album newAlbum = new Album(albumName, artist, available, rented, total);
            albumList.add(newAlbum);

            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Album successfully created!");
            successAlert.showAndWait();

            clearData();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Total and Rented fields must be numeric!");
            alert.showAndWait();
        }
    }

    @FXML
    void EditFunction(ActionEvent event) throws IOException {
        if (selectedAlbum == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Album Selected");
            alert.setContentText("Please double-click an album in the table to edit.");
            alert.showAndWait();
            return;
        }

        String albumName = tfAlbumName.getText();
        String artist = tfArtist.getText();
        String totalText = tfTotal.getText();
        String rentedText = tfRented.getText();

        if (albumName.isEmpty() || artist.isEmpty() || totalText.isEmpty() || rentedText.isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Input Validation Error");
            alert.setContentText("All fields must be filled out!");
            alert.showAndWait();
            return;
        }

        if (!selectedAlbum.getAlbumName().equalsIgnoreCase(albumName) && isAlbumNameExists(albumName)) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Duplicate Album Name");
            alert.setContentText("An album with this name already exists!");
            alert.showAndWait();
            return;
        }

        try {
            int total = Integer.parseInt(totalText);
            int rented = Integer.parseInt(rentedText);

            if (rented > total) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Input");
                alert.setContentText("Rented cannot exceed Total.");
                alert.showAndWait();
                return;
            }

            int available = total - rented;

            selectedAlbum.setAlbumName(albumName);
            selectedAlbum.setArtist(artist);
            selectedAlbum.setTotal(total);
            selectedAlbum.setAvailable(available);

            albumTableData.refresh();

            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Album successfully updated!");
            successAlert.showAndWait();

            clearData();
            selectedAlbum = null;
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Total and Rented fields must be numeric!");
            alert.showAndWait();
        }
    }

    @FXML
    void DeleteFunction(ActionEvent event) throws IOException {
        Album selectedAlbum = albumTableData.getSelectionModel().getSelectedItem();
    
        if (selectedAlbum != null) {
            albumList.remove(selectedAlbum);
    
            Alert successAlert = new Alert(AlertType.INFORMATION);
            successAlert.setTitle("Success");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Album successfully deleted!");
            successAlert.showAndWait();
        } else {
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setTitle("Error");
            errorAlert.setHeaderText("No Selection");
            errorAlert.setContentText("Please select an album to delete.");
            errorAlert.showAndWait();
        }
    }

    public void clearData() {
        tfAlbumName.clear();
        tfArtist.clear();
        tfTotal.clear();
        tfRented.clear();
    }

    private void populateFields(Album album) {
        selectedAlbum = album; 
        tfAlbumName.setText(album.getAlbumName());
        tfArtist.setText(album.getArtist());
        tfTotal.setText(String.valueOf(album.getTotal()));
        tfRented.setText(String.valueOf(album.getTotal() - album.getAvailable()));
    }

    private boolean isAlbumNameExists(String albumName) {
        return albumList.stream().anyMatch(album -> album.getAlbumName().equalsIgnoreCase(albumName));
    }
    
    @FXML
    void RentSelectionFunction(ActionEvent event) throws IOException {
        Album selectedAlbum = albumTableData.getSelectionModel().getSelectedItem();
    
        if (selectedAlbum == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No Album Selected");
            alert.setContentText("Please select an album to rent.");
            alert.showAndWait();
            return;
        }
    
        if (selectedAlbum.getAvailable() <= 0) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Out of Stock");
            alert.setContentText("No available copies to rent.");
            alert.showAndWait();
            return;
        }
    
        selectedAlbum.setAvailable(selectedAlbum.getAvailable() - 1);
    
        albumTableData.refresh();
    
        Alert successAlert = new Alert(AlertType.INFORMATION);
        successAlert.setTitle("Success");
        successAlert.setHeaderText(null);
        successAlert.setContentText("Album successfully rented!");
        successAlert.showAndWait();
    }    
}
