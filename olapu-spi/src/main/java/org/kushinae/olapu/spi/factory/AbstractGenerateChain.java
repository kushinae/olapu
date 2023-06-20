package org.kushinae.olapu.spi.factory;

import org.kushinae.olapu.core.job.entities.generate.GenerateJob;
import org.kushinae.olapu.generate.GenerateChain;
import org.kushinae.olapu.generate.LanguageModelRecord;
import org.kushinae.olapu.generate.LanguageRecord;
import org.kushinae.olapu.generate.Record;
import org.kushinae.olapu.generate.RecordResolver;
import org.kushinae.olapu.generate.adapter.HandlerAdapter;
import org.kushinae.olapu.generate.chain.ExecutionChain;
import org.kushinae.olapu.generate.dispatcher.Dispatcher;
import org.kushinae.olapu.generate.executor.Executor;
import org.kushinae.olapu.generate.executor.ExecutorResolver;
import org.kushinae.olapu.generate.handler.Handler;
import org.kushinae.olapu.generate.mapping.HandlerMapping;
import org.kushinae.olapu.spi.factory.dispatcher.DefaultDispatcherFactory;

import java.util.List;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
public abstract class AbstractGenerateChain implements GenerateChain {

    @Override
    public Record chain(GenerateJob job) {
        Record record = new Record();
        Dispatcher dispatcher = getDispatcher(job);
        ExecutionChain executionChain = dispatcher.getExecutionChain(job);
        HandlerMapping handlerMapping = executionChain.getHandlerMapping();
        HandlerAdapter handlerAdapter = handlerMapping.getHandlerAdapter();
        Handler handler = handlerAdapter.getHandler(job);
        String template = handler.getTemplate(job);
        ExecutorResolver executorResolver = handler.getExecutorResolver();
        RecordResolver resolver = executorResolver.resolver(job, template);
        Executor executor = executorResolver.getExecutor();
        String out = executor.executor(resolver);
        LanguageRecord languageRecord = record.get(handler.getLanguage()) == null ? new LanguageRecord() : record.get(handler.getLanguage());
        LanguageModelRecord languageModelRecord = new LanguageModelRecord();
        languageModelRecord.setOut(out);
        languageRecord.put(handler.getModelType(), languageModelRecord);
        record.put(handler.getLanguage(), languageRecord);
        return record;
    }

    @Override
    public Dispatcher getDispatcher(GenerateJob job) {
        DefaultDispatcherFactory dispatcherFactory = new DefaultDispatcherFactory();
        return dispatcherFactory.getFactory(job.getSettings().getLanguage());
    }
}
