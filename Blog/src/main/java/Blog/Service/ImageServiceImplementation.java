/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.Dao.ImageDaoInterface;
import Blog.Dto.Image;
import java.util.List;
import javax.inject.Inject;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author EJB Laptop
 */
public class ImageServiceImplementation implements ImageServiceInterface{
    
    @Inject
    private JdbcTemplate jdbcTemplate;
    
    private ImageDaoInterface imageDao;
    
    public ImageServiceImplementation(ImageDaoInterface imageDao) {
        this.imageDao = imageDao;
    }    

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }    

    @Override
    public Image createImage(Image image) {
    
       return imageDao.createImage(image); 
    }

    @Override
    public Image getImageById(Integer ImageId) {
        return imageDao.getImageById(ImageId); 
    }

    @Override
    public List<Image> findAllImages(int offset, int limit) {
        
        return imageDao.findAllImages(offset, limit); 
   
    }

    @Override
    public Image updateImage(Image image) {
        return imageDao.updateImage(image); 
    }

    @Override
    public void deleteImage(Integer imageId) {
        imageDao.deleteImage(imageId);
    }
    
}
