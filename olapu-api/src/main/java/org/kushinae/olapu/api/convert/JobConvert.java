package org.kushinae.olapu.api.convert;

import org.kushinae.olapu.api.pojo.api.job.EditJobPayload;
import org.kushinae.olapu.api.vo.job.Detail;
import org.kushinae.olapu.repository.entities.Job;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobConvert {

    JobConvert INSTANCE = Mappers.getMapper(JobConvert.class);

    Job edit2Entity(EditJobPayload payload);

    Detail job2Detail(Job job);

}
