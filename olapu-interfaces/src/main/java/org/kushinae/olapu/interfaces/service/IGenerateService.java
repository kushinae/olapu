package org.kushinae.olapu.interfaces.service;

import org.kushinae.heimerdinger.core.generate.Record;
import org.kushinae.olapu.interfaces.pojo.api.generate.GeneratePayload;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface IGenerateService extends IService {
    Record generate(GeneratePayload generatePayload);
}
