package assignment5.be;

/**
 *
 */
public class GradeInfo
{

    private final String subject;
    private final int grade;

    /**
     *
     * @param subject
     * @param grade
     */
    public GradeInfo(String subject, int grade)
    {
        this.subject = subject;
        this.grade = grade;
    }

    /**
     * Get the value of grade
     *
     * @return the value of grade
     */
    public int getGrade()
    {
        return grade;
    }

    /**
     * Get the value of subject
     *
     * @return the value of subject
     */
    public String getSubject()
    {
        return subject;
    }

    @Override
    public String toString()
    {
        return "assignment5.be.GradeInfo{" + "subject=" + subject + ", grade=" + grade + '}';
    }
}