package org.kushinae.olapu.api.convert;

import org.kushinae.olapu.interfaces.pojo.api.account.RegisterPayload;
import org.kushinae.olapu.repository.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountConvert {

    AccountConvert INSTANCE = Mappers.getMapper(AccountConvert.class);

    Account registerToDomain(RegisterPayload register);

}
