/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.CommandModel.HashtagCommandModel;
import Blog.Dto.Hashtag;
import Blog.Service.BlogServiceException;
import Blog.Service.HashtagServiceInterface;
import Blog.ViewModel.HashtagViewModel;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author BMMil
 */
public class HashtagServiceInterfaceTest {

    @Inject
    private HashtagServiceInterface hashtagService;

    private ApplicationContextHelper ach = new ApplicationContextHelper();

    public HashtagServiceInterfaceTest() {
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
        hashtagService = ctx.getBean("hashtagService", HashtagServiceInterface.class);

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testCreateAndReadHashtag(){

        Hashtag hashtag1 = new Hashtag();
        hashtag1.setTagName("#thisisahashtag");
        Hashtag newHashtag = hashtagService.createHashtag(hashtag1);
        Hashtag hashtagFromDb = hashtagService.getHashtagById(hashtag1.getHashtagId());
        assertEquals(hashtagFromDb.getTagName(), "#thisisahashtag");
        
    }

    @Test
    public void testFindHashtag() {

        List<Hashtag> hashtags = hashtagService.findAllHashtags(10, 0);
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
        hashtagService.createHashtag(hashtag1);
        Hashtag hashtagFromDb = hashtagService.getHashtagById(hashtag1.getHashtagId());
        assertEquals(hashtagFromDb.getTagName(), "#stupidTags");
        hashtagFromDb.setTagName("#moreStupidTags");

        hashtagService.updateHashtag(hashtagFromDb);

        Hashtag updatedHashtag = hashtagService.getHashtagById(hashtag1.getHashtagId());

        assertEquals(hashtagFromDb.getTagName(), "#moreStupidTags");
    }

    @Test
    public void testDeleteHashtag() throws BlogServiceException {

        Hashtag hashtag2 = new Hashtag();
        hashtag2.setTagName("#bestBeGone");
        hashtagService.createHashtag(hashtag2);
        Hashtag hashtagFromDb = hashtagService.getHashtagById(hashtag2.getHashtagId());
        assertEquals(hashtagFromDb, hashtag2);
        hashtagService.deleteHashtag(hashtag2.getHashtagId());
        assertNull(hashtagService.getHashtagById(hashtag2.getHashtagId()));

    }
    
    @Test
    public void testBuildHashtagViewModelFromHashtag() {
        
        Hashtag hashtag = new Hashtag();
        hashtag.setTagName("Testtag");
        
        hashtag = hashtagService.createHashtag(hashtag);
        
        HashtagViewModel hvm = hashtagService.buildHashtagViewModelFromHashtag(hashtag, 10, 0);
        
        assertTrue((int)hashtag.getHashtagId() == (int)hvm.getSelectedHashtag().getHashtagId());
        assertTrue(hashtag.getTagName().equals(hvm.getSelectedHashtag().getTagName()));                                             
        
    }
 
    @Test
    public void testBuildHashtagFromHashtagCommandModel() {
        
        HashtagCommandModel hcm = new HashtagCommandModel();
        hcm.setTagName("Testtag");
        
        Hashtag hashtag = hashtagService.buildHashtagFromHashtagCommandModel(hcm);
        
        assertTrue(hashtag.getTagName().equals(hcm.getTagName()));
        
    }    
    
}
