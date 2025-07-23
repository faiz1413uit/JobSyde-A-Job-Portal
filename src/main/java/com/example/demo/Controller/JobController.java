package com.example.demo.Controller;

import com.example.demo.Entity.Applied;
import com.example.demo.Entity.Jobseeker;
import com.example.demo.Entity.PostJob;
import com.example.demo.Service.AppliedService;
import com.example.demo.Service.JobSeekerServices;
import com.example.demo.Service.JobService;

import jakarta.servlet.http.HttpSession;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class JobController {

    @Autowired
    JobService jserve;

    @Autowired
    JobSeekerServices jsserve;

    @Autowired
    AppliedService aserve;

    // Post Job (Requires session)
    @PostMapping("/insertjob")
    public String postJob(HttpSession session, Model m,
                          @RequestParam String jobtitle,
                          @RequestParam String company,
                          @RequestParam String type,
                          @RequestParam String location,
                          @RequestParam String experience,
                          @RequestParam String salary,
                          @RequestParam String description) {
        
        String phn = (String) session.getAttribute("username");
        if (phn == null) {
            return "redirect:/login";
        }

        PostJob p = new PostJob(jobtitle, company, type, location, experience, salary, description, phn);
        jserve.insertJob(p);
        m.addAttribute("msg", "Job Inserted Successfully");

        return "postjob";
    }

    // Public View for Jobs
    @GetMapping("/applyjob")
    public String applyJob(Model m) {
        Iterable<PostJob> jobs = jserve.printJob();
        m.addAttribute("records", jobs);
        return "applyjob";
    }

    // Apply for a Job 
    @GetMapping("/getJob")
    public String getJob(@RequestParam String phn, HttpSession session, Model m) {
        String seekerPhn = (String) session.getAttribute("username");
        if (seekerPhn == null) {
            return "redirect:/serviceLogin";
        }

        List<Jobseeker> seekerList = jsserve.searchByPhn(seekerPhn);
        if (seekerList == null || seekerList.isEmpty()) {
            session.invalidate();
            return "redirect:/serviceLogin";
        }

        Jobseeker js = seekerList.get(0);

        Applied application = new Applied(
                js.getFirstName(),
                js.getLastName(),
                js.getJobType(),
                js.getDescription(),
                js.getCity(),
                js.getPhn(),
                phn,
                js.getRating()
        );

        aserve.insert(application);
        m.addAttribute("msg", "Successfully Applied!");
        Iterable<PostJob> jobs = jserve.printJob();
        m.addAttribute("records", jobs);

        return "applyjob";
    }

    // Search Jobs by Title or Company
    @PostMapping("/search")
    public String search(@RequestParam String temp, Model m) {
        List<PostJob> p = jserve.SearchJob(temp);

        if (p.isEmpty()) {
            p = jserve.SearchCompany(temp);
            if (p.isEmpty()) {
                m.addAttribute("msg", "No Such Item Found");
            } else {
                m.addAttribute("records", p);
            }
        } else {
            m.addAttribute("records", p);
        }

        return "search";
    }
    
    @GetMapping("/dashboard")
	public String dashboard(Model m,HttpSession session) 
    {	
    	String phn=(String)session.getAttribute("username");
    	if(phn!=null)
    	{
    		List<Applied> list=aserve.findUser(phn);
    		if(!list.isEmpty())
    		{
    			m.addAttribute("records",list);
    		}
    		return "dashboard";
    	}
    	
    	else {
    		return "redirect:/login";
    	}
	}
}
