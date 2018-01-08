/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.CommandModel.StaticPageCommandModel;
import Blog.Dto.StaticPage;
import Blog.Service.StaticPageServiceInterface;
import Blog.ViewModel.StaticPageViewModel;
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
 * @author jeffc
 */
public class StaticPageServiceInterfaceTest {

    @Inject
    private StaticPageServiceInterface staticPageService;

    private ApplicationContextHelper ach = new ApplicationContextHelper();

    public StaticPageServiceInterfaceTest() {
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

        staticPageService = ctx.getBean("staticPageService", StaticPageServiceInterface.class);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createStaticPage method, of class
     * StaticPageServiceImplementation.
     */
    @Test
    public void testCreateStaticPage() {

        StaticPage staticTestPage = new StaticPage();
        staticTestPage.setStaticPageTitle("Test Page");
        staticTestPage.setStaticPageContent("Test Page Content");

        staticTestPage = staticPageService.createStaticPage(staticTestPage);

        assertTrue(staticTestPage.getStaticPageId() != null);
    }

    /**
     * Test of getStaticPageById method, of class
     * StaticPageServiceImplementation.
     */
    @Test
    public void testGetStaticPageById() {

        StaticPage staticTestPage = new StaticPage();
        staticTestPage.setStaticPageTitle("Test Page");
        staticTestPage.setStaticPageContent("Test Page Content");

        staticTestPage = staticPageService.createStaticPage(staticTestPage);

        StaticPage fromService = staticPageService.getStaticPageById(staticTestPage.getStaticPageId());

        assertTrue(fromService.getStaticPageId().equals(staticTestPage.getStaticPageId()));
        assertTrue(fromService.getStaticPageTitle().equals(staticTestPage.getStaticPageTitle()));
        assertTrue(fromService.getStaticPageContent().equals(staticTestPage.getStaticPageContent()));
    }

    /**
     * Test of updateStaticPage method, of class
     * StaticPageServiceImplementation.
     */
    @Test
    public void testUpdateStaticPage() {

        StaticPage staticTestPage = new StaticPage();
        staticTestPage.setStaticPageTitle("Test Page");
        staticTestPage.setStaticPageContent("Test Page Content");

        staticTestPage = staticPageService.createStaticPage(staticTestPage);

        StaticPage editedPage = staticPageService.getStaticPageById(staticTestPage.getStaticPageId());
        editedPage.setStaticPageTitle("Untested Page");
        editedPage.setStaticPageContent("Test Page Discontent");

        editedPage = staticPageService.updateStaticPage(editedPage);

        assertTrue((int) editedPage.getStaticPageId() == (int) staticTestPage.getStaticPageId());
        assertTrue(editedPage.getStaticPageTitle().equals("Untested Page"));
        assertTrue(editedPage.getStaticPageContent().equals("Test Page Discontent"));

    }

    /**
     * Test of deleteStaticPage method, of class
     * StaticPageServiceImplementation.
     */
    @Test
    public void testDeleteStaticPage() {

        StaticPage staticTestPage = new StaticPage();
        staticTestPage.setStaticPageTitle("Test Page");
        staticTestPage.setStaticPageContent("Test Page Content");

        staticTestPage = staticPageService.createStaticPage(staticTestPage);

        staticPageService.deleteStaticPage(staticTestPage.getStaticPageId());

        assertNull(staticPageService.getStaticPageById(staticTestPage.getStaticPageId()));

    }

    /**
     * Test of findAllStaticPages method, of class
     * StaticPageServiceImplementation.
     */
    @Test
    public void testFindAllStaticPages() {

        int numberOfStaticPagesBefore = staticPageService.findAllStaticPages(Integer.MAX_VALUE, 0).size();

        StaticPage sp1 = new StaticPage();
        sp1.setStaticPageTitle("Test Page 1");
        sp1.setStaticPageContent("Test Page Content 1");
        sp1 = staticPageService.createStaticPage(sp1);

        StaticPage sp2 = new StaticPage();
        sp2.setStaticPageTitle("Test Page 2");
        sp2.setStaticPageContent("Test Page Content 2");
        sp2 = staticPageService.createStaticPage(sp2);

        StaticPage sp3 = new StaticPage();
        sp3.setStaticPageTitle("Test Page 3");
        sp3.setStaticPageContent("Test Page Content 3");
        sp3 = staticPageService.createStaticPage(sp3);

        assertEquals(numberOfStaticPagesBefore + 3, staticPageService.findAllStaticPages(Integer.MAX_VALUE, 0).size());

    }

    @Test
    public void testBuildStaticPageViewModelFromStaticPage() {

        StaticPage staticTestPage = new StaticPage();
        staticTestPage.setStaticPageTitle("Test Page");
        staticTestPage.setStaticPageContent("Test Page Content");

        staticTestPage = staticPageService.createStaticPage(staticTestPage);

        StaticPageViewModel spvm = staticPageService.buildStaticPageViewModelFromStaticPage(staticTestPage);

        assertTrue((int) staticTestPage.getStaticPageId() == (int) spvm.getSelectedStaticPage().getStaticPageId());
        assertTrue(staticTestPage.getStaticPageTitle().equals(spvm.getSelectedStaticPage().getStaticPageTitle()));
        assertTrue(staticTestPage.getStaticPageContent().equals(spvm.getSelectedStaticPage().getStaticPageContent()));

    }

    @Test
    public void testBuildStaticPageFromStaticPageCommandModel() {

        StaticPageCommandModel spcm = new StaticPageCommandModel();
        spcm.setStaticPageTitle("Test Page");
        spcm.setStaticPageContent("Test Content");

        StaticPage staticTestPage = staticPageService.buildStaticPageFromStaticPageCommandModel(spcm);

        assertTrue(staticTestPage.getStaticPageTitle().equals(spcm.getStaticPageTitle()));
        assertTrue(staticTestPage.getStaticPageContent().equals(spcm.getStaticPageContent()));

    }

}
