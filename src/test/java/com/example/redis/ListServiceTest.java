package com.example.redis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zc.lin on 2017/3/28.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ListServiceTest {

    @Resource
    private ListService listService;

    @Before
    public void push() {
        System.out.println("------------ START METHOD TEST--------------");
        this.listService.del("ls", "ls1");
        this.listService.leftPush("ls1", "1");
        this.listService.leftPush("ls1", "2");
        this.listService.leftPush("ls1", "3");
        this.listService.rightPush("ls", "4");
        this.listService.rightPush("ls", "5");
        this.listService.rightPush("ls", "6");
        System.out.println("init list = " + this.listService.range("ls", 0, 2));
        System.out.println("init list1 = " + this.listService.range("ls1", 0, 2));
        System.out.println("testing ===========================");
    }

    @After
    public void delete() {
        this.listService.del("ls", "ls1");
        System.out.println("remove [list,list1] ");
        System.out.println("------------ END METHOD TEST--------------");
    }

    @Test
    public void leftPush() throws Exception {
    }

    @Test
    public void leftPop() throws Exception {
        Object obj = this.listService.leftPop("ls1");
        System.out.println(String.valueOf(obj));
        System.out.println(this.listService.range("ls1", 0, this.listService.length("ls1")));
    }

    @Test
    public void rightPush() throws Exception {
    }

    @Test
    public void rightPop() throws Exception {
        Object obj = this.listService.rightPop("ls");
        System.out.println(String.valueOf(obj));
        System.out.println(this.listService.range("ls", 0, this.listService.length("ls")));
    }

    @Test
    public void length() throws Exception {
        long len = this.listService.length("ls");
        long len1 = this.listService.length("ls1");
        Assert.assertTrue(len == 3);
        Assert.assertTrue(len1 == 3);
    }

    @Test
    public void range() throws Exception {
        List<?> left1 = this.listService.range("ls1", 0, 0);
        List<?> left2 = this.listService.range("ls1", 1, 1);
        List<?> left3 = this.listService.range("ls1", 2, 2);
        List<?> right1 = this.listService.range("ls", 0, 0);
        List<?> right2 = this.listService.range("ls", 1, 1);
        List<?> right3 = this.listService.range("ls", 2, 2);
        Assert.assertTrue(left1.get(0).equals("3"));
        Assert.assertTrue(left2.get(0).equals("2"));
        Assert.assertTrue(left3.get(0).equals("1"));
        Assert.assertTrue(right1.get(0).equals("4"));
        Assert.assertTrue(right2.get(0).equals("5"));
        Assert.assertTrue(right3.get(0).equals("6"));
    }

    @Test
    public void remove() throws Exception {
        this.listService.remove("ls", 0, "5");
        List<?> objects = this.listService.range("ls", 0, 2);
        Assert.assertTrue(objects.size() == 2);
    }

    @Test
    public void index() throws Exception {
        final Object index = this.listService.index("ls", 0);
        Assert.assertTrue(index.equals("4"));
        final Object index1 = this.listService.index("ls1", 1);
        Assert.assertTrue(index1.equals("2"));
    }

    @Test
    public void set() throws Exception {
        this.listService.set("ls", 0, "3");
    }

    @Test
    public void trim() throws Exception {
        this.listService.trim("ls", 0, 0);
        final Long length = this.listService.length("ls");
        Assert.assertTrue(length == 1L);
        this.listService.trim("ls1", 1, 2);
        final Long length1 = this.listService.length("ls1");
        Assert.assertTrue(length1 == 2L);
    }

    @Test
    public void del() {
        this.listService.del("ls", "ls1");
        this.listService.del("ls");
        this.listService.del();
    }
}