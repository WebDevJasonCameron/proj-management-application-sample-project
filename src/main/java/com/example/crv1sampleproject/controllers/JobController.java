package com.example.crv1sampleproject.controllers;

import com.example.crv1sampleproject.models.Job;
import com.example.crv1sampleproject.repositories.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        job.setStatus("New");

        jobDao.save(job);

        return "redirect:/jobs/result/" + job.getId();
    }

    @GetMapping("/result/{id}")
    public String showJobCreationResultPage(@PathVariable long id,
                                            Model model){

        Job job = jobDao.getReferenceById(id);

        model.addAttribute("job", job);


        return "/jobs/result";
    }

    @GetMapping("/result")
    public String showFindByIdResultPage(@RequestParam long id,
                                         Model model){
        Job job = jobDao.getReferenceById(id);

        model.addAttribute("job", job);

        return "/jobs/result";
    }


    @GetMapping("/find")
    public String showFindByIdPage(){

        return "/jobs/find-by-id";
    }

    @PostMapping("/start")
    public String startJobInDB(@RequestParam(name = "id") Long id){

        Job job = jobDao.getReferenceById(id);
        job.setStatus("In Progress");

        jobDao.save(job);

        // SEND TO KAFKA FROM HERE........

        return "redirect:/";
    }

}
