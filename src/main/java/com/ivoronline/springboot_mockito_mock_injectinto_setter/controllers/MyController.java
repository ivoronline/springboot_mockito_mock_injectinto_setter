package com.ivoronline.springboot_mockito_mock_injectinto_setter.controllers;

import com.ivoronline.springboot_mockito_mock_injectinto_setter.entities.Person;
import com.ivoronline.springboot_mockito_mock_injectinto_setter.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  //PROPERTIES
  @Autowired PersonRepository personRepository;

  //SETTER
  @Autowired
  public void setPersonRepository(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  //ENDPOINT
  @ResponseBody
  @RequestMapping("/GetPerson")
  public String getPerson(@RequestParam Integer id) {

    //GET PERSON
    Person person = personRepository.getPersonById(1);

    //GREET PERSON
    return "Hello " + person.name;

  }

}
