package com.service;

import com.jdbc.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import javax.annotation.Resource;

/*
 * �̳л�����в���
 */
public class Demo09 extends BaseCase {
    @Autowired
    private BaseDao baseDao;
    private int n = 3;

    @Test(description = "��ѯ")
    public void testNo1() {
        String name = baseDao.queryForObject("chat.message", "10");
        System.out.println("the name is" + name);
    }
}
