package com.xincl.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface PersonReposity extends JpaRepository<Person,Long> {//<实体类，ID类型>
    //自定义字段进行简单查询
    List<Person> findByName(String name);

    //自定义sql进行查询。value编写sql，nativeQuery是否采取本地查询-原生sql（即放到数据库中可以执行的）
    //如果没有nativeQuery = true，说明不指向真正的数据库，而是指向实体类和实体类中的属性名称
    @Query(value = "SELECT * FROM person WHERE name=?1 AND AGE=?2",nativeQuery = true)
    List<Person> findByParam1(String name,int age);

    @Modifying
    @Transactional
    @Query(value = "delete from Person where name=:name")
    void deleteByName(@Param("name") String name);

    @Query(value = "select p.id,p.name,a.pname,a.pversion from person p left join phone a on p.id=a.pid where name=?1",nativeQuery = true)
    List<Map<String,Object>> findAll1(String name);


}
