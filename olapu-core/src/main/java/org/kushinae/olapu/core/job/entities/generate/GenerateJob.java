package org.kushinae.olapu.core.job.entities.generate;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class GenerateJob {

    private GenerateSettings settings;

    private List<GenerateColumn> columns;

    private String table;

    public GenerateSettings getSettings() {
        return settings;
    }

    public void setSettings(GenerateSettings settings) {
        this.settings = settings;
    }

    public List<GenerateColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<GenerateColumn> columns) {
        this.columns = columns;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }
}
