package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import users.User;

/**
 * The Data class is responsible for saving information about all users, artwork and other related information to file 
 * @author Richard Famoroti
 * 
 *
 */
public class Data {
	private static final String FILE_DELIMETER = "--end--";
	private static ArrayList<User> users = new ArrayList<User>();
	//ArtworkTree artworks;
	
	
	//+GET_ALL_USERS(): UserFile[]
	
	/**
	 * Returns all the Users registered to Artatawe.
	 * 
	 * @return the Users registered to Artatawe
	 */
	public static ArrayList<User> getAllUsers() {
		return users;
	}

	//SAVE_USERFILE(file: UserFile): Boolean
	/**
	 * Responsible for saving user to file 
	 * @param mUser user
	 * @return {@code true} if file was successfully saved to file;
	 * 		   {@code false} otherwise. 
	 */
	public static boolean saveUser(User mUser) {
		File file = new File("users.txt");
		BufferedWriter writer = null;
		
		try{
		if (!file.isFile()){
			file.createNewFile();
		}
		
		User foundProfile = null;
		foundProfile = checkUserExistInFile(mUser);
		
		if(foundProfile == null){
			users.add(mUser);
			writer = new BufferedWriter(new FileWriter(file,true));
			writer.write(mUser.toString());
			writer.write("\n");
			writer.write(FILE_DELIMETER);
			writer.write("\n");
		}else{
			 
			//Removes old user data from list of users 
			for(int i = 0; i < users.size(); i++) {
				User u = users.get(i);
				if(u.getUserId() == mUser.getUserId()) {
					users.remove(users.indexOf(u));
					//adds new User data
					users.add(mUser);
					i = users.size();
				}
			}
			//Refreshes the Database
			Data.init();
			writer = new BufferedWriter(new FileWriter(file));
			for(User u: getAllUsers()){
				writer.write(u.toString());
				writer.write("\n");					
				writer.write(FILE_DELIMETER);
				writer.write("\n");	
			}
		}
		if(writer!= null) writer.close();
		return true;
		}catch(IOException e){
			e.printStackTrace();
		}
		return false;
	}
	
	//Resets all files
	/**
	 * Resets all files back to empty
	 */
	public static void init(){
		File file = new File("users.txt");
		if(file.isFile()){
			file.delete();
			return;
		}
	}

	
	//+GET_USER(id: int): UserFile
	/**
	 * Searches user database for user id that matches {@code id}
	 * @see User
	 * @param id users id
	 * @return User instance with matching id
	 */
	public static User getUser(int id) {
		for(User u: users){
			if (u.getUserId() == id) {
				return u;
			}
		}
		return null;
	}
	//+GET_USER_ID(file: UserFile): int
	//Should be in User\
	
	//+ART_INORDER():Artworks[]   should be in artwork tree 
	
	
	
	
	//Check file if user exists in file 
	private static User checkUserExistInFile(User user) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("users.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		String currentLine;
		
		while(scanner.hasNextLine()) {
			currentLine = scanner.nextLine();
			if(currentLine.contains(String.valueOf(user.getUserId()))){
				return getUser(user.getUserId());
			}
		}
		
		return null;
		
	}
}
