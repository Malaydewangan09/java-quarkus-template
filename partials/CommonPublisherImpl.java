package {{ params['userJavaPackage'] }}.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;

import java.util.concurrent.CompletableFuture;

@ApplicationScoped
public class CommonPublisherImpl implements CommonPublisher {
    @Channel("common-out")
    Emitter<String> emitter;

    @Override
    public CompletableFuture<Void> publish(String topic, String message) {
        return publish(topic, null, message);
    }

    @Override
    public CompletableFuture<Void> publish(String topic, String key, String message) {
        Message<String> messageObj = Message.of(message);
        return emitter.send(messageObj).toCompletableFuture();
    }
} 