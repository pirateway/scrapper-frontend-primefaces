package ru.kravchenko.sb;

import org.junit.Ignore;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.kravchenko.sb.api.repository.UserRepository;
import ru.kravchenko.sb.model.entity.User;

/**
 * @author Roman Kravchenko
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void insertAnyUsers() {
        for (int i = 0; i < 2; i++) {
            userRepository.save(new User());
        }
    }

    @Test
    public void dellAll(){
        userRepository.deleteAll();
    }

}
