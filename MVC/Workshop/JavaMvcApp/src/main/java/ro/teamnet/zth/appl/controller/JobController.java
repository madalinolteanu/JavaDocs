package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.*;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.service.JobService;
import ro.teamnet.zth.appl.service.impl.JobServiceImpl;

import java.util.List;

/**
 * Created by user on 7/18/2016.
 */
@MyController(urlPath = "/jobs")
public class JobController {

    private final JobService jobService = new JobServiceImpl();

   /* @InjectService
    public JobController(JobService jobService) {
        //Class.class.newInstance()
        this.jobService = jobService;
    }*/
    @MyRequestMethod(urlPath = "/all")
    public List<Job> getAllJobs(){

        return jobService.findAllJobs();
    }
    @MyRequestMethod(urlPath = "/one")
    public Job getOneJob(@MyRequestParam(name="id") String id)  {
        JobServiceImpl employeeService = new JobServiceImpl();
        return employeeService.findOneJob(id);
    }
    @MyRequestMethod(urlPath = "/one",methodType = "DELETE")
    public void deleteOneJob(@MyRequestParam(name="id") String id){
        jobService.deleteJob(id);
    }
    @MyRequestMethod(urlPath = "/create",methodType = "CREATE")
    public Job saveJob(@MyRequestObject Job job){

        return jobService.create(job);
    }
/*    @MyRequestMethod(urlPath = "/create",methodType = "POT")
    public Job update*/


}
