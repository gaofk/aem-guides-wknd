package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.OSGiConfigDemo;
import com.adobe.aem.guides.wknd.core.services.OSGiConfig;
import com.adobe.aem.guides.wknd.core.services.OSGiConfigModule;
import com.adobe.aem.guides.wknd.core.services.OSGiFactoryConfig;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import java.util.List;

@Model(adaptables = SlingHttpServletRequest.class, adapters = OSGiConfigDemo.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class OSGiConfigDemoImpl implements OSGiConfigDemo {

    @OSGiService
    OSGiConfig oSGiConfig;

    @Override
    public String getServiceName() {
        return oSGiConfig.getServiceName();
    }

    @Override
    public int getServiceCount() {
        return oSGiConfig.getServiceCount();
    }

    @Override
    public boolean isLiveData() {
        return oSGiConfig.isLiveData();
    }

    @Override
    public String[] getCountries() {
        return oSGiConfig.getCountries();
    }

    @Override
    public String getRunModes() {
        return oSGiConfig.getRunModes();
    }

    @OSGiService
    OSGiConfigModule oSGiConfigModule;

    @Override
    public int getServiceId() {
        return oSGiConfigModule.getServiceId();
    }

    @Override
    public String getServiceNameModule() {
        return oSGiConfigModule.getServiceName();
    }

    @Override
    public String getServiceURL() {
        return oSGiConfigModule.getServiceURL();
    }

    @OSGiService
    OSGiFactoryConfig oSGiFactoryConfig;

    @Override
    public List<OSGiFactoryConfig> getAllOSGiConfigs() {
        return oSGiFactoryConfig.getAllConfigs();
    }
}
