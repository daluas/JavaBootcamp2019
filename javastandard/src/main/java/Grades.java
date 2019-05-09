import java.io.Serializable;

public class Grades implements Serializable {
    private int score;
    private String disciplineName;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public Grades(int score, String disciplineName) {
        this.score = score;
        this.disciplineName = disciplineName;
    }

    @Override
    public String toString() {
        return "Grades{" +
                "score=" + score +
                ", disciplineName='" + disciplineName + '\'' +
                '}';
    }
}
