package org.kushinae.olapu.core.job.entities.generate;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class GenerateColumn {

    private String name;

    private String datatype;

    private String comment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
