package org.kushinae.olapu.api.service.impl;

import jakarta.annotation.Resource;
import jakarta.persistence.criteria.Predicate;
import org.kushinae.olapu.api.http.ErrorMessage;
import org.kushinae.olapu.interfaces.service.IDatasourceService;
import org.kushinae.olapu.interfaces.service.IResourceService;
import org.kushinae.olapu.api.util.AbstractAssert;
import org.kushinae.olapu.api.util.StringUtils;
import org.kushinae.olapu.interfaces.pojo.api.SearchPayload;
import org.kushinae.olapu.repository.entities.Datasource;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.kushinae.olapu.repository.repository.impl.DatasourceRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Service
public class IDatasourceServiceImpl implements IDatasourceService {

    @Resource
    DatasourceRepository datasourceRepository;

    @Resource
    IResourceService IResourceService;

    @Override
    public DatasourceRepository getRepository() {
        return datasourceRepository;
    }

    @Override
    public Long create(Datasource entity) {
        Datasource datasource = getRepository().searchByNameAndUidAndType(entity.getName(), entity.getUid(), entity.getType());
        AbstractAssert.isNull(datasource, ErrorMessage.DATASOURCE_ALREADY_EXISTS);
        entity.setCreateAt(new Date());
        entity.setModifiedAt(new Date());
        entity.setDeleted(false);

        return getRepository().save(entity).getId();
    }

    @Override
    public Datasource queryTemplate(DatasourceType type) {
        return getRepository().searchByTypeAndTemplateIsTrue(type);
    }

    @Override
    public Datasource queryById(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.DATASOURCE_DOES_NOT_EXIST.getCode()));
    }

    @Override
    public List<DatasourceType> supports() {
        return Arrays.stream(DatasourceType.values()).toList();
    }

    @Override
    public Page<Datasource> search(SearchPayload<String> search) {
        PageRequest pageable = PageRequest.of(search.getCurrent(), search.getQueryCount());
        Specification<Datasource> specification = (root, query, criteriaBuilder) -> {
            if (StringUtils.hasText(search.getQuery())) {
                Predicate like = criteriaBuilder.like(root.get("name").as(String.class), "%" + search.getQuery() + "%");
                criteriaBuilder.and(like);
            }
            criteriaBuilder.and(criteriaBuilder.equal(root.get("uid").as(String.class), search.getUid()));
            return criteriaBuilder.and(criteriaBuilder.equal(root.get("template").as(Boolean.class), false));
        };
        return getRepository().findAll(specification, pageable);
    }

}
