package org.kushinae.olapu.core.utils;

import org.junit.jupiter.api.Test;
import org.kushinae.olapu.core.job.entities.generate.GenerateJob;

import static org.junit.jupiter.api.Assertions.*;

class JacksonUtilsTest {

    @Test
    void toJavaBean() {
        GenerateJob bean = JacksonUtils.toJavaBean("""
                {
                    "columns": [
                        {
                            "name": "username",
                            "datatype": "String",
                            "comment": "用户名称"
                        }
                    ],
                    "table": "Account",
                    "settings": {
                        "language": "java",
                        "model": "entity",
                        "template": "public class ${className} {\\n\\t public static void main(String[] args) {\\n\\t\\tSystem.out.println(\\"Hello Olapu Generate!!!\\");\\n\\t}\\n}"
                    }
                }""", GenerateJob.class);
        System.out.println(bean);
        System.out.println(JacksonUtils.toJsonString(bean));
    }
}