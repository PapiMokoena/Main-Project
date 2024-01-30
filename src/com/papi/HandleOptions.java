package com.papi;

import java.util.List;
import java.util.Scanner;

public class HandleOptions {
	public static void handleWelcomeScreenInput() 
	{
		boolean running = true;
		Scanner scan1 = new Scanner(System.in);
		do {
			try 
			{
				MenuOptions.displayMenu();
				int input = scan1.nextInt();

				switch (input) 
				{
				case 1:
					FileOperations.displayAllFiles("files");
					break;
				case 2:
					HandleOptions.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					scan1.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
			
		} while (running == true);
	}
	
	public static void handleFileMenuOptions() 
	{
		boolean running = true;
		Scanner scan2 = new Scanner(System.in);
		do 
		{
			try 
			{
				MenuOptions.displayFileMenuOptions();
				FileOperations.createMainFolderIfNotPresent("files");
				
				int input = scan2.nextInt();
				switch (input) 
				{
				case 1:
					// File Add
					System.out.println("Enter the name of the file to be added to the \"files\" folder");
					String fileToAdd = scan2.next();
					
					FileOperations.createFile(fileToAdd, scan2);
					
					break;
				case 2:
					// File/Folder delete
					System.out.println("Enter the name of the file to be deleted from \"files\" folder");
					String fileToDelete = scan2.next();
					
					FileOperations.createMainFolderIfNotPresent("files");
					List<String> filesToDelete = FileOperations.displayFileLocations(fileToDelete, "files");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int idx = scan2.nextInt();
					
					if (idx != 0) 
					{
						FileOperations.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						
						// If idx == 0, delete all files displayed for the name
						for (String path : filesToDelete) 
						{
							FileOperations.deleteFileRecursively(path);
						}
					}
					
					break;
				case 3:
					// File/Folder Search
					System.out.println("Enter the name of the file to be searched from \"files\" folder");
					String fileName = scan2.next();
					
					FileOperations.createMainFolderIfNotPresent("files");
					FileOperations.displayFileLocations(fileName, "files");

					break;
				case 4:
					// Go to Previous menu
					return;
				case 5:
					// Exit
					System.out.println("Program exited successfully.");
					running = false;
					scan2.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} 
			catch (Exception e) 
			{
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
			
		} while (running == true);
		
	}//End of method
	
}//End of Class
