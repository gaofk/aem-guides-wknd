package com.adobe.aem.guides.wknd.core.jmx;

import com.adobe.granite.jmx.annotation.Description;

public interface GaoMBean {
    @Description("Please enter Author Name")
    String getAuthorName(String authorName);
}
