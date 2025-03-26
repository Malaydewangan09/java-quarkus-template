# AsyncAPI Generator Template for Java Quarkus

This template generates a Quarkus-based application from your AsyncAPI specification. It supports multiple messaging protocols including AMQP, MQTT, and Kafka.

## Features

- 🚀 **Quarkus Native Support**: Optimized for cloud-native development
- 🔄 **Multiple Protocol Support**:
  - AMQP (Advanced Message Queuing Protocol)
  - MQTT (Message Queuing Telemetry Transport)
  - Kafka (with secure and non-secure options)
- 📦 **Reactive Messaging**: Built on Quarkus Reactive Messaging
- 🛠️ **Clean Architecture**: Follows best practices for maintainable code
- 🔧 **Configurable**: Easy to customize through AsyncAPI parameters

## Prerequisites

- Java 17 or later
- Maven 3.8+
- Quarkus CLI (optional)

## Usage

1. Install the AsyncAPI Generator:
```bash
npm install -g @asyncapi/generator
```

2. Generate your Quarkus application:
```bash
ag your-asyncapi.yaml @asyncapi/java-quarkus-template -o output
```

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/asyncapi/
│   │       ├── Application.java
│   │       ├── infrastructure/
│   │       │   ├── Config.java
│   │       │   └── [Protocol]Config.java
│   │       ├── model/
│   │       │   └── Message.java
│   │       └── service/
│   │           └── MessageService.java
│   └── resources/
│       └── application.yml
└── test/
    └── java/
        └── com/asyncapi/
            └── MessageServiceTest.java
```

## Configuration

The template supports configuration through `application.yml`:

```yaml
quarkus:
  application:
    name: asyncapi-quarkus-template
  http:
    port: 8080
  kafka:
    bootstrap-servers: localhost:9092
    consumer:
      group-id: asyncapi-group
      auto-offset-reset: earliest
    producer:
      acks: all
```

## Development

### Building the Template

```bash
npm install
npm run build
```

### Running Tests

```bash
npm test
```

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [AsyncAPI](https://www.asyncapi.com/)
- [Quarkus](https://quarkus.io/)
- [Eclipse MicroProfile](https://microprofile.io/)
