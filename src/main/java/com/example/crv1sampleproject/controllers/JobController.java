package com.example.crv1sampleproject.controllers;

import com.example.crv1sampleproject.models.Job;
import com.example.crv1sampleproject.repositories.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jobs")
public class JobController {

    // ATT: DAO
    private final JobRepository jobDao;

    // CON
    public JobController(JobRepository jobDao) {
        this.jobDao = jobDao;
    }


    // MAPS
    @GetMapping("/create")
    public String showJobCreatePage(Model model){

        Job job = new Job();
        model.addAttribute("job", job);

        return "/jobs/create";
    }

    @PostMapping("/create")
    public String submitJobCreation(@RequestParam(name = "title") String title,
                                    @RequestParam(name = "details") String details,
                                    Model model){

        Job job = new Job();
        job.setTitle(title);
        job.setDetails(details);
        job.setStatus("new");

        jobDao.save(job);

        model.addAttribute("job", job);

        return "redirect:/jobs/creation-result";
    }

    @GetMapping("/creation-result")
    public String showJobCreationResultPage(Model model){


        return "/jobs/creation-result";
    }

}
