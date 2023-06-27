package org.kushinae.olapu.api.service;

import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.interfaces.pojo.api.generate.GeneratePayload;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface GenerateService {
    Record generate(GeneratePayload generatePayload);
}
