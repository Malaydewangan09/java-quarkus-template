package {{ params['userJavaPackage'] }}.infrastructure;

import io.smallrye.reactive.messaging.amqp.AmqpConnector;
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
public class AmqpConfig {
    {%- for channelName, channel in asyncapi.channels() %}
    {%- if channel.subscribe() %}
    @ConfigProperty(name = "amqp-host")
    String host;

    @ConfigProperty(name = "amqp-port")
    int port;

    @ConfigProperty(name = "amqp-username")
    String username;

    @ConfigProperty(name = "amqp-password")
    String password;

    @Produces
    public Map<String, Object> amqpConsumerConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("host", host);
        config.put("port", port);
        config.put("username", username);
        config.put("password", password);
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