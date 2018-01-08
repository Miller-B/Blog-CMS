/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.CommandModel.HashtagCommandModel;
import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.ViewModel.HashtagViewModel;
import Blog.ViewModel.SingleHashtagViewModel;
import java.util.List;


public interface HashtagServiceInterface {

    public Hashtag createHashtag(Hashtag hashtag);

    public Hashtag getHashtagById(Integer hashtagId);

    public Hashtag updateHashtag(Hashtag hashtag);

    public void deleteHashtag(Integer hashtagId) throws BlogServiceException;

    public List<Hashtag> findAllHashtags(int offset, int limit);

    public List<Hashtag> findAllHashtagsByPost(Integer postId, int offset, int limit);

    public List<Hashtag> findAllHashtagsByPost(Post post, int offset, int limit);
    
    public HashtagViewModel buildHashtagViewModelFromHashtag(Hashtag hashtag, int hashtagLimit, int hashtagOffset);
    
    public Hashtag buildHashtagFromHashtagCommandModel(HashtagCommandModel hcm);

    public SingleHashtagViewModel buildSingleHashtagViewModelFromHashtagId(Integer hashtagId);

    public Hashtag createFirstHashtagAutomatically();

}
