package assignment5.be;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author smsj
 */
public class Student extends Person
{

    private List<GradeInfo> gradeReport;
    private String education;

    public Student(int id, String name, String education)
    {
        super(id, name);
        this.education = education;
        gradeReport = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public List<GradeInfo> getGradeReport()
    {
        return gradeReport;
    }

    /**
     *
     * @return
     */
    public String getEducation()
    {
        return education;
    }

    /**
     *
     * @return
     */
    public double getAverageGrade()
    {
        double avg = 0.0;
        double sum = 0.0;

        for (GradeInfo gradeInfo : gradeReport)
        {
            sum += gradeInfo.getGrade();
        }
        avg = sum / gradeReport.size();

        return avg;
    }

    /**
     *
     * @param subject
     * @return
     */
    public int getGrade(String subject)
    {
        for (GradeInfo gradeInfo : gradeReport)
        {
            if (subject.equalsIgnoreCase(gradeInfo.getSubject()))
            {
                return gradeInfo.getGrade();
            }
        }
        return -1;
    }

    /**
     *
     * @param grade
     */
    public void addGrade(GradeInfo grade)
    {
        gradeReport.add(grade);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString() + " " +
                education + " " +
                getAverageGrade();
    }
}