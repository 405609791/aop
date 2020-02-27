package fun.codefarmer.aop.service;

import org.springframework.stereotype.Service;

/**
 * @ @ClassName UserService
 * @ Descriotion TODO
 * @ Author admin
 * @ Date 2020/2/27 16:41
 **/
@Service
public class UserService {

    public String getUsernameById(Integer id) {
        System.out.println("getUsernameById");
        return "codefarmer";
    }

    public void deleteUserById(Integer id) {
        System.out.println("deleteUserById");
    }
}
