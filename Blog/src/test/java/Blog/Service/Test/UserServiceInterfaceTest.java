/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.CommandModel.UserCommandModel;
import Blog.Dto.Role;
import Blog.Dto.User;
import Blog.Service.UserServiceInterface;
import Blog.ViewModel.UserViewModel;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author jeffc
 */
public class UserServiceInterfaceTest {

    @Inject
    private UserServiceInterface userService;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();    

    public UserServiceInterfaceTest() {
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

        userService = ctx.getBean("userService", UserServiceInterface.class);        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createUser method, of class UserServiceImplementation.
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
        
        testUser = userService.createUser(testUser);

        assertTrue(testUser.getUserId() != null);
        
    }

    /**
     * Test of getUserById method, of class UserServiceImplementation.
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
        
        testUser = userService.createUser(testUser);

        User fromDao = userService.getUserById(testUser.getUserId());
        
        assertTrue(testUser.getUserName().equals(fromDao.getUserName()));
        assertTrue(testUser.getUserPassword().equals(fromDao.getUserPassword()));
        assertTrue(testUser.getUserEmail().equals(fromDao.getUserEmail()));
        assertTrue((int)testUser.getRole().getRoleId() == fromDao.getRole().getRoleId());        
        
        
    }

    /**
     * Test of updateUser method, of class UserServiceImplementation.
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
        
        testUser = userService.createUser(testUser);
        
        User editedUser = new User();
        editedUser = userService.getUserById(testUser.getUserId());
        editedUser.setUserName("Untested User");
        editedUser.setUserPassword("Word Passtest");
        editedUser.setUserEmail("usertest@user.com");
        Role editedUserRole = new Role();
        editedUserRole.setRoleId(2);
        editedUser.setRole(editedUserRole);
        
        editedUser = userService.updateUser(editedUser);
        
        assertTrue(editedUser.getUserName().equals("Untested User"));
        assertTrue(editedUser.getUserPassword().equals("Word Passtest"));
        assertTrue(editedUser.getUserEmail().equals("usertest@user.com"));
        assertTrue((int)editedUser.getRole().getRoleId() == 2);        
        
    }

    /**
     * Test of deleteUser method, of class UserServiceImplementation.
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

        testUser = userService.createUser(testUser);

        userService.deleteUser(testUser.getUserId());

        assertNull(userService.getUserById(testUser.getUserId()));

    }

    /**
     * Test of findAllUsers method, of class UserServiceImplementation.
     */
    @Ignore
    @Test
    public void testFindAllUsers() {
    }

    /**
     * Test of findAllUsersByRole method, of class UserServiceImplementation.
     */
    @Ignore
    @Test
    public void testFindAllUsersByRole_3args_1() {
    }

    /**
     * Test of findAllUsersByRole method, of class UserServiceImplementation.
     */
    @Ignore
    @Test
    public void testFindAllUsersByRole_3args_2() {
    }
    
   
    @Test
    public void testBuildUserViewModelFromUser() {
        
        User testUser = new User();
        testUser.setUserName("Test User");
        testUser.setUserPassword("TestPassword");
        testUser.setUserEmail("testuser@test.com");
        Role testUserRole = new Role();
        testUserRole.setRoleId(1);
        testUser.setRole(testUserRole);

        testUser = userService.createUser(testUser);

        UserViewModel uvm = userService.buildUserViewModelFromUser(testUser, 10, 0);
        
        assertTrue((int)testUser.getUserId() == (int)uvm.getSelectedUser().getUserId());
        assertTrue(testUser.getUserName().equals(uvm.getSelectedUser().getUserName()));
        assertTrue(testUser.getUserPassword().equals(uvm.getSelectedUser().getUserPassword()));
        assertTrue(testUser.getUserEmail().equals(uvm.getSelectedUser().getUserEmail()));
        assertTrue((int)testUser.getRole().getRoleId() == (int)uvm.getSelectedUser().getRole().getRoleId());
    }
    
    @Test
    public void testBuildUserFromUserCommandModel() {
        
        UserCommandModel ucm = new UserCommandModel();
        ucm.setUserName("Test User");
        ucm.setUserPassword("TestPassword");
        ucm.setUserEmail("testuser@test.com");
        Role testUserRole = new Role();
        ucm.setRoleId(1);        

        User testUser = userService.buildUserFromUserCommandModel(ucm);
        
        assertTrue(testUser.getUserName().equals(ucm.getUserName()));
        assertTrue(testUser.getUserPassword().equals(ucm.getUserPassword()));
        assertTrue(testUser.getUserEmail().equals(ucm.getUserEmail()));
        assertTrue((int)testUser.getRole().getRoleId() == (int)ucm.getRoleId());
        
    }

}
