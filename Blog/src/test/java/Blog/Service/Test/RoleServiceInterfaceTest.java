/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.Dto.Role;
import Blog.Dto.User;
import Blog.Service.RoleServiceInterface;
import java.util.List;
import javax.inject.Inject;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author BMMil
 */
public class RoleServiceInterfaceTest {

    @Inject
    private RoleServiceInterface roleService;

    private ApplicationContextHelper ach = new ApplicationContextHelper();

    public RoleServiceInterfaceTest() {
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
        roleService = ctx.getBean("roleService", RoleServiceInterface.class);

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testCreateAndReadRole() {
        Role role1 = new Role();
        role1.setRoleName("user");
        Role newRole = roleService.createRole(role1);
        Role roleFrom = roleService.getRoleById(role1.getRoleId());
        assertEquals(roleFrom.getRoleName(), "user");
    }

    @Test
    public void testGetRoleById() {
        Role role1 = new Role();
        role1.setRoleName("captain");

        role1 = roleService.createRole(role1);

        Role roleFrom = roleService.getRoleById(role1.getRoleId());

        assertTrue(roleFrom.getRoleId().equals(role1.getRoleId()));
        assertTrue(roleFrom.getRoleName().equals(role1.getRoleName()));
  
    }

    @Test
    public void testUpdateRole() {
        Role role1 = new Role();
        role1.setRoleName("thisIsArole");
        roleService.createRole(role1);

        Role roleFrom = roleService.getRoleById(role1.getRoleId());
        assertEquals(roleFrom.getRoleName(), "thisIsArole");

        roleFrom.setRoleName("newRole");

        roleService.updateRole(roleFrom);

        Role updatedRole = roleService.getRoleById(role1.getRoleId());

        assertEquals(roleFrom.getRoleName(), "newRole");
    }

    @Test
    public void testDeleteRole() throws Exception{
        
        Role role2 = new Role();
        role2.setRoleName("arole");
        roleService.createRole(role2);
        Role roleFrom = roleService.getRoleById(role2.getRoleId());
        assertEquals(roleFrom, role2);
        roleService.deleteRole(role2.getRoleId());
        assertNull(roleService.getRoleById(role2.getRoleId()));

        
        
    }

    @Test
    public void testFindAllRoles() {
        List<Role> roles = roleService.findAllRoles(10, 0);
        assertTrue(roles.size() == 3);

    }

    @Test
    public void testFindAllRolesByUser() {
        List<Role> rolesByUser = roleService.findAllRolesByUser(1, 10, 0);
        assertEquals(rolesByUser.size(), 1);

    }

}
