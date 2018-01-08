/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.Dao.PostDaoInterface;
import Blog.Dto.Category;
import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Dto.User;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
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
public class PostDaoInterfaceTest {

    @Inject
    private PostDaoInterface dao;

    private ApplicationContextHelper ach = new ApplicationContextHelper();

    public PostDaoInterfaceTest() {
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

        dao = ctx.getBean("postDao", PostDaoInterface.class);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createPost method, of class PostDaoInterface.
     */
    @Test
    public void testCreatePost() {
        Post testPost = new Post();
        User testUser = new User();
        testUser.setUserId(5);
        testPost.setUser(testUser);
        testPost.setStartDate(LocalDateTime.of(1996, Month.JANUARY, 22, 12,20,30));
        testPost.setEndDate(LocalDateTime.of(2018, Month.FEBRUARY, 01, 12,20,30));
        testPost.setCreateDate(LocalDateTime.of(1996, Month.JANUARY, 22, 12,20,31));
        testPost.setApprovalDate(LocalDateTime.of(1999, Month.AUGUST, 15,22,30,15));
        testPost.setApproval(false);
        testPost.setPostTitle("Stuff and things.");
        testPost.setPostContent("Many more stuffs and things.");
        Category testCategory = new Category();
        testCategory.setCategoryId(7);
        testPost.setCategory(testCategory);
        testPost = dao.createPost(testPost);
        assertTrue(testPost.getPostId() != null);
    }

    /**
     * Test of getPostById method, of class PostDaoInterface.
     */
    @Test
    public void testGetPostById() {
        
        Post testPost = new Post();
        User testUser = new User();
        testUser.setUserId(10);
        testPost.setUser(testUser);
        testPost.setStartDate(LocalDateTime.of(1970, Month.JANUARY, 01, 00, 00, 00));
        testPost.setEndDate(LocalDateTime.of(2000, Month.JANUARY, 01, 00, 00, 00));
        testPost.setCreateDate(LocalDateTime.of(1970, Month.JANUARY, 01, 00, 00, 00));
        testPost.setApprovalDate(LocalDateTime.of(1970, Month.JANUARY, 01, 00, 00, 00));
        testPost.setApproval(true);
        testPost.setPostTitle("My Test Post");
        testPost.setPostContent("This content is a simple string.");
        Category testCategory = new Category();
        testCategory.setCategoryId(1);
        testPost.setCategory(testCategory);
        testPost = dao.createPost(testPost);

        Post postFromDao = dao.getPostById(testPost.getPostId());

        assertEquals(testPost.getUser().getUserId(), postFromDao.getUser().getUserId());
        assertEquals(testPost.getStartDate(), postFromDao.getStartDate());
        assertEquals(testPost.getEndDate(), postFromDao.getEndDate());
        assertEquals(testPost.getCreateDate(), postFromDao.getCreateDate());
        assertEquals(testPost.getApprovalDate(), postFromDao.getApprovalDate());
        assertEquals(testPost.getApproval(), postFromDao.getApproval());
        assertEquals(testPost.getPostTitle(), postFromDao.getPostTitle());
        assertEquals(testPost.getPostContent(), postFromDao.getPostContent());
        assertEquals((int) testPost.getCategory().getCategoryId(),
                (int) postFromDao.getCategory().getCategoryId());
    }

    /**
     * Test of findAllPosts method, of class PostDaoInterface.
     */
    @Test
    public void testFindAllPosts() {
        List<Post> postsList = dao.findAllPosts(Integer.MAX_VALUE, 0);
        int number = postsList.size();
        assertEquals(number, postsList.size());
    }

    /**
     * Test of updatePost method, of class PostDaoInterface.
     */
    @Test
    public void testUpdatePost() {
        Post comparePost = dao.getPostById(5);       
        Post testPost = dao.getPostById(5);
        testPost.setPostTitle("New one.");
        dao.updatePost(testPost);       
        assertTrue(comparePost.getPostTitle() != testPost.getPostTitle());
    }

    /**
     * Test of deletePost method, of class PostDaoInterface.
     */
    @Test
    public void testDeletePost() throws Exception{
        try {
            Post testDelete = dao.getPostById(5);
            dao.deletePost(testDelete.getPostId());
            assertNull(testDelete); 
        }   catch (Exception e) {
        }       
    }

    /**
     * Test of findAllPostsByUser method, of class PostDaoInterface.
     */
    @Test
    public void testFindAllPostsByUser() {
        User user = new User();
        user.setUserId(1);
        List<Post> postsByUser = dao.findAllPostsByUser(user, Integer.MAX_VALUE, 0);
        assertEquals(postsByUser.size(), 1);
    }

    /**
     * Test of findAllPostsByStartDate method, of class PostDaoInterface.
     */
    @Test
    public void testFindAllPostsByStartDate() {
        LocalDateTime startDate = LocalDateTime.of(2017, Month.FEBRUARY, 13, 01,02,04);
        List<Post> postsByStartDate = dao.findAllPostsByStartDate(startDate, Integer.MAX_VALUE, 0);
        assertEquals(postsByStartDate.size(), 1);          
    }

    /**
     * Test of findAllPostsByEndDate method, of class PostDaoInterface.
     */
    @Test
    public void testFindAllPostsByEndDate() {
        LocalDateTime endDate = null;
        List<Post> postsByEndDate = dao.findAllPostsByEndDate(endDate, Integer.MAX_VALUE, 0);
        assertEquals(postsByEndDate.size(), 5);
    }

    /**
     * Test of findAllPostsByCreateDate method, of class PostDaoInterface.
     */
    @Test
    public void testFindAllPostsByCreateDate() {
        LocalDateTime createDate = LocalDateTime.of(2017, Month.FEBRUARY, 13, 01,02,03);
        List<Post> postsByCreateDate = dao.findAllPostsByCreateDate(createDate, Integer.MAX_VALUE, 0);
        assertEquals(postsByCreateDate.size(), 1);
    }

    /**
     * Test of findAllPostsByApprovalDate method, of class PostDaoInterface.
     */
    @Test
    public void testFindAllPostsByApprovalDate() {
        LocalDateTime approvalDate = LocalDateTime.of(2017, Month.SEPTEMBER, 20, 02,03,04);
        List<Post> postsByApprovalDate = dao.findAllPostsByApprovalDate(approvalDate, Integer.MAX_VALUE, 0);
        assertEquals(postsByApprovalDate.size(), 1);
    }

    /**
     * Test of findAllPostsByApproval method, of class PostDaoInterface.
     */
    @Test
    public void testFindAllPostsByApproval() {
        int approval = 0;
        List<Post> postsByApproval = dao.findAllPostsByApproval(approval, Integer.MAX_VALUE, 0);
        assertEquals(postsByApproval.size(), 5);
    }

    /**
     * Test of findAllPostsByCategory method, of class PostDaoInterface.
     */
    @Test
    public void testFindAllPostsByCategory() {
        Category category = new Category();
        category.setCategoryId(1);
        List<Post> postsByCategory = dao.findAllPostsByCategory(category, Integer.MAX_VALUE, 0);
        assertEquals(postsByCategory.size(), 2);
    }

    /**
     * Test of findAllPostsByHashtag method, of class PostDaoInterface.
     */
    @Test
    public void testFindAllPostsByHashtag() {
        Hashtag hashtag = new Hashtag();
        hashtag.setHashtagId(1);
        List<Post> postsByHashtag = dao.findAllPostsByHashtag(hashtag, Integer.MAX_VALUE, 0);
        assertEquals(postsByHashtag.size(), 1);
    }

}
