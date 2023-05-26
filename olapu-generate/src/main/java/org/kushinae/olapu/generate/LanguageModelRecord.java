package org.kushinae.olapu.generate;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public class LanguageModelRecord {
    private String out;

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    @Override
    public String toString() {
        return "LanguageModelRecord{" +
                "out='" + out + '\'' +
                '}';
    }
}
