/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Service;

import Blog.CommandModel.PostCommandModel;
import Blog.Dao.PostDaoInterface;
import Blog.Dao.PostHashtagDaoInterface;
import Blog.Dto.Category;
import Blog.Dto.Hashtag;
import Blog.Dto.Post;
import Blog.Dto.User;
import Blog.ViewModel.PostViewModel;
import Blog.ViewModel.SinglePostViewModel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EJB Laptop
 */
public class PostServiceImplementation implements PostServiceInterface {

    PostDaoInterface postDao;
    CategoryServiceInterface categoryService;
    UserServiceInterface userService;
    HashtagServiceInterface hashtagService;
    PostHashtagDaoInterface postHashtagDao;
    StaticPageServiceInterface staticPageService;

    public PostServiceImplementation(PostDaoInterface postDao) {
        this.postDao = postDao;
    }

    public void setCategoryService(CategoryServiceInterface categoryService) {
        this.categoryService = categoryService;
    }

    public void setUserService(UserServiceInterface userService) {
        this.userService = userService;
    }

    public void setHashtagService(HashtagServiceInterface hashtagService) {
        this.hashtagService = hashtagService;
    }

    public void setPostHashtagDao(PostHashtagDaoInterface postHashtagDao) {
        this.postHashtagDao = postHashtagDao;
    }

    public void setStaticPageService(StaticPageServiceInterface staticPageService) {
        this.staticPageService = staticPageService;
    }

    @Override
    public Post createPost(Post post) {
        return postDao.createPost(post);
    }

    @Override
    public Post getPostById(Integer postId) {
        return postDao.getPostById(postId);
    }

    @Override
    public List<Post> findAllPosts(int limit, int offset) {
        return postDao.findAllPosts(limit, offset);
    }

    @Override
    public Post updatePost(Post post) {
        return postDao.updatePost(post);
    }

    @Override
    public void deletePost(Integer postId) throws BlogServiceException {
        deleteAllPostHashtagsFromPost(postId);
        postDao.deletePost(postId);
    }

    @Override
    public List<Post> findAllPostsByUser(User user, int limit, int offset) {
        return postDao.findAllPostsByUser(user, limit, offset);
    }

    @Override
    public List<Post> findAllPostsByUser(int userId, int limit, int offset) {
        return postDao.findAllPostsByUser(userService.getUserById(userId), limit, offset);
    }

    @Override
    public List<Post> findAllPostsByStartDate(LocalDateTime startDate, int limit, int offset) {
        return postDao.findAllPostsByStartDate(startDate, limit, offset);
    }

    @Override
    public List<Post> findAllPostsByEndDate(LocalDateTime endDate, int limit, int offset) {
        return postDao.findAllPostsByEndDate(endDate, limit, offset);
    }

    @Override
    public List<Post> findAllPostsByCreateDate(LocalDateTime createDate, int limit, int offset) {
        return postDao.findAllPostsByCreateDate(createDate, limit, offset);
    }

    @Override
    public List<Post> findAllPostsByApprovalDate(LocalDateTime approvalDate, int limit, int offset) {
        return postDao.findAllPostsByApprovalDate(approvalDate, limit, offset);
    }

    @Override
    public List<Post> findAllPostsByApproval(int approval, int limit, int offset) {
        return postDao.findAllPostsByApproval(approval, limit, offset);
    }

    @Override
    public List<Post> findAllPostsByCategory(Category category, int limit, int offset) {
        return postDao.findAllPostsByCategory(category, limit, offset);
    }

    @Override
    public List<Post> findAllPostsByCategory(int categoryId, int limit, int offset) {
        return postDao.findAllPostsByCategory(categoryService.getCategoryById(categoryId), limit, offset);
    }

    @Override
    public List<Post> findAllPostsByHashtag(Hashtag hashtag, int limit, int offset) {
        return postDao.findAllPostsByHashtag(hashtag, limit, offset);
    }

    @Override
    public List<Post> findAllPostsByHashtag(int hashtagId, int limit, int offset) {
        return postDao.findAllPostsByHashtag(hashtagService.getHashtagById(hashtagId), limit, offset);
    }

    @Override
    public void deleteAllPostHashtagsFromPost(Post post) {
        postHashtagDao.deletePostHashtagByPost(post);
    }

    @Override
    public void deleteAllPostHashtagsFromPost(int postId) {
        postHashtagDao.deletePostHashtagByPost(getPostById(postId));
    }

    @Override
    public PostViewModel getPostViewModelByDate(Post post, int limit, int offset) {
        List<Post> posts = findAllPosts(limit, offset);
        return buildPostViewModelFromPost(post, posts, limit, offset);
    }

