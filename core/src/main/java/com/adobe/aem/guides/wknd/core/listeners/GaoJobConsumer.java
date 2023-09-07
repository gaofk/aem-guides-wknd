package com.adobe.aem.guides.wknd.core.listeners;

import com.adobe.aem.guides.wknd.core.utils.ResolverUtil;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.event.jobs.Job;
import org.apache.sling.event.jobs.consumer.JobConsumer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = JobConsumer.class, immediate = true, property = {
        JobConsumer.PROPERTY_TOPICS + "=gao/job"
})
public class GaoJobConsumer implements JobConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(GaoJobConsumer.class);

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    @Override
    public JobResult process(Job job) {
        try {
            ResourceResolver resourceResolver = ResolverUtil.newResolver(resourceResolverFactory);
            String path = (String) job.getProperty("path");
            String event = (String) job.getProperty("event");
            String demopage = (String) job.getProperty("demoPage");
            LOG.info("\n Job executing for  : {} ", resourceResolver.getResource(demopage).getName());
            return JobResult.OK;
        } catch (Exception e) {
            LOG.info("\n Error in Job Consumer : {}  ", e.getMessage());
            return JobResult.FAILED;
        }
    }
}
