package {{ params['userJavaPackage'] }}.infrastructure;

import io.smallrye.reactive.messaging.kafka.KafkaConnector;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import java.util.Map;
import java.util.HashMap;

@ApplicationScoped
public class KafkaConfig {
    {%- for channelName, channel in asyncapi.channels() %}
    {%- if channel.subscribe() %}
    @ConfigProperty(name = "kafka.bootstrap.servers")
    String bootstrapServers;

    @ConfigProperty(name = "kafka.consumer.group.id")
    String groupId;

    @ConfigProperty(name = "kafka.consumer.auto.offset.reset")
    String autoOffsetReset;

    @Produces
    public Map<String, Object> kafkaConsumerConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("bootstrap.servers", bootstrapServers);
        config.put("group.id", groupId);
        config.put("auto.offset.reset", autoOffsetReset);
        config.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        config.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        return config;
    }

    @Incoming("{{ channelName }}")
    @Outgoing("{{ channelName }}-processed")
    public String processMessage(String message) {
        return message;
    }
    {%- endif %}
    {%- endfor %}
} 