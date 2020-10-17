package ac.cn.saya.data.entity;

import javax.persistence.*;

/**
 * 专业实体-表
 */

@Entity
@Table(name = "t_major")
public class MajorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_id",nullable=false,length=11)
    private int majorId;

    @Column(name = "major_name",nullable=false,length=50)
    private String majorName;

    @Column(name = "college_id",nullable=false,length=11)
    private int collegeId;

    @Column(name = "category",nullable=false,length=50)
    private String category;

    @Column(name = "school_system",nullable=false,length=50)
    private String schoolSystem;

    @Column(name = "major_level",nullable=false,length=50)
    private String majorLevel;

    @Column(name = "major_profile",nullable=false,length=50)
    private String majorProfile;


    public MajorEntity() {

    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajor(int majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSchoolSystem() {
        return schoolSystem;
    }

    public void setSchoolSystem(String schoolSystem) {
        this.schoolSystem = schoolSystem;
    }

    public String getMajorLevel() {
        return majorLevel;
    }

    public void setMajorLevel(String majorLevel) {
        this.majorLevel = majorLevel;
    }

    public String getMajorProfile() {
        return majorProfile;
    }

    public void setMajorProfile(String majorProfile) {
        this.majorProfile = majorProfile;
    }

    @Override
    public String toString() {
        return "MajorEntity:{" +
                "majorId:" + majorId +
                ", majorName:'" + majorName + '\'' +
                ", collegeId:" + collegeId +
                ", category:'" + category + '\'' +
                ", schoolSystem:'" + schoolSystem + '\'' +
                ", majorLevel:'" + majorLevel + '\'' +
                ", majorProfile:'" + majorProfile + '\'' +
                '}';
    }
}
