/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.CommandModel.HashtagCommandModel;
import Blog.Dao.HashtagDaoInterface;
import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.ViewModel.HashtagViewModel;
import Blog.ViewModel.SingleHashtagViewModel;
import java.util.List;

/**
 *
 * @author BMMil
 */
public class HashtagServiceImplementation implements HashtagServiceInterface {

    private HashtagDaoInterface hashtagDao;
    
    private PostServiceInterface postService;
    
    public HashtagServiceImplementation(HashtagDaoInterface hashtagDao) {
        this.hashtagDao = hashtagDao;
    }

    public void setPostService(PostServiceInterface postService) {
        this.postService = postService;
    }

    @Override
    public Hashtag createHashtag(Hashtag hashtag) {
        return hashtagDao.createHashtag(hashtag);
    }

    @Override
    public Hashtag getHashtagById(Integer hashtagId) {
        return hashtagDao.getHashtagById(hashtagId);
    }

    @Override
    public Hashtag updateHashtag(Hashtag hashtag) {
       return hashtagDao.updateHashtag(hashtag);
    }
    
    @Override
     public void deleteHashtag(Integer hashtagId) throws BlogServiceException {
             hashtagDao.deleteHashtag(hashtagId);

    }

    @Override
    public List<Hashtag> findAllHashtags(int offset, int limit) {
        return hashtagDao.findAllHashtags(offset, limit);
    }

    @Override
    public List<Hashtag> findAllHashtagsByPost(Integer postId, int offset, int limit) {
        return hashtagDao.findAllHashtagsByPost(postService.getPostById(postId), offset, limit);
    }


    @Override
    public List<Hashtag> findAllHashtagsByPost(Post post, int offset, int limit) {
        return hashtagDao.findAllHashtagsByPost(post, offset, limit);
    }


    @Override
    public HashtagViewModel buildHashtagViewModelFromHashtag(Hashtag hashtag, int hashtagLimit, int hashtagOffset) {

        HashtagViewModel hvm = new HashtagViewModel();
        hvm.setSelectedHashtag(hashtag);
        hvm.setHashtags(this.findAllHashtags(hashtagLimit, hashtagOffset));
        return hvm;

    }

    @Override
    public Hashtag buildHashtagFromHashtagCommandModel(HashtagCommandModel hcm) {

        Hashtag hashtag = new Hashtag();
        if (hcm.getHashtagId() != null) {
            hashtag.setHashtagId(hcm.getHashtagId());
        }
        hashtag.setTagName(hcm.getTagName());
        return hashtag;

    }
    
    @Override
    public SingleHashtagViewModel buildSingleHashtagViewModelFromHashtagId(Integer hashtagId) {
        SingleHashtagViewModel shvm = new SingleHashtagViewModel();
        shvm.setHashtag(this.getHashtagById(hashtagId));
        return shvm;
    }
    
    @Override
    public Hashtag createFirstHashtagAutomatically() {
        Hashtag hashtag = new Hashtag();
        hashtag.setHashtagId(0);
        hashtag.setTagName("#default");
        return hashtag;
    }
    
}
