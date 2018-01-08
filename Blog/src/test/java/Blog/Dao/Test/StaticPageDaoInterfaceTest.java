/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.Dao.StaticPageDaoInterface;
import Blog.Dto.StaticPage;
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
public class StaticPageDaoInterfaceTest {

    @Inject
    private StaticPageDaoInterface staticPageDao;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();    

    public StaticPageDaoInterfaceTest() {
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

        staticPageDao = ctx.getBean("staticPageDao", StaticPageDaoInterface.class);        
        
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setJdbcTemplate method, of class StaticPageDaoImplementation.
     */
    @Test
    public void testSetJdbcTemplate() {
    }

    /**
     * Test of createStaticPage method, of class StaticPageDaoImplementation.
     */
    @Test
    public void testCreateStaticPage() {

        StaticPage staticTestPage = new StaticPage();
        staticTestPage.setStaticPageTitle("Test Page");
        staticTestPage.setStaticPageContent("Test Page Content");

        staticTestPage = staticPageDao.createStaticPage(staticTestPage);

        assertTrue(staticTestPage.getStaticPageId() != null);

    }

    /**
     * Test of getStaticPageById method, of class StaticPageDaoImplementation.
     */
    @Test
    public void testGetStaticPageById() {

        StaticPage staticTestPage = new StaticPage();
        staticTestPage.setStaticPageTitle("Test Page");
        staticTestPage.setStaticPageContent("Test Page Content");

        staticTestPage = staticPageDao.createStaticPage(staticTestPage);

        StaticPage fromDao = staticPageDao.getStaticPageById(staticTestPage.getStaticPageId());

        assertTrue(fromDao.getStaticPageId().equals(staticTestPage.getStaticPageId()));
        assertTrue(fromDao.getStaticPageTitle().equals(staticTestPage.getStaticPageTitle()));
        assertTrue(fromDao.getStaticPageContent().equals(staticTestPage.getStaticPageContent()));

    }

    /**
     * Test of findAllStaticPages method, of class StaticPageDaoImplementation.
     */
    @Test
    public void testFindAllStaticPages() {
    }

    /**
     * Test of updateStaticPage method, of class StaticPageDaoImplementation.
     */
    @Test
    public void testUpdateStaticPage() {

        StaticPage staticTestPage = new StaticPage();
        staticTestPage.setStaticPageTitle("Test Page");
        staticTestPage.setStaticPageContent("Test Page Content");

        staticTestPage = staticPageDao.createStaticPage(staticTestPage);

        StaticPage editedPage = staticPageDao.getStaticPageById(staticTestPage.getStaticPageId());
        editedPage.setStaticPageTitle("Untested Page");
        editedPage.setStaticPageContent("Test Page Discontent");

        editedPage = staticPageDao.updateStaticPage(editedPage);

        assertTrue((int) editedPage.getStaticPageId() == (int) staticTestPage.getStaticPageId());
        assertTrue(editedPage.getStaticPageTitle().equals("Untested Page"));
        assertTrue(editedPage.getStaticPageContent().equals("Test Page Discontent"));

    }

    /**
     * Test of deleteStaticPage method, of class StaticPageDaoImplementation.
     */
    @Test
    public void testDeleteStaticPage() {

        StaticPage staticTestPage = new StaticPage();
        staticTestPage.setStaticPageTitle("Test Page");
        staticTestPage.setStaticPageContent("Test Page Content");

        staticTestPage = staticPageDao.createStaticPage(staticTestPage);
        
        staticPageDao.deleteStaticPage(staticTestPage.getStaticPageId());
        
        assertNull(staticPageDao.getStaticPageById(staticTestPage.getStaticPageId()));

    }

}
