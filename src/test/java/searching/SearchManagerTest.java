package searching;

import data_access_storage.RequestModel;
import data_access_storage.UserRepo;
import data_access_storage.UserRepoManager;
import entities.Gender;
import entities.Hobbies;
import entities.User;
import entities.UserAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import searching_system.*;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SearcherManagerTest {

    private SearcherManager interactor;
    private static final int jimmyNumRequest = 6;
    private static final int DavidNumRequest = 0;


    @BeforeEach
    void setUp() throws IOException {
        File csvFile = new File("src/main/resources/interactorTestFile.csv");
        UserRepoManager repo = new UserRepo(csvFile);
        SearcherOutputBoundary output = new SearchUIPresenter();
        SearchRequestModel requestModel = new SearchRequestModel("Life Science", "Name1");
        interactor = new SearcherManager(output, requestModel, repo);
    }

    @Test
    void testCreateSuccess(){
        SearchRequestModel rm = new SearchRequestModel("Life Science",
                "Name1");
        SearchResponseModel rq = interactor.create(rm);
        assertEquals( "Life Science",
                rq.getSearchedUsers());

    }

    @Test
    void testCreateFailure() {
        SearchRequestModel rm = new SearchRequestModel("CS",
                "Name2");
        SearchResponseModel rq = interactor.create(rm);
        assertEquals( "Name2",
                rq.getSearchedUsers());
    }

}