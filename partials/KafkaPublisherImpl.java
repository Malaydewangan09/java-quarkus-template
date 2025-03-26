package {{ params['userJavaPackage'] }}.infrastructure;

import io.smallrye.reactive.messaging.kafka.KafkaRecord;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class KafkaPublisherImpl implements KafkaPublisher {
    @Channel("kafka-out")
    Emitter<String> emitter;

    @Override
    public CompletableFuture<Void> publish(String topic, String message) {
        return publish(topic, null, message);
    }

    @Override
    public CompletableFuture<Void> publish(String topic, String key, String message) {
        Message<String> kafkaMessage = KafkaRecord.of(topic, key, message);
        return emitter.send(kafkaMessage).toCompletableFuture();
    }
} 