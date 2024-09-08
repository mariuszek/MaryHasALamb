package org.mariusz.utils;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CleanerTest {

    @Before
    public void setup(){
    }
    @Test
    public void testCleaner(){
        Parser parser = new Parser(null);
        assertEquals(parser.clearToken("toke'n"), "toke'n");
        assertEquals(parser.clearToken("(token"), "token");
        assertEquals(parser.clearToken("(token)"), "token");
        assertEquals(parser.clearToken("你这肮脏的掠夺者!"), "你这肮脏的掠夺者");
        assertEquals(parser.clearToken("token."), "token");
        assertEquals(parser.clearToken("token!"), "token");
        assertEquals(parser.clearToken("token.."), "token");

    }

}