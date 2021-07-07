package com.miteng.strive.dao;

import com.miteng.strive.pojo.Person;

public interface PersonMapper {
    Person findPersonById(Integer id);

    int updatePerson(String name, Integer age, Integer id);

    int deletePerson(Integer id);

    int addPerson(Person person);
}
