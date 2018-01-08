/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.Dao.CategoryDaoInterface;
import Blog.Dto.Category;
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
 * @author jeffc
 */
public class CategoryDaoInterfaceTest {

    @Inject
    private CategoryDaoInterface categoryDao;

    private ApplicationContextHelper ach = new ApplicationContextHelper();

    public CategoryDaoInterfaceTest() {
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

        categoryDao = ctx.getBean("categoryDao", CategoryDaoInterface.class);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createCategory method, of class CategoryDaoInterface.
     */
    @Test
    public void testCreateCategory() {
        Category testCategory = new Category();
        testCategory.setCategoryName("Buttons");
        testCategory = categoryDao.createCategory(testCategory);

        assertTrue(testCategory.getCategoryId() != null);

    }

    /**
     * Test of getCategoryById method, of class CategoryDaoInterface.
     */
    @Test
    public void testGetCategoryById() {

        Category categoryTestPage = new Category();
        categoryTestPage.setCategoryName("Test Page");
        categoryTestPage = categoryDao.createCategory(categoryTestPage);
        Category fromDao = categoryDao.getCategoryById(categoryTestPage.getCategoryId());
        assertTrue(fromDao.getCategoryId().equals(categoryTestPage.getCategoryId()));

        assertTrue(fromDao.getCategoryName().equals(categoryTestPage.getCategoryName()));
        assertTrue(fromDao.getCategoryName().equals(categoryTestPage.getCategoryName()));

    }

    /**
     * Test of findAllCategories method, of class CategoryDaoInterface.
     */
    @Test
    public void testFindAllCategories() {
        
        List<Category> categoriesBefore = categoryDao.findAllCategories(Integer.MAX_VALUE, 0);
        Integer numberOfCategoriesBefore = categoriesBefore.size();
        
        Category category = new Category();
        category.setCategoryName("Testing"); 
        Category addedCategory = categoryDao.createCategory(category);

     
        Category category2 = new Category();
        category2.setCategoryName("Testing"); 
        Category addedCategory2 = categoryDao.createCategory(category);

         Category category3 = new Category();
        category3.setCategoryName("Testing"); 
        Category addedCategory3 = categoryDao.createCategory(category);

        List<Category> categories = categoryDao.findAllCategories(Integer.MAX_VALUE, 0);
        assertEquals(numberOfCategoriesBefore + 3, categories.size());        
        
    }

    /**
     * Test of updateCategory method, of class CategoryDaoInterface.
     */
    @Test
    public void testUpdateCategory() {

        Category testCategory = new Category();
        testCategory.setCategoryName("Buttons");
        testCategory = categoryDao.createCategory(testCategory);

        Category editedCategory = categoryDao.getCategoryById(testCategory.getCategoryId());

        editedCategory.setCategoryName("Muttons");
        editedCategory = categoryDao.updateCategory(editedCategory);

        assertTrue((int) editedCategory.getCategoryId() == (int) testCategory.getCategoryId());
        assertTrue(editedCategory.getCategoryName().equals("Muttons"));

    }

    /**
     * Test of deleteCategory method, of class CategoryDaoInterface.
     */
    @Test
    public void testDeleteCategory() {

        Category testCategory = new Category();
        testCategory.setCategoryName("Buttons");
        testCategory = categoryDao.createCategory(testCategory);

        categoryDao.deleteCategory(testCategory.getCategoryId());

        assertNull(categoryDao.getCategoryById(testCategory.getCategoryId()));

    }
}
