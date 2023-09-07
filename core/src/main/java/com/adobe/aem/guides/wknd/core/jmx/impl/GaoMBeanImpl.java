package com.adobe.aem.guides.wknd.core.jmx.impl;

import com.adobe.aem.guides.wknd.core.jmx.GaoMBean;
import com.adobe.granite.jmx.annotation.AnnotatedStandardMBean;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.DynamicMBean;
import javax.management.NotCompliantMBeanException;

@Component(immediate = true, service = DynamicMBean.class, property = {
        "jmx.objectname = com.adobe.aem.guides.wknd.core.jmx:type=Gao MBean"
})
public class GaoMBeanImpl extends AnnotatedStandardMBean implements GaoMBean {

    private static final Logger LOG = LoggerFactory.getLogger(GaoMBeanImpl.class);

    public GaoMBeanImpl() throws NotCompliantMBeanException {
        super(GaoMBeanImpl.class);
    }

    @Override
    public String getAuthorName(String authorName) {
        LOG.info("\n ==========Calling GaoMBean===========");
        return authorName;
    }
}
