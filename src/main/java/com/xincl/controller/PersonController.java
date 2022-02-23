package com.xincl.controller;

import com.xincl.model.Person;
import com.xincl.model.PersonReposity;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "person")
public class PersonController {

    @Autowired
    private PersonReposity personReposity;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping(path = "addPerson")
    public void addPerson(@RequestBody Person person){

        System.out.println(person.getId()+person.getName()+person.getAge());

        personReposity.save(person);
    }

    @DeleteMapping("/deletePerson")
    public String deletePerson(@RequestParam Long id){
        personReposity.deleteById(id);
        return "删除成功";
    }

    @DeleteMapping("/deletePerson2")
    public String deletePerson(@RequestParam String name){
        personReposity.deleteByName(name);
        return "删除成功";
    }

    @GetMapping("/getPerson/{name}")
    public Object getPerson(@PathVariable("name") String name){
        List<Person> person = personReposity.findByName(name);
        System.out.println(person);
        return person;
    }

    @RequestMapping("/getPerson2")
    public Object getPerson2(@RequestParam String name,@RequestParam int age){
        List<Person> person = personReposity.findByParam1(name,age);
        for (Person person1 : person) {
            System.out.println(person1.getId());
        }
        return person;
    }

    @GetMapping("/getPerson3")
    public Object getPerson3(@RequestParam String name){
        List<Map<String, Object>> result = personReposity.findAll1(name);
        for (Map<String, Object> map : result) {
            System.out.println(map);
        }
        return result;
    }

    @GetMapping("/getPerson4")
    @Transactional
    public Object getPerson4(@RequestParam String name){
        System.out.println(name);
        String sql = "select * from person where name = ?1";
        Query query = this.entityManager.createNativeQuery(sql);
        query.setParameter(1,name);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }


    @GetMapping("/getPerson45")
    @Transactional
    public Object getPerson5(HttpServletRequest request){
        String name = request.getAttribute("name")+"";
        System.out.println(name);
        String sql = "select * from person where name = ?1";
        Query query = this.entityManager.createNativeQuery(sql);
        query.setParameter(1,name);
        query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.getResultList();
    }

}
