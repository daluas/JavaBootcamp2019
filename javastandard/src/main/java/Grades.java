public class Grades {
    private int score;
    private String disciplineName;

    public Grades(int score, String disciplineName) {
        this.score = score;
        this.disciplineName = disciplineName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public int getScore() {
        return score;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    @Override
    public String toString() {
        return "Grade{score: " + Integer.toString(score) + " disciplineName: " + disciplineName + '}';
    }
}
