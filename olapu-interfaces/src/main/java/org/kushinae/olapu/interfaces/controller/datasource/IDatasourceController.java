package org.kushinae.olapu.interfaces.controller.datasource;

import org.kushinae.olapu.interfaces.controller.IController;
import org.kushinae.olapu.interfaces.pojo.api.datasource.CreatePayload;
import org.kushinae.olapu.interfaces.service.IDatasourceService;
import org.kushinae.olapu.interfaces.vo.Page;
import org.kushinae.olapu.interfaces.vo.datasource.DatasourceInfo;
import org.kushinae.olapu.repository.enums.DatasourceType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@RequestMapping("/datasource")
public interface IDatasourceController extends IController {

    @PostMapping
    Long create(@RequestBody CreatePayload createPayload);

    @GetMapping("/supports")
    List<DatasourceType> supports();

    @GetMapping("/search")
    Page<DatasourceInfo> search(@RequestParam(value = "current", defaultValue = "1", required = false) Integer current,
                                       @RequestParam(value = "query_count", defaultValue = "10") Integer queryCount,
                                       @RequestParam(value = "q", required = false) String query);

    @Override
    IDatasourceService getService();
}
