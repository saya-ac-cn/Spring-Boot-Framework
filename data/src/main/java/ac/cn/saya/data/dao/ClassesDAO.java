package ac.cn.saya.data.dao;

import ac.cn.saya.data.entity.ClassesEntity;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: ClassesDAO
 * @ProjectName Spring-Boot-Framework
 * @Description: TODO
 * @Author liunengkai
 * @Date: 2020-10-14 23:20
 * @Description:
 */
@Repository
public interface ClassesDAO extends JpaRepository<ClassesEntity,Integer> {

    @Transactional
    @Modifying
    @Query(value="insert into t_classes(classes_name,major_id) values(:className,:majorId)",nativeQuery = true)
    public int save(@Param("className") String className,@Param("majorId") int majorId);


}
