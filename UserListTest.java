import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class UserListTest {
    
    private UserList users = UserList.getInstance();
    private ArrayList<User> userList = users.getUsers();
    private UserList authors = UserList.getInstance();
    private ArrayList<Author> authorList = authors.getAuthors();

    @BeforeEach
    public void setup() {
        userList.clear();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String dateOfBirth = "10/12/2002";
        Date dob = new Date();
        try {
            dob = dateFormat.parse(dateOfBirth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        User tempUser = new User("jimmy", "johnson","jjohnson", "password",  dob , "874-000-3440", "jimmyj@outlook.com");
        userList.add(tempUser);

        Author tempAuthor = new Author("samantha", "jackson","SJACK12", "sjack",  dob , "980-234-2234", "SJACKROCKS!@gmail.com");
        authorList.add(tempAuthor);

        DataWriter.writeUsers(userList);
        DataWriter.writeAuthors(authorList);
        
    }

    @AfterEach
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.writeUsers(userList);
        UserList.getInstance().getAuthors().clear();
        DataWriter.writeAuthors(authorList);
    }

    @Test
    void testHaveUserIsValid() {
        User user = users.getUserByName("jjohnson");
        assertEquals("jjohnson", user.getUserName());
    }

    @Test
    void testHaveAuthorIsValid() {
        Author author = authors.geAuthorByName("SJACK12");
        assertEquals("SJACK12", author.getUserName());
    }
}

