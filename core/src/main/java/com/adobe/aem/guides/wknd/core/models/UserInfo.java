package com.adobe.aem.guides.wknd.core.models;

import java.util.List;

public interface UserInfo {

    public String getUserId();

    public String getUserName();

    public List<String> getUserGroups();
}
