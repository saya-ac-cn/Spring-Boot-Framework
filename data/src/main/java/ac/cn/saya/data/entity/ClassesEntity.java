package ac.cn.saya.data.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

/**
 * 班级实体-表
 */

@Entity
@Table(name="t_classes")
public class ClassesEntity {

    @Id    //主键id
    @GeneratedValue(strategy=GenerationType.IDENTITY)//主键生成策略
    @Column(name="classes_id",nullable=false,length=11)
    private int classesId;


    @Column(name="classes_name",nullable=false,length=50)
    private String classesName;

    @ManyToOne(cascade = CascadeType.PERSIST)	//表示多方
    @JoinColumn(name ="major_id")	//维护一个外键，外键在ClassesEntity一侧
    private MajorEntity major;


    public ClassesEntity() {

    }

    public ClassesEntity(int classesId, String classesName) {
        classesId = classesId;
        classesName = classesName;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public MajorEntity getMajor() {
        return major;
    }

    public void setMajor(MajorEntity major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "ClassesEntity={classesId:" + classesId + ", major:" + major.toString() + ", classesName:" + classesName + "}";
    }

}
