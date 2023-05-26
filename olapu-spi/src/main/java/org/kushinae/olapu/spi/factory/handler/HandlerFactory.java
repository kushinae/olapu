package org.kushinae.olapu.spi.factory.handler;

import org.kushinae.olapu.generate.Language;
import org.kushinae.olapu.generate.handler.Handler;
import org.kushinae.olapu.spi.factory.Factory;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public interface HandlerFactory extends Factory<List<Handler>, Language> {
}
