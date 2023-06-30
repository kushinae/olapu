package org.kushinae.olapu.core.event;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import lombok.extern.log4j.Log4j2;
import org.kushinae.heimerdinger.core.utils.JacksonUtils;
import org.kushinae.olapu.api.event.factory.DisruptorEventFactory;

import java.util.concurrent.Executors;

/**
 * @author kaisa.liu
 * @since 1.0.0
 */
@Log4j2
public abstract class AbstractDisruptorEvent<M> extends AbstractJobEventGroup<M> implements EventHandler<M> {

    @Override
    public void publisher(String topic, M message) {
        Disruptor<M> disruptor = new Disruptor<>(
                new DisruptorEventFactory<>(message),
                1024 * 1024,
                Executors.defaultThreadFactory()
        );
        disruptor.handleEventsWith(this);
        disruptor.start();
        RingBuffer<M> ringBuffer = disruptor.getRingBuffer();
        long next = ringBuffer.next();
        M payload = ringBuffer.get(next);
        if (log.isInfoEnabled()) {
            log.info("Ring buffer next {} of data with {}", next, JacksonUtils.toJsonString(payload));
        }
        ringBuffer.publish(next);
    }

    @Override
    public void onEvent(M event, long sequence, boolean endOfBatch) throws Exception {
        if (log.isInfoEnabled()) {
            log.info("event: {}, sequence: {}, endOfBatch: {}", event, sequence, endOfBatch);
        }
        subscription(event);
    }
}
