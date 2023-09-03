package com.adobe.aem.guides.wknd.core.config;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label = "Gao WKND - Context Aware Configuration", description = "Context Aware Configuration for GAO WKND.")
public @interface GaoWKNDCAConfig {

    @Property(label = "GAO WKND Country Site", description = "GAO WKND Site Name")
    String siteCountry() default "us";

    @Property(label = "GAO WKND Site Locale", description = "GAO WKND Site for for different languages")
    String siteLocale() default "en";

    @Property(label = "GAO WKND Site Admin", description = "GAO WKND Admin for updating country site.")
    String siteAdmin() default "gaowknd-service-user";

    @Property(label = "GAO WKND Site Section", description = "GAO WKND Site section for WKND site.")
    String siteSection() default "aem";
}
