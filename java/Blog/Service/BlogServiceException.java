/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

/**
 *
 * @author EJB Laptop
 */
public class BlogServiceException extends Exception {
    
    public BlogServiceException(String message) {
        super(message);
    }
    
    public BlogServiceException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
