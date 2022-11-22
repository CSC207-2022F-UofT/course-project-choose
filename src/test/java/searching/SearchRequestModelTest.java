package searching;

import searching_system.SearchRequestModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchRequestModelTest {

    private SearchRequestModel searchRequestModel;
    private SearchRequestModel searchRequestModelDefault;

    @BeforeEach
    void setUp(){
        searchRequestModel = new SearchRequestModel("Life Science","Name1");
        searchRequestModelDefault = new SearchRequestModel("Name2");
    }

    @Test
    void getKeyword() {

        assertEquals(searchRequestModel.getKeyword(),"Name1");
        assertEquals(searchRequestModelDefault.getKeyword(),"Name2");
    }

    @Test
    void getProgram() {
        assertEquals(searchRequestModel.getProgram(), "Life Science");
    }

}