public class Grades
{
    private String disciplineName;
    private double score;
    public Grades(String name,double scor)
    {
        disciplineName = name;
        score = scor;
    }
    public double getScore()
    {
        return score;
    }
    public String getDisciplineName()
    {
        return disciplineName;
    }
    public String toString()
    {
        return " Materia = "+disciplineName+" are nota "+score;
    }
}
