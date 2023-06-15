package com.example.phase2.model.adminTest;

import com.example.phase2.model.userAccount.Admin;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AdminTest {

    @Test
    void getAdminTest() {

        Admin expected = Admin.getAdmin("admin","ali@gmail.com","09133287220","admin");
        Admin actual = Admin.getAdmin("","","","");

        Assertions.assertEquals(expected,actual);
    }
}