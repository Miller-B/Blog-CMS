/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.Dao.UserDaoInterface;
import Blog.Dto.Role;
import Blog.Dto.User;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author jeffc
 */
public class UserDaoInterfaceTest {
    
    @Inject
    private UserDaoInterface userDao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();

    public UserDaoInterfaceTest() {
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

        userDao = ctx.getBean("userDao", UserDaoInterface.class);        
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setJdbcTemplate method, of class UserDaoImplementation.
     */
    @Test
    public void testSetJdbcTemplate() {
    }

    /**
     * Test of createUser method, of class UserDaoImplementation.
     */
    @Test
    public void testCreateUser() {
        
        User testUser = new User();
        testUser.setUserName("Test User");
        testUser.setUserPassword("TestPassword");
        testUser.setUserEmail("testuser@test.com");
        Role testUserRole = new Role();
        testUserRole.setRoleId(1);
        testUser.setRole(testUserRole);
        
        testUser = userDao.createUser(testUser);

        assertTrue(testUser.getUserId() != null);
        
    }

    /**
     * Test of getUserById method, of class UserDaoImplementation.
     */
    @Test
    public void testGetUserById() {
        
        User testUser = new User();
        testUser.setUserName("Test User");
        testUser.setUserPassword("TestPassword");
        testUser.setUserEmail("testuser@test.com");
        Role testUserRole = new Role();
        testUserRole.setRoleId(1);
        testUser.setRole(testUserRole);
        
        testUser = userDao.createUser(testUser);

        User fromDao = userDao.getUserById(testUser.getUserId());
        
        assertTrue(testUser.getUserName().equals(fromDao.getUserName()));
        assertTrue(testUser.getUserPassword().equals(fromDao.getUserPassword()));
        assertTrue(testUser.getUserEmail().equals(fromDao.getUserEmail()));
        assertTrue((int)testUser.getRole().getRoleId() == fromDao.getRole().getRoleId());
        
    }

    /**
     * Test of findAllUsers method, of class UserDaoImplementation.
     */
    @Test
    public void testFindAllUsers() {
    }

    /**
     * Test of updateUser method, of class UserDaoImplementation.
     */
    @Test
    public void testUpdateUser() {

        User testUser = new User();
        testUser.setUserName("Test User");
        testUser.setUserPassword("TestPassword");
        testUser.setUserEmail("testuser@test.com");
        Role testUserRole = new Role();
        testUserRole.setRoleId(1);
        testUser.setRole(testUserRole);
        
        testUser = userDao.createUser(testUser);
        
        User editedUser = new User();
        editedUser = userDao.getUserById(testUser.getUserId());
        editedUser.setUserName("Untested User");
        editedUser.setUserPassword("Word Passtest");
        editedUser.setUserEmail("usertest@user.com");
        Role editedUserRole = new Role();
        editedUserRole.setRoleId(2);
        editedUser.setRole(editedUserRole);
        
        editedUser = userDao.updateUser(editedUser);
        
        assertTrue(editedUser.getUserName().equals("Untested User"));
        assertTrue(editedUser.getUserPassword().equals("Word Passtest"));
        assertTrue(editedUser.getUserEmail().equals("usertest@user.com"));
        assertTrue((int)editedUser.getRole().getRoleId() == 2);
    }

    /**
     * Test of deleteUser method, of class UserDaoImplementation.
     */
    @Test
    public void testDeleteUser() {

        User testUser = new User();
        testUser.setUserName("Test User");
        testUser.setUserPassword("TestPassword");
        testUser.setUserEmail("testuser@test.com");
        Role testUserRole = new Role();
        testUserRole.setRoleId(1);
        testUser.setRole(testUserRole);

        testUser = userDao.createUser(testUser);

        userDao.deleteUser(testUser.getUserId());

        assertNull(userDao.getUserById(testUser.getUserId()));

    }

    /**
     * Test of findAllUsersByRole method, of class UserDaoImplementation.
     */
    @Test
    public void testFindAllUsersByRole() {
    }

}
