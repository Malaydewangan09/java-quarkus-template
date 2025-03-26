package {{ params['userJavaPackage'] }}.infrastructure;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

{%- from "partials/AmqpConfig.java" import amqpConfig -%}
{%- from "partials/MqttConfig.java" import mqttConfig -%}
{%- from "partials/KafkaConfig.java" import kafkaConfig -%}

@ApplicationScoped
public class Config {
    {%- if asyncapi | isProtocol('amqp') -%}
    {{- amqpConfig(asyncapi, params) -}}
    {%- endif -%}
    {%- if asyncapi | isProtocol('mqtt') -%}
    {{- mqttConfig(asyncapi, params) -}}
    {%- endif -%}
    {%- if (asyncapi | isProtocol('kafka')) or (asyncapi | isProtocol('kafka-secure')) -%}
    {{- kafkaConfig(asyncapi, params) -}}
    {%- endif -%}

    @Channel("common-out")
    Emitter<String> commonEmitter;

    @Produces
    public Emitter<String> commonEmitter() {
        return commonEmitter;
    }
}