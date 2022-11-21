package searching;



import entities.UserAccount;
import entities.User;
import entities.Hobbies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import searching_system.SearchResponseModel;
import searching_system.SearchUIPresenter;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchUIPresenterTest {
    private SearchUIPresenter sup;

    private ArrayList<UserAccount> usersForTest;

    @BeforeEach
    void setUp(){
        sup = new SearchUIPresenter();
        User userA = new User("A", entities.Gender.FEMALE, 18,
                180, "Computer Science", Hobbies.FOOD,
                "\" Hello, This is A \"", entities.Gender.MALE);
        User userB = new User("B", entities.Gender.MALE, 18,
                180, "Life Science", Hobbies.FOOD,
                "\" Hello, This is B \"", entities.Gender.FEMALE);
        UserAccount userAccountA = new UserAccount("a@mail.utoronto.ca",
                "aspassword", userA);
        UserAccount userAccountB = new UserAccount("b@mail.utoronto.ca",
                "bspassword", userB);
        ArrayList<UserAccount> usersForTest = new ArrayList<UserAccount>();
        usersForTest.add(userAccountA);
        usersForTest.add(userAccountB);
    }

    @Test
    void prepareView() {
        SearchResponseModel rm  = new SearchResponseModel(usersForTest);
        SearchResponseModel result =  sup.prepareView(rm);
        assertTrue(result == rm);
    }
}
