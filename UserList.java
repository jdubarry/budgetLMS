/**
 * This class is going to display the list of users
 * @author word.exe
 */
import java.util.ArrayList;
import java.util.UUID;

public class UserList {
    private ArrayList<User> users;
    private ArrayList<Author> authors;

    /**
     * This is going to keep a private list of all users
     */
    private UserList() {}

    /**
     * This is going to return a UserList
     */
    public static UserList getInstance() {
        UserList userList = new UserList();
        return userList;
    }


    /**
     * This is going to pull the user from a list based on their name
     * @param keyword the keyword is what you are trying to pull for
     * @return This is going to return the user
     */
    public User getUserByName(String keyword) {
        for(User user: users) {
            if(user.getUserName().equals(keyword)) {
                return user;
            }
        }
        return null;        
    }
    

    /**
     * This is going to pull the user from a list based on their name
     * @param userID UUID of the user to be returned
     * @return This is going to return the user
     */
    public User getUserByID(UUID userID) {
        for (User user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }
        return null;      
    }

    /**
     * This is going to pull the user from a list based on their name
     * @param authorID UUID of the user to be returned
     * @return This is going to return the user
     */
    public Author getAuthorByID(UUID authorID) {
        for (Author user : authors) {
            if (user.getUserID().equals(authorID)) {
                return user;
            }
        }
        return null;
    }

    /**
     * This is going to add the user to a list of users
     * @param user This is going to have the user's details
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * This adds in the author into a list
     * @param author is the author which is a user
     */
    public void addAuthor(Author author) {
        authors.add(author);
    }

    /**
     * This is going to delete the user from a list of users
     * @param user This is going to have the user's details
     */
    public void deleteUser(User user) {
        users.remove(user);
    }

    /**
     * This is going to allow the list to delete authors
     * @param author the writer or courses
     */
    public void deleteAuthor(Author author) {
        authors.remove(author);
    }

    /**
     * This is going to save the list of users
     */
    public void saveUsers() {
        DataWriter.writeUsers(users);
    }

    /**
     * This is going to allow the authors to save to be able to write
     */
    public void saveAuthors() {
        DataWriter.writeAuthors(authors);
    }

    /**
     * This is going to read the users from the json file
     */
    public void readUsersJSON() {
        this.users = DataLoader.loadUsers();
    }

    public void readAuthorsJson() {
        this.authors = DataLoader.loadAuthors();
    }

    public void readUsersCoursesJSON() {
        this.users = DataLoader.loadUsersCourseProgress(getInstance());
    }

    public void readAuthorsCoursesJSON() {
        this.authors = DataLoader.loadAuthorsCourseProgress(getInstance());
    }

    public ArrayList<User> getUsers() {
        return this.users;
    }

    public ArrayList<Author> getAuthors() {
        return this.authors;
    }
}
