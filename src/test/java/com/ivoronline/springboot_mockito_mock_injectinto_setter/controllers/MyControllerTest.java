package com.ivoronline.springboot_mockito_mock_injectinto_setter.controllers;

import com.ivoronline.springboot_mockito_mock_injectinto_setter.entities.Person;
import com.ivoronline.springboot_mockito_mock_injectinto_setter.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MyControllerTest {

  //MOCK DEPENDENCY CLASS
  @Mock PersonRepository personRepository;

  @Test
  void getPerson() {

    //MOCK REPOSITORY'S METHOD: getPersonById(1)
    when(personRepository.getPersonById(1)).thenReturn(new Person(1, "Susan", 50));

    //INSTANTIATE CONTROLLER. SET PROPERTY TO MOCKED INSTANCE.
    MyController myController = new MyController();
                 myController.setPersonRepository(personRepository);

    //TEST CONTROLLER'S ENDPOINT
    String result = myController.getPerson(1);

    //TEST RESULT
    assertEquals("Hello Susan", result);

  }

}