    @Override
    public PostViewModel getPostViewModelByHashtag(Post post, Integer hashtagId, int limit, int offset) {
        List<Post> posts = findAllPostsByHashtag(hashtagId, limit, offset);
        return buildPostViewModelFromPost(post, posts, limit, offset);
    }

    public PostViewModel getPostViewModelByCategory(Post post, Integer categoryId, int limit, int offset) {
        List<Post> posts = findAllPostsByCategory(categoryId, limit, offset);
        return buildPostViewModelFromPost(post, posts, limit, offset);
    }

    public List<SinglePostViewModel> findAllSinglePostViewModels(List<Post> posts, int limit, int offset) {

        List<SinglePostViewModel> spvms = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            SinglePostViewModel currentModel = new SinglePostViewModel();
            if (posts.size() > i) {
                Post post = posts.get(i);

                if (post.getUser().getUserId() > 0) {
                    post.setUser(userService.getUserById(post.getUser().getUserId()));
                }
                if (post.getCategory().getCategoryId() > 0) {
                    post.setCategory(categoryService.getCategoryById(post.getUser().getUserId()));
                }
                currentModel.setPost(post);
                currentModel.setHashtags(hashtagService.findAllHashtagsByPost(post, Integer.MAX_VALUE, 0));
                spvms.add(currentModel);
            }
        }
        return spvms;
    }

    @Override
    public SinglePostViewModel buildSinglePostViewModelFromPost(Post post) {
        SinglePostViewModel currentModel = new SinglePostViewModel();
        if (post.getUser().getUserId() > 0) {
            post.setUser(userService.getUserById(post.getUser().getUserId()));
        }
        if (post.getCategory().getCategoryId() > 0) {
            post.setCategory(categoryService.getCategoryById(post.getUser().getUserId()));
        }
        currentModel.setPost(post);
        currentModel.setHashtags(hashtagService.findAllHashtagsByPost(post, Integer.MAX_VALUE, 0));
        return currentModel;
    }

    public PostViewModel buildPostViewModelFromPost(Post post, List<Post> posts, int postLimit, int postOffset) {

        PostViewModel pvm = new PostViewModel();
        if (post.getUser().getUserId() > 0) {
            post.setUser(userService.getUserById(post.getUser().getUserId()));
        }
        if (post.getCategory().getCategoryId() > 0) {
            post.setCategory(categoryService.getCategoryById(post.getUser().getUserId()));
        }
        pvm.setSelectedPost(buildSinglePostViewModelFromPost(post));
        pvm.setSinglePostViewModels(findAllSinglePostViewModels(posts, postLimit, postOffset));
        pvm.setStaticPages(staticPageService.findAllStaticPages(Integer.MAX_VALUE, 0));
        pvm.setCategories(categoryService.findAllCategories(Integer.MAX_VALUE, 0));
        return pvm;
    }

    @Override
    public Post buildPostFromPostCommandModel(PostCommandModel pcm) {

        Post post = new Post();
        post.setPostId(pcm.getPostId());
        post.setUser(userService.getUserById(pcm.getUserId()));
        post.setStartDate(pcm.getStartDate());
        if (pcm.getEndDate() != null) {
            post.setEndDate(pcm.getEndDate());
        }
        post.setCreateDate(pcm.getCreateDate());
        if (pcm.getApprovalDate() != null) {
            post.setApprovalDate(pcm.getApprovalDate());
        }
        if (pcm.getApproval() != null) {
            post.setApproval(pcm.getApproval());
        }
        post.setPostTitle(pcm.getPostTitle());
        post.setPostContent(pcm.getPostContent());
        post.setCategory(categoryService.getCategoryById(pcm.getCategoryId()));
        
        return post;

    }

    @Override
    public Post createFirstPostAutomatically() {

        Post defaultPost = new Post();
        User defaultPostUser = new User();
        defaultPostUser.setUserId(0);
        defaultPostUser.setUserName("Default Post User");
        defaultPost.setUser(defaultPostUser);
        LocalDateTime ldt = LocalDateTime.now();
        defaultPost.setStartDate(ldt);
        defaultPost.setCreateDate(ldt);
        defaultPost.setApprovalDate(ldt);
        defaultPost.setApproval(true);
        defaultPost.setPostTitle("A Welcome Message");
        defaultPost.setPostContent("Welcome to this blog.");
        Category defaultPostCategory = new Category();
        defaultPostCategory.setCategoryId(0);
        defaultPostCategory.setCategoryName("Welcome");
        defaultPost.setCategory(defaultPostCategory);
        return defaultPost;

    }
}
