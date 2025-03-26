package {{ params['userJavaPackage'] }}.infrastructure;

import java.util.concurrent.CompletableFuture;

public interface CommonPublisher {
    CompletableFuture<Void> publish(String topic, String message);
    CompletableFuture<Void> publish(String topic, String key, String message);
} 