package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.domain.Job;

import java.util.List;

/**
 * Created by user on 7/18/2016.
 */
public interface JobService {
    List<Job> findAllJobs();
    Job findOneJob(String Id);
    void deleteJob(String id);
    void create(Job job);
}
