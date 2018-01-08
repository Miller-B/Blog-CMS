/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blog.Controller;

import Blog.CommandModel.HashtagCommandModel;
import Blog.Dto.Hashtag;
import Blog.Service.HashtagServiceInterface;
import Blog.ViewModel.HashtagViewModel;
import Blog.ViewModel.SingleHashtagViewModel;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jeffc
 */
@Controller
@RequestMapping({"AdminManageHashtags"})
public class HashtagController {

    private HashtagServiceInterface hashtagService;

    public HashtagController(HashtagServiceInterface hashtagService) {
        this.hashtagService = hashtagService;
    }

    @RequestMapping(value = "/displayHashtagPage", method = RequestMethod.GET)
    public String displayHashtagPage(Model model) {

        HashtagViewModel hvm = hashtagService.buildHashtagViewModelFromHashtag(
                hashtagService.createFirstHashtagAutomatically(), Integer.MAX_VALUE, 0);

        model.addAttribute("hvm", hvm);
        return "/AdminManageHashtags";

    }

    @RequestMapping(value = "/displayCreateHashtagPage", method = RequestMethod.GET)
    public String displayCreateHashtagPage(Model model) {

        return "/CreateHashtag";

    }

    @RequestMapping(value = "/CreateHashtag", method = RequestMethod.POST)
    public String createHashtag(@Valid @ModelAttribute("ucm") HashtagCommandModel hcm, BindingResult result) {

        Hashtag hashtag = hashtagService.buildHashtagFromHashtagCommandModel(hcm);
        hashtag = hashtagService.createHashtag(hashtag);

        return "redirect:/";

    }

    @RequestMapping(value = "/displayUpdateHashtagPage", method = RequestMethod.GET)
    public String displayUpdateHashtagPage(@RequestParam("hashtagId") Integer hashtagId, Model model) {

        SingleHashtagViewModel shvm = hashtagService.buildSingleHashtagViewModelFromHashtagId(hashtagId);
        model.addAttribute("shvm", shvm);

        return "/UpdateHashtag";

    }

    @RequestMapping(value = "/updateHashtag", method = RequestMethod.POST)
    public String updateHashtag(@Valid @ModelAttribute("hcm") HashtagCommandModel hcm, BindingResult result, Model model) {

        Hashtag hashtag = hashtagService.buildHashtagFromHashtagCommandModel(hcm);
        hashtag = hashtagService.updateHashtag(hashtag);

        HashtagViewModel hvm = hashtagService.buildHashtagViewModelFromHashtag(
        hashtagService.createFirstHashtagAutomatically(), Integer.MAX_VALUE, 0);

        model.addAttribute("hvm", hvm);
        
        return "/AdminManageHashtags";

    }

    @RequestMapping(value = "/displayDeleteHashtagPage", method = RequestMethod.GET)
    public String displayDeleteHashtagPage(@RequestParam("hashtagId") Integer hashtagId, Model model) {

        model.addAttribute("hashtagId", hashtagId);

        return "/DeleteHashtag";

    }

    @RequestMapping(value = "/DeleteHashtag", method = RequestMethod.POST)
    public String deleteHashtag(@RequestParam("hashtagId") Integer hashtagId, Model model) {

        try {
            hashtagService.deleteHashtag(hashtagId);
        } catch (Exception e) {

        }

        HashtagViewModel hvm = hashtagService.buildHashtagViewModelFromHashtag(
        hashtagService.createFirstHashtagAutomatically(), Integer.MAX_VALUE, 0);

        model.addAttribute("hvm", hvm);
        return "/AdminManageHashtags";

    }

}
