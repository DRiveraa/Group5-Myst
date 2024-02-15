/*
 * 
 */
package application.viewModel.profile.subProfilePages;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import application.model.profile.ActiveUser;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EditProfileAnchorViewModel {
	private StringProperty aboutMeProperty;

	/**
	 * Instantiates a new edits the profile anchor view model.
	 */
	public EditProfileAnchorViewModel() {
		this.aboutMeProperty = new SimpleStringProperty();
	}

	/**
	 * Import an image.
	 */
	public void importAnImage() {
		var fileChooser = new JFileChooser();
		var filter = new FileNameExtensionFilter("Image Files", "jpg", "png");
		fileChooser.setFileFilter(filter);
		
		var returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			var selectedFile = fileChooser.getSelectedFile();
			var imagePath = selectedFile.getPath();
			ActiveUser.getActiveUser().getProfileAttributes().setUserProfilePicturePath(imagePath);
		}
	}

	/**
	 * Sets the active user about me.
	 */
	public void setActiveUserAboutMe() {
		ActiveUser.getActiveUser().getProfileAttributes().setAboutMeDescription(this.aboutMeProperty.getValue());
	}

	/**
	 * Sets the about me text area.
	 */
	public void setAboutMeTextArea() {
		this.aboutMeProperty.setValue(ActiveUser.getActiveUser().getProfileAttributes().getAboutMeDescription());
	}

	/**
	 * Gets the about me property.
	 *
	 * @return the about me property
	 */
	public StringProperty getAboutMeProperty() {
		return this.aboutMeProperty;
	}

	/**
	 * Sets the about me property.
	 *
	 * @param aboutMeProperty the new about me property
	 */
	public void setAboutMeProperty(StringProperty aboutMeProperty) {
		this.aboutMeProperty = aboutMeProperty;
	}
}
