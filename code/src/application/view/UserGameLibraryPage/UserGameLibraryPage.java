package application.view.UserGameLibraryPage;

import java.io.IOException;

import application.Main;
import application.model.game.Game;
import application.model.game.Genre;
import application.model.profile.ActiveUser;
import application.view.profile.UserProfilePage;
import application.viewModel.UserGameLibrary.UserGameLibraryViewModel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class UserGameLibraryPage {
	
	@FXML
	private HBox libraryHBox;
	
	@FXML
	private HBox mystiverseHBox;
	
	@FXML
	private HBox profileHBox;
	
	@FXML
	private ListView<Game> myGamesListView;
	
	@FXML
	private TextField gameTitleTextField;
	
	@FXML
	private TextField gameDevelopersTextField;
	
	@FXML
	private ListView<Genre> gameGenresListView;
	
	@FXML
	private ImageView gamePhotoImageView;
	
	@FXML
	private TextArea communityTextArea;
	
	
	private UserGameLibraryViewModel viewModel;
	
	private UserProfilePage userProfilePageCodeBehind;
	
	
	/**
	 * Instantiates a new user game library page.
	 */
	public UserGameLibraryPage() {
		this.viewModel = new UserGameLibraryViewModel();
	}
	
	/**
	 * Initialize.
	 */
	@FXML
	public void initialize() {
		this.setupListView();
		this.bindToViewModel();
		this.setUpNavBar();
		this.populateListViews();
		this.viewModel.setUpGameLibrary();
	}
	
	private void populateListViews() {
		var ownedGamesObsList = FXCollections.observableArrayList(ActiveUser.getActiveUser().getAllOwnedGames());
		this.myGamesListView.setItems(ownedGamesObsList);
	}

	/**
	 * Open user game library page.
	 */
	public void openUserGameLibraryPage() {
		var newStage = new Stage();
		try {
			var loader = new FXMLLoader(getClass().getResource(Main.USER_GAME_LIBRARY_WINDOW));
			Parent parent = loader.load();
			var scene = new Scene(parent);
			newStage.initModality(Modality.WINDOW_MODAL);
			newStage.initOwner(((Stage) (parent.getScene().getWindow())));
			newStage.setTitle(Main.WINDOW_TITLE);
			newStage.setScene(scene);
			newStage.show();
		} catch (IOException error) {
			error.printStackTrace();
		}
	}

	private void bindToViewModel() {
		this.myGamesListView.itemsProperty().bindBidirectional(this.viewModel.getOwnedGames());
		
	}


	private void setupListView() {
		this.myGamesListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		//still needs to connect to some form of games had some manually entered or something
	}
	
	private void setUpNavBar() {
		this.setUpLibraryNavBarHBox();
		this.setUpMystiverseNavBarHbox();
		this.setUpProfileNavBarHBox();
	}
	
	private void setUpProfileNavBarHBox() {
		this.profileHBox.setOnMouseClicked(((event) -> {
			this.userProfilePageCodeBehind.openUserProfilePage();
		}));
	}

	private void setUpMystiverseNavBarHbox() {
		this.mystiverseHBox.setOnMouseClicked(((event) -> {
			var errorPopUp = new Alert(AlertType.CONFIRMATION);
			errorPopUp.setContentText("Button Click Works!");
			errorPopUp.showAndWait();
		}));
	}

	private void setUpLibraryNavBarHBox() {
		this.libraryHBox.setOnMouseClicked(((event) -> {
			var errorPopUp = new Alert(AlertType.CONFIRMATION);
			errorPopUp.setContentText("Button Click Works!");
			errorPopUp.showAndWait();
		}));
	}
	
	/**
	 * Update selected game.
	 */
	@FXML 
	public void updateSelectedGame() {
		this.viewModel.setSelectedGame(this.myGamesListView.getSelectionModel().getSelectedItem());
		this.gameTitleTextField.textProperty().set(this.viewModel.getSelectedGame().getName());
		this.gameDevelopersTextField.textProperty().set(this.viewModel.getSelectedGame().getDevelopers());
		this.gameGenresListView.itemsProperty().bind(this.viewModel.getSelectedGameGenres());
	}
}