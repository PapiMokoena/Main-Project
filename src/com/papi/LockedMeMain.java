package com.papi;

public class LockedMeMain {

	public static void main(String[] args) 
	{
		
		// Create "main" folder if not present in current folder structure
		FileOperations.createMainFolderIfNotPresent("files");
		
		MenuOptions.printWelcomeScreen("LockedMe", "Papi Mokoena");
		
		HandleOptions.handleWelcomeScreenInput();
		
	}//End of method

	
}
