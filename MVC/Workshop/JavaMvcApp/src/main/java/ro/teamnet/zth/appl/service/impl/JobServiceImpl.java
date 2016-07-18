package ro.teamnet.zth.appl.service.impl;

import ro.teamnet.zth.api.annotations.MyService;
import ro.teamnet.zth.appl.dao.JobDao;
import ro.teamnet.zth.appl.domain.Job;
import ro.teamnet.zth.appl.service.JobService;

import java.util.List;

/**
 * Created by user on 7/18/2016.
 */
@MyService
public class JobServiceImpl implements JobService{

    @Override
    public List<Job> findAllJobs() {
        JobDao entityDao = new JobDao();
        return entityDao.getAllJobs();
    }

    @Override
    public Job findOneJob(String id) {
        JobDao jobDao = new JobDao();
        return jobDao.getJobById(id);
    }

    @Override
    public void deleteJob(String id) {
        JobDao jobDao = new JobDao();
        jobDao.deleteJob(findOneJob(id));
    }

    @Override
    public void create(Job job) {
        JobDao jobDao = new JobDao();
        jobDao.insertJob(job);
    }
}
