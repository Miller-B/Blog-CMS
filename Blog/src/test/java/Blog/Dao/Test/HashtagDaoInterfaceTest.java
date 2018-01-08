/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.Dao.HashtagDaoInterface;
import Blog.Dto.Hashtag;
import java.util.List;
import javax.inject.Inject;
import static javax.swing.text.html.HTML.Tag.HEAD;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author BMMil
 */
public class HashtagDaoInterfaceTest {

    @Inject
    private HashtagDaoInterface hashtagDao;

    private ApplicationContextHelper ach = new ApplicationContextHelper();

    public HashtagDaoInterfaceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        ApplicationContextHelper ach = new ApplicationContextHelper();
        TestingDataInjector dbInjection;
        ApplicationContext ctx = ach.getContext();
        dbInjection = ctx.getBean("dbInjection", TestingDataInjector.class);
        dbInjection.setUpDatabase();

    }

    @AfterClass
    public static void tearDownClass() {
        ApplicationContextHelper ach = new ApplicationContextHelper();
        TestingDataInjector dbInjection;
        ApplicationContext ctx = ach.getContext();
        dbInjection = ctx.getBean("dbInjection", TestingDataInjector.class);
        dbInjection.tearDownDatabase();

    }

    @Before
    public void setUp() {
        ApplicationContext ctx = ach.getContext();
        hashtagDao = ctx.getBean("hashtagDao", HashtagDaoInterface.class);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testCreateAndReadHashtag() {

        Hashtag hashtag1 = new Hashtag();

        hashtag1.setTagName("#thisisahashtag");

        Hashtag newHashtag = hashtagDao.createHashtag(hashtag1);

        Hashtag hashtagFromDb = hashtagDao.getHashtagById(hashtag1.getHashtagId());
        assertEquals(hashtagFromDb.getTagName(), "#thisisahashtag");

    }

    @Test
    public void testFindHashtag() {

        List<Hashtag> hashtags = hashtagDao.findAllHashtags(10, 0);
        assertTrue(hashtags.size() == 10);

        Hashtag list1 = hashtags.get(0);
        Hashtag list2 = hashtags.get(1);

        assertEquals((Integer) 1, list1.getHashtagId());
        assertEquals("#trashtag", list1.getTagName());
    }

    @Test
    public void testUpdateHashtag() {

        Hashtag hashtag1 = new Hashtag();

        hashtag1.setTagName("#stupidTags");

        hashtagDao.createHashtag(hashtag1);

        Hashtag hashtagFromDb = hashtagDao.getHashtagById(hashtag1.getHashtagId());
        assertEquals(hashtagFromDb.getTagName(), "#stupidTags");

        hashtagFromDb.setTagName("#moreStupidTags");

        hashtagDao.updateHashtag(hashtagFromDb);

        Hashtag updatedHashtag = hashtagDao.getHashtagById(hashtag1.getHashtagId());

        assertEquals(hashtagFromDb.getTagName(), "#moreStupidTags");
    }

    @Test
    public void testDeleteHashtag() throws Exception {

        Hashtag hashtag2 = new Hashtag();

        hashtag2.setTagName("#bestBeGone");

        hashtagDao.createHashtag(hashtag2);

        Hashtag hashtagFromDb = hashtagDao.getHashtagById(hashtag2.getHashtagId());
        assertEquals(hashtagFromDb, hashtag2);
        hashtagDao.deleteHashtag(hashtag2.getHashtagId());
        assertNull(hashtagDao.getHashtagById(hashtag2.getHashtagId()));
        
    }

}
