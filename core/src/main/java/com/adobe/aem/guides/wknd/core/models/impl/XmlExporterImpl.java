package com.adobe.aem.guides.wknd.core.models.impl;

import com.adobe.aem.guides.wknd.core.models.XmlExporter;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.Resource;
import javax.inject.Inject;
import javax.xml.bind.annotation.*;
import java.util.*;

@Exporter(name = "wkndxml", extensions = "xml", selector = "gao")
@Model(adaptables = SlingHttpServletRequest.class, adapters = XmlExporter.class, resourceType = XmlExporterImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@XmlRootElement(name = "gao-exporter")
public class XmlExporterImpl implements XmlExporter {
    static final String RESOURCE_TYPE = "wknd/components/xmlexporter";

    private static final Logger LOG = LoggerFactory.getLogger(XmlExporterImpl.class);

    @Inject
    Resource componentResource;

    @ValueMapValue
    String xmltitle;

    @ValueMapValue
    String xmldescription;

    @ValueMapValue
    Calendar xmldate;

    @ValueMapValue
    private List<String> books;

    List<Map<String, String>> bookDetailsMap;

    @Override
    @XmlElement(name = "author-title")
    public String getTitle() {
        return xmltitle;
    }

    @Override
    @XmlElement(name = "author-description")
    public String getDescription() {
        return xmldescription;
    }

    @Override
    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    public List<String> getBooks() {
        if (books != null) {
            return new ArrayList<String>(books);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    @XmlElement(name = "publish-date")
    public Calendar getDate() {
        return xmldate;
    }

    @XmlElement(name = "author-name")
    public String getAuthorName() {
        return "GAO WKND";
    }

}
