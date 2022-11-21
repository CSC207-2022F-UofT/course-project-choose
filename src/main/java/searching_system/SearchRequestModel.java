package searching_system;

public class SearchRequestModel {
    private String keyword;
    private String program;
    public SearchRequestModel(String keyword){
        this.keyword = keyword;
    }

    public SearchRequestModel(String program, String keyword){
        this.program = program;
        this.keyword = keyword;
    }

    public String getKeyword(){
        return this.keyword;
    }
    public String getProgram() {
        return program;
    }
}
