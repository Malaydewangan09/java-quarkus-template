package {{ params['userJavaPackage'] }}.infrastructure;

import io.smallrye.reactive.messaging.mqtt.MqttConnector;
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
public class MqttConfig {
    {%- for channelName, channel in asyncapi.channels() %}
    {%- if channel.subscribe() %}
    @ConfigProperty(name = "mqtt-host")
    String host;

    @ConfigProperty(name = "mqtt-port")
    int port;

    @ConfigProperty(name = "mqtt-username")
    String username;

    @ConfigProperty(name = "mqtt-password")
    String password;

    @ConfigProperty(name = "mqtt-client-id")
    String clientId;

    @Produces
    public Map<String, Object> mqttConsumerConfig() {
        Map<String, Object> config = new HashMap<>();
        config.put("host", host);
        config.put("port", port);
        config.put("username", username);
        config.put("password", password);
        config.put("client-id", clientId);
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