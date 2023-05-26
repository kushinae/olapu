package org.kushinae.olapu.generate;

import java.util.Map;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class RecordResolver {

    private String template;

    private Map<String, Object> dataModel;

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public Map<String, Object> getDataModel() {
        return dataModel;
    }

    public void setDataModel(Map<String, Object> dataModel) {
        this.dataModel = dataModel;
    }
}
