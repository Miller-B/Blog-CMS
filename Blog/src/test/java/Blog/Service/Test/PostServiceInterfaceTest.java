/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.CommandModel.PostCommandModel;
import Blog.Dto.Category;
import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Dto.User;
import Blog.Service.PostServiceInterface;
import Blog.ViewModel.PostViewModel;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author EJB Laptop
 */
public class PostServiceInterfaceTest {

    private PostServiceInterface postService;

    private ApplicationContextHelper ach = new ApplicationContextHelper();

    public PostServiceInterfaceTest() {
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

        postService = ctx.getBean("postService", PostServiceInterface.class);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createPost method, of class PostServiceInterface.
     */
    @Test
    public void testCreatePost() {
        Post testPost = new Post();
        User testUser = new User();
        testUser.setUserId(5);
        testPost.setUser(testUser);
        testPost.setStartDate(LocalDateTime.of(1996, Month.JANUARY, 22, 12, 20, 30));
        testPost.setEndDate(LocalDateTime.of(2018, Month.FEBRUARY, 01, 12, 20, 30));
        testPost.setCreateDate(LocalDateTime.of(1996, Month.JANUARY, 22, 12, 20, 31));
        testPost.setApprovalDate(LocalDateTime.of(1999, Month.AUGUST, 15, 22, 30, 15));
        testPost.setApproval(false);
        testPost.setPostTitle("Stuff and things.");
        testPost.setPostContent("Many more stuffs and things.");
        Category testCategory = new Category();
        testCategory.setCategoryId(7);
        testPost.setCategory(testCategory);
        testPost = postService.createPost(testPost);
        assertTrue(testPost.getPostId() != null);
    }

    /**
     * Test of getPostById method, of class PostServiceInterface.
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
        testPost = postService.createPost(testPost);

        Post postFromService = postService.getPostById(testPost.getPostId());

        assertEquals(testPost.getUser().getUserId(), postFromService.getUser().getUserId());
        assertEquals(testPost.getStartDate(), postFromService.getStartDate());
        assertEquals(testPost.getEndDate(), postFromService.getEndDate());
        assertEquals(testPost.getCreateDate(), postFromService.getCreateDate());
        assertEquals(testPost.getApprovalDate(), postFromService.getApprovalDate());
        assertEquals(testPost.getApproval(), postFromService.getApproval());
        assertEquals(testPost.getPostTitle(), postFromService.getPostTitle());
        assertEquals(testPost.getPostContent(), postFromService.getPostContent());
        assertEquals((int) testPost.getCategory().getCategoryId(),
                (int) postFromService.getCategory().getCategoryId());
    }

    /**
     * Test of findAllPosts method, of class PostServiceInterface.
     */
    @Test
    public void testFindAllPosts() {
        List<Post> postsList = postService.findAllPosts(Integer.MAX_VALUE, 0);
        int number = postsList.size();
        assertEquals(number, postsList.size());
    }

    /**
     * Test of updatePost method, of class PostServiceInterface.
     */
    @Test
    public void testUpdatePost() {
        Post comparePost = postService.getPostById(5);
        Post testPost = postService.getPostById(5);
        testPost.setPostTitle("New one.");
        postService.updatePost(testPost);
        assertTrue(comparePost.getPostTitle() != testPost.getPostTitle());
    }

    /**
     * Test of deletePost method, of class PostServiceInterface.
     */
    @Test
    public void testDeletePost() throws Exception {
        Post testDelete = postService.getPostById(5);
        postService.deletePost(testDelete.getPostId());
        assertNull(postService.getPostById(testDelete.getPostId()));
    }

    /**
     * Test of findAllPostsByUser method, of class PostServiceInterface.
     */
    @Test
    public void testFindAllPostsByUser() {
        User user = new User();
        user.setUserId(1);
        List<Post> postsByUser = postService.findAllPostsByUser(1, Integer.MAX_VALUE, 0);
        assertEquals(postsByUser.size(), 1);
    }

    /**
     * Test of findAllPostsByStartDate method, of class PostServiceInterface.
     */
    @Test
    public void testFindAllPostsByStartDate() {
        LocalDateTime startDate = LocalDateTime.of(2017, Month.FEBRUARY, 13, 01, 02, 04);
        List<Post> postsByStartDate = postService.findAllPostsByStartDate(startDate, Integer.MAX_VALUE, 0);
        assertEquals(postsByStartDate.size(), 1);
    }

    /**
     * Test of findAllPostsByEndDate method, of class PostServiceInterface.
     */
    @Test
    public void testFindAllPostsByEndDate() {
        LocalDateTime endDate = null;
        List<Post> postsByEndDate = postService.findAllPostsByEndDate(endDate, Integer.MAX_VALUE, 0);
        assertEquals(postsByEndDate.size(), 5);
    }

    /**
     * Test of findAllPostsByCreateDate method, of class PostServiceInterface.
     */
    @Test
    public void testFindAllPostsByCreateDate() {
        LocalDateTime createDate = LocalDateTime.of(2017, Month.FEBRUARY, 13, 01, 02, 03);
        List<Post> postsByCreateDate = postService.findAllPostsByCreateDate(createDate, Integer.MAX_VALUE, 0);
        assertEquals(postsByCreateDate.size(), 1);
    }

    /**
     * Test of findAllPostsByApprovalDate method, of class PostServiceInterface.
     */
    @Test
    public void testFindAllPostsByApprovalDate() {
        LocalDateTime approvalDate = LocalDateTime.of(2017, Month.SEPTEMBER, 20, 02, 03, 04);
        List<Post> postsByApprovalDate = postService.findAllPostsByApprovalDate(approvalDate, Integer.MAX_VALUE, 0);
        assertEquals(postsByApprovalDate.size(), 1);
    }

    /**
     * Test of findAllPostsByApproval method, of class PostServiceInterface.
     */
    @Test
    public void testFindAllPostsByApproval() {
        int approval = 0;
        List<Post> postsByApproval = postService.findAllPostsByApproval(approval, Integer.MAX_VALUE, 0);
        assertEquals(postsByApproval.size(), 5);
    }

    /**
     * Test of findAllPostsByCategory method, of class PostServiceInterface.
     */
    @Test
    public void testFindAllPostsByCategory() {
        Category category = new Category();
        category.setCategoryId(1);
        List<Post> postsByCategory = postService.findAllPostsByCategory(category, Integer.MAX_VALUE, 0);
        assertEquals(postsByCategory.size(), 2);
    }

    /**
     * Test of findAllPostsByHashtag method, of class PostServiceInterface.
     */
    @Test
    public void testFindAllPostsByHashtag() {
        Hashtag hashtag = new Hashtag();
        hashtag.setHashtagId(1);
        List<Post> postsByHashtag = postService.findAllPostsByHashtag(hashtag, Integer.MAX_VALUE, 0);
    }

//    @Test
//    public void testBuildPostViewModelFromPost() {
//
//        Post testPost = new Post();
//        User testUser = new User();
//        testUser.setUserId(1);
//        testPost.setUser(testUser);
//        testPost.setStartDate(LocalDateTime.of(1970, Month.JANUARY, 01, 00, 00, 00));
//        testPost.setEndDate(LocalDateTime.of(2000, Month.JANUARY, 01, 00, 00, 00));
//        testPost.setCreateDate(LocalDateTime.of(1970, Month.JANUARY, 01, 00, 00, 00));
//        testPost.setApprovalDate(LocalDateTime.of(1970, Month.JANUARY, 01, 00, 00, 00));
//        testPost.setApproval(true);
//        testPost.setPostTitle("My Test Post");
//        testPost.setPostContent("This content is a simple string.");
//        Category testCategory = new Category();
//        testCategory.setCategoryId(1);
//        testPost.setCategory(testCategory);
//        testPost = postService.createPost(testPost);
//
//        PostViewModel pvm = postService.buildPostViewModelFromPost(testPost, 10, 0);
//
//        assertEquals(testPost.getUser().getUserId(), pvm.getSelectedPost().getPost().getUser().getUserId());
//        assertEquals(testPost.getStartDate(), pvm.getSelectedPost().getPost().getStartDate());
//        assertEquals(testPost.getEndDate(), pvm.getSelectedPost().getPost().getEndDate());
//        assertEquals(testPost.getCreateDate(), pvm.getSelectedPost().getPost().getCreateDate());
//        assertEquals(testPost.getApprovalDate(), pvm.getSelectedPost().getPost().getApprovalDate());
//        assertEquals(testPost.getApproval(), pvm.getSelectedPost().getPost().getApproval());
//        assertEquals(testPost.getPostTitle(), pvm.getSelectedPost().getPost().getPostTitle());
//        assertEquals(testPost.getPostContent(), pvm.getSelectedPost().getPost().getPostContent());
//        assertEquals((int) testPost.getCategory().getCategoryId(),
//                (int) pvm.getSelectedPost().getPost().getCategory().getCategoryId());
//
//    }
//
//    @Test
//    public void testBuildPostFromPostCommandModel() {
//
//        PostCommandModel pcm = new PostCommandModel();
//        User testUser = new User();
//        testUser.setUserId(1);
//        pcm.setUser(testUser);
//        pcm.setStartDate(LocalDateTime.of(1970, Month.JANUARY, 01, 00, 00, 00));
//        pcm.setEndDate(LocalDateTime.of(2000, Month.JANUARY, 01, 00, 00, 00));
//        pcm.setCreateDate(LocalDateTime.of(1970, Month.JANUARY, 01, 00, 00, 00));
//        pcm.setApprovalDate(LocalDateTime.of(1970, Month.JANUARY, 01, 00, 00, 00));
//        pcm.setApproval(true);
//        pcm.setPostTitle("My Test Post");
//        pcm.setPostContent("This content is a simple string.");
//        Category testCategory = new Category();
//        testCategory.setCategoryId(1);
//        pcm.setCategory(testCategory);
//
//        Post testPost = postService.buildPostFromPostCommandModel(pcm);
//
//        assertEquals(testPost.getStartDate(), pcm.getStartDate());
//        assertEquals(testPost.getEndDate(), pcm.getEndDate());
//        assertEquals(testPost.getCreateDate(), pcm.getCreateDate());
//        assertEquals(testPost.getApprovalDate(), pcm.getApprovalDate());
//        assertEquals(testPost.getApproval(), pcm.getApproval());
//        assertEquals(testPost.getPostTitle(), pcm.getPostTitle());
//        assertEquals(testPost.getPostContent(), pcm.getPostContent());
//        assertEquals((int) testPost.getCategory().getCategoryId(),
//                (int) pcm.getCategory().getCategoryId());
//
//    }

}
