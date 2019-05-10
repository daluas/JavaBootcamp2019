public class Grade {
    private int score;
    private String subjectName;

    public Grade(int score, String subjectName){
        this.score = score;
        this.subjectName = subjectName;
    }

    public Grade(){
        this.score = 0;
        this.subjectName = "";
    }

    public int getScore() {
        return score;
    }

    public String getsubjectName() {
        return subjectName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setsubjectName(String disciplineName) {
        this.subjectName = disciplineName;
    }
}
