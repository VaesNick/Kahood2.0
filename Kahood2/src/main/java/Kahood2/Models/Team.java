package Kahood2.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Team")
public class Team {
    @Id
    @Column(name = "teamId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "courseId")
    private Long courseId;
    //@Column(name = "studentList")
    //private List<Student> studentList;
    @Column(name = "teamName")
    private String teamName;
    @Column(name = "maxSize")
    private int maxTeamSize;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

   /* public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }*/

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getMaxTeamSize() {
        return maxTeamSize;
    }

    public void setMaxTeamSize(int maxTeamSize) {
        this.maxTeamSize = maxTeamSize;
    }
}
