/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.CommandModel.CategoryCommandModel;
import Blog.Dto.Category;
import Blog.Service.CategoryServiceInterface;
import Blog.ViewModel.CategoryViewModel;
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
public class CategoryServiceInterfaceTest {
    
    @Inject
    private CategoryServiceInterface categoryService;
    
    private ApplicationContextHelper ach = new ApplicationContextHelper();    
    
    public CategoryServiceInterfaceTest() {
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

        categoryService = ctx.getBean("categoryService", CategoryServiceInterface.class);        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createCategory method, of class CategoryServiceInterface.
     */
    @Test
    public void testCreateCategory() {
        
        Category testCategory = new Category();
        testCategory.setCategoryName("Buttons");
        testCategory = categoryService.createCategory(testCategory);
        
        assertTrue(testCategory.getCategoryId() != null);        
        
    }

    /**
     * Test of getCategoryById method, of class CategoryServiceInterface.
     */
    @Test
    public void testGetCategoryById() {
    }

    /**
     * Test of updateCategory method, of class CategoryServiceInterface.
     */
    @Test
    public void testUpdateCategory() {
        
        Category testCategory = new Category();
        testCategory.setCategoryName("Buttons");
        testCategory = categoryService.createCategory(testCategory);
        
        Category editedCategory = categoryService.getCategoryById(testCategory.getCategoryId());
        
        editedCategory.setCategoryName("Muttons");
        editedCategory = categoryService.updateCategory(editedCategory);
        
        assertTrue((int)editedCategory.getCategoryId() == (int)testCategory.getCategoryId());
        assertTrue(editedCategory.getCategoryName().equals("Muttons"));        
        
    }

    /**
     * Test of deleteCategory method, of class CategoryServiceInterface.
     */
    @Test
    public void testDeleteCategory() {
        
        Category testCategory = new Category();
        testCategory.setCategoryName("Buttons");
        testCategory = categoryService.createCategory(testCategory);

        categoryService.deleteCategory(testCategory.getCategoryId());
        
        assertNull(categoryService.getCategoryById(testCategory.getCategoryId()));        
        
    }

    /**
     * Test of findAllCategories method, of class CategoryServiceInterface.
     */
    @Test
    public void testFindAllCategories() {
    }
    
    @Test
    public void testBuildCategoryViewModelFromCategory() {
        
        Category category = new Category();
        category.setCategoryName("Test Category");
        
        category = categoryService.createCategory(category);
        
        CategoryViewModel cvm = categoryService.buildCategoryViewModelFromCategory(category);
        
        assertTrue((int)category.getCategoryId() == (int)cvm.getSelectedCategory().getCategoryId());
        assertTrue(category.getCategoryName().equals(cvm.getSelectedCategory().getCategoryName()));
    }

 
    @Test
    public void testBuildCategoryFromCategoryCommandModel() {
        
        CategoryCommandModel ccm = new CategoryCommandModel();
        ccm.setCategoryName("Test Category");
        
        Category category = categoryService.buildCategoryFromCategoryCommandModel(ccm);
        
        assertTrue(category.getCategoryName().equals(ccm.getCategoryName()));
        
    }        
    
}
