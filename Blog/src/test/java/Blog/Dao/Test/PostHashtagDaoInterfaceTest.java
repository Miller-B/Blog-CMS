/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.Dao.PostDaoInterface;
import Blog.Dao.PostHashtagDaoInterface;
import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Dto.PostHashtag;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author EJB Laptop
 */
public class PostHashtagDaoInterfaceTest {
    
    @Inject
    private PostHashtagDaoInterface postHashtagDao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();

    
    public PostHashtagDaoInterfaceTest() {
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

        postHashtagDao = ctx.getBean("postHashtagDao", PostHashtagDaoInterface.class);        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPostHashtag method, of class PostHashtagDaoInterface.
     */
    @Test
    public void testCreatePostHashtag() {
        PostHashtag testPostHashtag = new PostHashtag();
        Post testPost = new Post();
        testPost.setPostId(5);
        Hashtag testHashtag = new Hashtag();
        testHashtag.setHashtagId(5);
        testPostHashtag.setPost(testPost);
        testPostHashtag.setHashtag(testHashtag);
        postHashtagDao.createPostHashtag(testPostHashtag);
        PostHashtag confirmPostHashtag = postHashtagDao.getPostHashtagById(testPostHashtag.getPostHashtagId());
        assertEquals(testPostHashtag.getPostHashtagId(), confirmPostHashtag.getPostHashtagId());
    }

    /**
     * Test of getPostHashtagById method, of class PostHashtagDaoInterface.
     */
    @Test
    public void testGetPostHashtagById() {
        PostHashtag testPostHashtag = new PostHashtag();
        testPostHashtag.setPostHashtagId(1);
        PostHashtag confirmPostHashtag = postHashtagDao.getPostHashtagById(1);
        assertEquals(testPostHashtag.getPostHashtagId(), confirmPostHashtag.getPostHashtagId());
    }

    /**
     * Test of findAllPostHashtags method, of class PostHashtagDaoInterface.
     */
    @Test
    public void testFindAllPostHashtags() {
        List<PostHashtag> postHashtagList = postHashtagDao.findAllPostHashtags(Integer.MAX_VALUE, 0);
        assertEquals(postHashtagList.size(), 10);
    }

    /**
     * Test of updatePostHashtag method, of class PostHashtagDaoInterface.
     */
    @Test
    public void testUpdatePostHashtag() {
        PostHashtag testPostHashtag = new PostHashtag();
        Post newPost = new Post();
        newPost.setPostId(1);
        Hashtag newHashtag = new Hashtag();
        newHashtag.setHashtagId(1);
        testPostHashtag.setPost(newPost);
        testPostHashtag.setHashtag(newHashtag);
        PostHashtag updatePostHashtag = postHashtagDao.createPostHashtag(testPostHashtag);       
        Hashtag hashtag = new Hashtag();
        hashtag.setHashtagId(2);
        updatePostHashtag.setHashtag(hashtag);
        postHashtagDao.updatePostHashtag(updatePostHashtag);
        assertTrue(updatePostHashtag.getHashtag().getHashtagId() == 2);
    }

    /**
     * Test of deletePostHashtag method, of class PostHashtagDaoInterface.
     */
    @Test
    public void testDeletePostHashtag() throws Exception {
        try {
           postHashtagDao.deletePostHashtag(5);
            assertNull(postHashtagDao.getPostHashtagById(5)); 
        }   catch (Exception e) {
        }   
    }

    /**
     * Test of findAllPostHashtagsByPost method, of class PostHashtagDaoInterface.
     */
    @Test
    public void testFindAllPostHashtagsByPost() {
        Post post = new Post();
        post.setPostId(2);
        List<PostHashtag> postsByPost = postHashtagDao.findAllPostHashtagsByPost(post, Integer.MAX_VALUE, 0);
        assertEquals(postsByPost.size(), 2);
    }

    /**
     * Test of findAllPostHashtagsByHashtag method, of class PostHashtagDaoInterface.
     */
    @Test
    public void testFindAllPostHashtagsByHashtag() {
        Hashtag hashtag = new Hashtag();
        hashtag.setHashtagId(5);
        List<PostHashtag> postsByHashtag = postHashtagDao.findAllPostHashtagsByHashtag(hashtag, Integer.MAX_VALUE, 0);
        assertEquals(postsByHashtag.size(), 2);
    }
    
}
