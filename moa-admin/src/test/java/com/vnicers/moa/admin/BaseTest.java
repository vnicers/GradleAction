package com.vnicers.moa.admin;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class BaseTest {

    @Test
    public void testJunit(){
        log.info("dd弟弟带饭");
        Assert.assertEquals(1,1);
    }
}
