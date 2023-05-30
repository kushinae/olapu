package org.kushinae.olapu.api.service;

import org.kushinae.olapu.api.pojo.api.generate.GeneratePayload;
import org.kushinae.olapu.generate.Record;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface GenerateService {
    Record generate(GeneratePayload generatePayload);
}
