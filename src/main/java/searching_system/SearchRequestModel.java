package searching_system;

public class SearchRequestModel {
    private String keyword;
    public SearchRequestModel(String keyword){
        this.keyword = keyword;
    }
    public String getKeyword(){
        return this.keyword;
    }
}
