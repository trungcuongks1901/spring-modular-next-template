package com.example.app.modules.masterdata.office;

import com.example.app.modules.masterdata.office.service.OfficeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class OfficeServiceTest {
    @Autowired
    private OfficeService officeService;

    @Test
    void should_have_seed_offices() {
        assertFalse(officeService.list().isEmpty());
    }
}
