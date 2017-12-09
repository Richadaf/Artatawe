
package data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import users.Artwork;
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
	private static ArrayList<Artwork> artworks = new ArrayList<Artwork>();
	//TOEO: Artwor, Bidding History
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
	/**
	 * Returns all the artworks registered to Artatawe.
	 * 
	 * @return the artworks registered to Artatawe
	 */
	public static ArrayList<Artwork> getAllArtworks() {
		return artworks;
	}

	public static boolean saveArtwork(Artwork art){
		
		File file = new File("artworks.txt");
		BufferedWriter writer = null;
		
		try{
			if (!file.isFile()){
				file.createNewFile();
			}
			
			//if artwork isnt in list, add and refresh database
			if(getArtwork(art.getTitle()) == null){
				artworks.add(art);
				
				Data.reset();
				writer = new BufferedWriter(new FileWriter(file));
				for(Artwork a: getAllArtworks()){
					writer.write(a.toString());
					writer.write("\n");					
					writer.write(FILE_DELIMETER);
					writer.write("\n");	
				}
			}
			
			Artwork foundArtwork = null;
			foundArtwork = checkArtExistInFile(art.getTitle());
			
			if(foundArtwork == null){
				artworks.add(art);
				writer = new BufferedWriter(new FileWriter(file,true));
				writer.write(art.toString());
				writer.write("\n");
				writer.write(FILE_DELIMETER);
				writer.write("\n");
			}
			if(writer!= null) writer.close();
			return true;
		}catch(IOException e){
			e.printStackTrace();
		}
		return false;
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
		
		//if user isnt in list, add and refresh database
			if(getUser(mUser.getUserName()) == null){
				users.add(mUser);
				Data.reset();
				writer = new BufferedWriter(new FileWriter(file));
				for(User u: getAllUsers()){
					writer.write(u.toString());
					writer.write("\n");					
					writer.write(FILE_DELIMETER);
					writer.write("\n");	
				}
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
	public static void reset(){
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
	/**
	 * Searches user database for username that matches {@code username}
	 * @see User
	 * @param username user-defined username
	 * @return User instance with matching username
	 */
	public static User getUser(String username){
		for(User u: users){
			if(u.getUserName().equalsIgnoreCase(username)){
				return u;
			}
		}
		/*//User isnt found in arrayList, so check file name
		User checkedUser = checkUserExistInFile(username);
		if(checkedUser != null){
			users.add(checkedUser);
			return checkedUser;
		}*/
		return null;
	}
	public static Artwork getArtwork(String title){
		for(Artwork a: artworks){
			if(a.getTitle().equalsIgnoreCase(title)){
				return a;
			}
		}
		/*//User isnt found in arrayList, so check file name
		User checkedUser = checkUserExistInFile(username);
		if(checkedUser != null){
			users.add(checkedUser);
			return checkedUser;
		}*/
		return null;
	}
	//+GET_USER_ID(file: UserFile): int
	//Should be in User\
	
	//+ART_INORDER():Artworks[]   should be in artwork tree 
	
	
	
	
	//Check file if user exists in file 
	private static User checkUserExistInFile(User user) {
		Scanner scanner = null;
		try {
			File users = new File("users.txt");
			scanner = new Scanner(users);
		String currentLine;
		
		while(scanner.hasNextLine()) {
			currentLine = scanner.nextLine();
			if(currentLine.contains(String.valueOf(user.getUserName()))){
				return getUser(user.getUserId());
			}
		}
		scanner.close();
		
		return null;
		} catch (FileNotFoundException e) {
			return null;
		} 
	}
	//Check file if user exists in file
	private static User checkUserExistInFile(String userName) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("users.txt"));
		String currentLine;
		
		while(scanner.hasNextLine()) {
			currentLine = scanner.nextLine();
			if(currentLine.contains(userName)){
				return getUser(userName);
			}
		}
		
		if(scanner !=null){
			scanner.close();
		}
		} catch (FileNotFoundException e) {
			return null;
		} 
		return null;
		
	}
	private static Artwork checkArtExistInFile(String title) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("artworks.txt"));
			String currentLine;
			
			while(scanner.hasNextLine()) {
				currentLine = scanner.nextLine();
				if(currentLine.contains(title)){
					return getArtwork(title);
				}
			}
			
			if(scanner !=null){
				scanner.close();
			}
		} catch (FileNotFoundException e) {
			return null;
		} 
		return null;
		
	}
	public static void populate(){
		File file = new File("users.txt");
		if(!file.isFile()){
			return;
		}
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		fileScan.useDelimiter(FILE_DELIMETER);
		String userName = "";
		String firstName = "";
		String lastName = "";
		int phoneNumber = -1;
		String address = "";
		while(fileScan.hasNextLine()){
			
			Scanner line = new Scanner(fileScan.nextLine());
			line.useDelimiter(":|\n|".concat(FILE_DELIMETER));
			while(line.hasNext()){
				String userField = line.next();
				String value = line.next();
				if (userField.equals("UserName")) {
//					userName = line.next();
					userName = value;
				} 
				if (userField.equals("First Name")) {
//					firstName = line.next();
					firstName = value;
				} 
				if (userField.equals("Last Name")) {
//					lastName = line.next();
					lastName = value;
				} 
				if (userField.equals("id")) {
				} 
				if (userField.equals("Phone Number")) {
//					phoneNumber = line.nextInt();
					phoneNumber = Integer.parseInt(value);
				} 
				if (userField.equals("Address")) {
//					address = line.next();
					address = value;
				}
			}
			//line.close();
		}
			if(getUser(userName) == null){
				users.add(new User(userName,firstName,lastName,String.valueOf(phoneNumber),address));			
			}
	}
}

