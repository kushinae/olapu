package org.kushinae.olapu.repository.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.kushinae.yone.commons.model.enums.EDataSourceType;

import java.beans.PropertyEditorSupport;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public enum DatasourceType implements AttributeConverterSupport<DatasourceType.Convert>, CodeSupport<String>  {

    MYSQL(EDataSourceType.MY_SQL.getCode(), EDataSourceType.MY_SQL.getName()),
    ;

    @Override
    public Convert getConvert() {
        return new DatasourceType.Convert();
    }

    @Override
    public String getCode() {
        return getYoneName();
    }

    @Converter(autoApply = true)
    public static class Convert extends PropertyEditorSupport implements AttributeConverter<DatasourceType, String> {

        @Override
        public String convertToDatabaseColumn(DatasourceType attribute) {
            return attribute.getYoneName();
        }

        @Override
        public DatasourceType convertToEntityAttribute(String dbData) {
            return matchByName(dbData);
        }

        @Override
        public void setAsText(String text) throws IllegalArgumentException {
            setValue(DatasourceType.matchByName(text));
        }
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static DatasourceType matchByName(String yoneName) {
        for (DatasourceType value : values()) {
            if (value.getYoneName().equals(yoneName)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported data source of the " + yoneName);
    }

    /**
     * 它意味着{@link EDataSourceType#getCode()}
     */
    private final Integer yoneCode;

    /**
     * 它意味着{@link EDataSourceType#getName()}
     */
    @JsonValue
    private final String yoneName;

    DatasourceType(Integer yoneCode, String yoneName) {
        this.yoneCode = yoneCode;
        this.yoneName = yoneName;
    }

    public Integer getYoneCode() {
        return yoneCode;
    }

    public String getYoneName() {
        return yoneName;
    }
}
