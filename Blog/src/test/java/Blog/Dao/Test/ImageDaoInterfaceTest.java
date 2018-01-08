/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Dao.Test;

import Blog.ApplicationContextHelper.TestingDataInjector.ApplicationContextHelper;
import Blog.ApplicationContextHelper.TestingDataInjector.TestingDataInjector;
import Blog.Dao.ImageDaoInterface;
import Blog.Dto.Image;
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
//public class ImageDaoInterfaceTest {
    
//    @Inject
//    private ImageDaoInterface imageDao;
//
//    private ApplicationContextHelper ach = new ApplicationContextHelper();
//    
//    public ImageDaoInterfaceTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//        ApplicationContextHelper ach = new ApplicationContextHelper();
//        TestingDataInjector dbInjection;
//        ApplicationContext ctx = ach.getContext();
//        dbInjection = ctx.getBean("dbInjection", TestingDataInjector.class);
//        dbInjection.setUpDatabase();
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//        ApplicationContextHelper ach = new ApplicationContextHelper();
//        TestingDataInjector dbInjection;
//        ApplicationContext ctx = ach.getContext();
//        dbInjection = ctx.getBean("dbInjection", TestingDataInjector.class);
//        dbInjection.tearDownDatabase();
//    }
//    
//    @Before
//    public void setUp() {
//        ApplicationContext ctx = ach.getContext();
//        imageDao = ctx.getBean("imageDao", ImageDaoInterface.class);
//    }
    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of createCategory method, of class CategoryDaoInterface.
     */
//    @Ignore
//    @Test
//    public void testCreateImage() {
//        Image testImage = new Image(); 
//        testImage.setDescription("Tub girl");
//        testImage.setImage("image.jpg");
//        testImage = imageDao.createImage(testImage);
//        assertTrue(testImage.getImageId() != null);
//    }
//
//    /**
//     * Test of getCategoryById method, of class CategoryDaoInterface.
//     */
//    @Ignore
//    @Test
//    public void testGetImageById() {
//        Image imageTestPage = new Image();
//        imageTestPage.setImage("example.jpg");
//        imageTestPage = imageDao.createImage(imageTestPage);
//        Image fromDao = imageDao.getImageById(imageTestPage.getImageId());
//        assertTrue(fromDao.getImageId().equals(imageTestPage.getImageId()));
//        assertTrue(fromDao.getImage().equals(imageTestPage.getImage()));
//        assertTrue(fromDao.getImage().equals(imageTestPage.getImage()));
//    }
//
//    /**
//     * Test of findAllCategories method, of class CategoryDaoInterface.
//     */
//    @Ignore
//    @Test
//    public void testFindAllImages() {
//        List<Image> imagesBefore = imageDao.findAllImages(Integer.MAX_VALUE, 0);
//        Integer numberOfImagesBefore = imagesBefore.size();
//        Image image = new Image();
//        image.setImage("test.jpg"); 
//        Image addedImage = imageDao.createImage(image);
//        Image image2 = new Image();
//        image2.setImage("image.jpg"); 
//        Image addedImage2 = imageDao.createImage(image);
//        Image image3 = new Image();
//        image3.setImage("image.jpg"); 
//        Image addedImage3 = imageDao.createImage(image);
//        List<Image> images = imageDao.findAllImages(Integer.MAX_VALUE, 0);
//        assertEquals(images.size(), 3);        
//    }
//
//    /**
//     * Test of updateCategory method, of class CategoryDaoInterface.
//     */
//    @Ignore
//    @Test
//    public void testUpdateImage() {
//        Image testImage = new Image();
//        testImage.setImage("example.jpg");
//        testImage = imageDao.createImage(testImage);
//        Image editedImage = imageDao.getImageById(testImage.getImageId());
//        editedImage.setImage("example.jpg");
//        editedImage = imageDao.updateImage(editedImage);
//        assertTrue((int) editedImage.getImageId() == (int) testImage.getImageId());
//        assertTrue(editedImage.getImage().equals("example.jpg"));
//    }
//
//    /**
//     * Test of deleteCategory method, of class CategoryDaoInterface.
//     */
//    @Ignore
//    @Test
//    public void testDeleteImage() {
//        Image testImage= new Image();
//        testImage.setImage("example.jpg");
//        testImage = imageDao.createImage(testImage);
//        imageDao.deleteImage(testImage.getImageId());
//        assertNull(imageDao.getImageById(testImage.getImageId()));
//    }
//    
//}
