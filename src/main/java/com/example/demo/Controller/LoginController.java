package com.example.demo.Controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.CustomerRegisteration;
import com.example.demo.Entity.Jobseeker;
import com.example.demo.Service.CustomerService;
import com.example.demo.Service.JobSeekerServices;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    CustomerService cserve;
    
    @Autowired
    JobSeekerServices jserve;

    @PostMapping("/register")
    public String Register(Model m, 
                           @RequestParam String fname, 
                           @RequestParam String lname, 
                           @RequestParam String email, 
                           @RequestParam String phn, 
                           @RequestParam String address, 
                           @RequestParam String pass, 
                           @RequestParam String confirm, 
                           HttpSession session) {
        if (cserve.checkPhn(phn)) {
            m.addAttribute("msg", "Phone Number Already Registered");
            return "customerRegistration";
        }

        if (pass.equals(confirm)) {
            CustomerRegisteration customer = new CustomerRegisteration(phn, fname, lname, email, address, pass);
            cserve.insertCustomer(customer);
            session.setAttribute("username", phn); // Corrected here
            session.setAttribute("role", "customer");
        } else {
            m.addAttribute("msg", "Passwords Not Matching");
            return "customerRegistration";
        }

        return "redirect:/login";
    }

    @PostMapping("/loginres")
    public String login(HttpSession session,
                        @RequestParam String phnno, 
                        @RequestParam String password, 
                        Model m) {
        if (!cserve.checkPhn(phnno)) {
            m.addAttribute("msg", "Invalid Phone Number");
            return "login";
        }

        List<CustomerRegisteration> cr = cserve.Search(phnno, password);
        if (!cr.isEmpty()) {
            session.setAttribute("username", phnno); // Corrected variable
            session.setAttribute("role", "customer");
            return "redirect:/";
        } else {
            m.addAttribute("msg", "Invalid Password");
            return "login";
        }
    }

    @PostMapping("/jsregister")
    public String jsregister(HttpSession session,
                             @RequestParam String FirstName,
                             @RequestParam String LastName,
                             @RequestParam String JobType,
                             @RequestParam String Description,
                             @RequestParam String Aadharno,
                             @RequestParam String city,
                             @RequestParam String email,
                             @RequestParam String phn,
                             @RequestParam String pass,
                             @RequestParam String cpass,
                             Model m) {
        if (jserve.checkPhn(phn)) {
            m.addAttribute("msg", "Phone Number Already Registered");
            return "createprofile";
        }

        if (pass.equals(cpass)) {
            Random random = new Random();
            float min = 3.7f;
            float max = 4.5f;
            float rating = min + random.nextFloat() * (max - min);

            Jobseeker js = new Jobseeker(Aadharno, FirstName, LastName, JobType, Description, city, email, phn, pass, String.format("%.1f", rating));
            jserve.insertCustomer(js);
            session.setAttribute("username", phn); // Corrected
            session.setAttribute("role", "jobseeker");
        } else {
            m.addAttribute("msg", "Passwords Not Matching");
            return "createprofile";
        }

        return "redirect:/serviceLogin";
    }

    @PostMapping("/jslogin")
    public String jslogin(HttpSession session, 
                          @RequestParam String phn, 
                          @RequestParam String password, 
                          Model m) {
        if (!jserve.checkPhn(phn)) {
            m.addAttribute("msg", "Invalid Phone Number");
            return "servicelogin";
        }

        List<Jobseeker> js = jserve.Search(phn, password);
        if (!js.isEmpty()) {
            session.setAttribute("username", phn); // Corrected
            session.setAttribute("role", "jobseeker");
            return "redirect:/";
        } else {
            m.addAttribute("msg", "Invalid Password");
            return "servicelogin";
        }
    }

    @PostMapping("/searchEmployee")
    public String searchEmployee(@RequestParam String jobtype, 
                                 @RequestParam String city, 
                                 Model m) {
        List<Jobseeker> e = jserve.serviceSearch(jobtype, city);
        m.addAttribute("employee", e);
        return "hire";
    }
}
