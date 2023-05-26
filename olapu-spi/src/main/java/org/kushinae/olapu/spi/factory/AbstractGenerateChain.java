package org.kushinae.olapu.spi.factory;

import org.kushinae.olapu.generate.BuildOption;
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
    public Record chain(BuildOption option) {
        Record record = new Record();
        DefaultDispatcherFactory dispatcherFactory = new DefaultDispatcherFactory();
        Dispatcher dispatcher = dispatcherFactory.getFactory(option.getLanguage());
        ExecutionChain executionChain = dispatcher.getExecutionChain(option);
        HandlerMapping handlerMapping = executionChain.getHandlerMapping();
        HandlerAdapter handlerAdapter = handlerMapping.getHandlerAdapter();
        List<Handler> handlers = handlerAdapter.getHandlers(option);
        for (Handler handler : handlers) {
            String template = handler.getTemplate(option);
            ExecutorResolver executorResolver = handler.getExecutorResolver();
            RecordResolver resolver = executorResolver.resolver(option, template);
            Executor executor = executorResolver.getExecutor();
            String out = executor.executor(resolver);
            LanguageRecord languageRecord = record.get(handler.getLanguage()) == null ? new LanguageRecord() : record.get(handler.getLanguage());
            LanguageModelRecord languageModelRecord = new LanguageModelRecord();
            languageModelRecord.setOut(out);
            languageRecord.put(handler.getModelType(), languageModelRecord);
            record.put(handler.getLanguage(), languageRecord);
        }
        return record;
    }
}
