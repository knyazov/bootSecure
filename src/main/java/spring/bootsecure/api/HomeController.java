package spring.bootsecure.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.bootsecure.entities.Users;
import spring.bootsecure.services.UserService;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("currentUser", getCurrentUser());
        return "index";
    }

    @GetMapping("/login")
    public String enterPage(Model model) {
        model.addAttribute("currentUser", getCurrentUser());
        return "login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("currentUser", getCurrentUser());
        return "register";
    }

    @PostMapping("/signup")
    public String signUpPage(Model model,
                             @ModelAttribute(name = "userClass") Users userClass,
                             @RequestParam(name = "re_password") String re_password) {
        model.addAttribute("currentUser", getCurrentUser());
        if (userService.registerUser(userClass, re_password)) {
            return "redirect:/login";
        } else{
            return "redirect:/register?error";
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/profile")
    public String profilePage(Model model) {
        model.addAttribute("currentUser", getCurrentUser());
        return "profile";
    }

    private Users getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (Users) authentication.getPrincipal();
        }
        return null;
    }
}
