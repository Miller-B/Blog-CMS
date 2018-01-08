/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.Dao.RoleDaoInterface;
import Blog.Dto.Role;
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
public class RoleDaoInterfaceTest {

    @Inject
    private RoleDaoInterface roleDao;

    private ApplicationContextHelper ach = new ApplicationContextHelper();

    public RoleDaoInterfaceTest() {
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
        roleDao = ctx.getBean("roleDao", RoleDaoInterface.class);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testCreateAndReadRole() {

        Role role1 = new Role();
        role1.setRoleName("captain");

        Role newRole = roleDao.createRole(role1);

        Role roleFromDb = roleDao.getRoleById(role1.getRoleId());
        assertEquals(roleFromDb.getRoleName(), "captain");
    }

    @Test
    public void testFindAllRoles() {

        List<Role> roles = roleDao.findAllRoles(10, 0);
        assertTrue(roles.size() == 3);


    }
    
      @Test
    public void testUpdateRole() {

        Role role1 = new Role();

        role1.setRoleName("thisIsArole");

        roleDao.createRole(role1);

        Role roleFromDb = roleDao.getRoleById(role1.getRoleId());
        assertEquals(roleFromDb.getRoleName(), "thisIsArole");

        roleFromDb.setRoleName("newRole");

        roleDao.updateRole(roleFromDb);

        Role updatedRole = roleDao.getRoleById(role1.getRoleId());

        assertEquals(roleFromDb.getRoleName(), "newRole");
    }
    
        @Test
    public void testDeleteRole() throws Exception {

        Role role2 = new Role();

        role2.setRoleName("user");

        roleDao.createRole(role2);

        Role roleFromDb = roleDao.getRoleById(role2.getRoleId());
        assertEquals(roleFromDb, role2);
        roleDao.deleteRole(role2.getRoleId());
        assertNull(roleDao.getRoleById(role2.getRoleId()));
        
    }
    
    @Test
    public void testFindAllRolesByUser() {
        
    }
    
}
