# AsyncAPI Generator Template for Java Quarkus

[![AsyncAPI logo](./assets/github-repobanner-generic.png)](https://www.asyncapi.com)

Java Quarkus template for the [AsyncAPI Generator](https://github.com/asyncapi/generator).

---
[![License](https://img.shields.io/github/license/asyncapi/java-quarkus-template)](https://github.com/asyncapi/java-quarkus-template/blob/master/LICENSE)
[![npm](https://img.shields.io/npm/v/@asyncapi/java-quarkus-template?style=flat-square)](https://www.npmjs.com/package/@asyncapi/java-quarkus-template)
[![All Contributors](https://img.shields.io/badge/all_contributors-1-orange.svg?style=flat-square)](#contributors-)
![downloads](https://img.shields.io/npm/dm/@asyncapi/java-quarkus-template?style=flat-square)
---

<!-- toc is generated with GitHub Actions do not remove toc markers -->

<!-- toc -->

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Usage](#usage)
  * [AsyncAPI definitions](#asyncapi-definitions)
  * [Supported parameters](#supported-parameters)
  * [Examples](#examples)
- [Run it](#run-it)
- [Development](#development)
  * [Missing features](#missing-features)
- [Contributors ✨](#contributors-)

<!-- tocstop -->

## Features

- 🚀 **Quarkus Native Support**: Optimized for cloud-native development
- 🔄 **Multiple Protocol Support**:
  - ![AMQP](./assets/protocols/amqp.png) AMQP (Advanced Message Queuing Protocol)
  - ![MQTT](./assets/protocols/mqtt.png) MQTT (Message Queuing Telemetry Transport)
  - ![Kafka](./assets/protocols/kafka.png) Kafka (with secure and non-secure options)
- 📦 **Reactive Messaging**: Built on Quarkus Reactive Messaging
- 🛠️ **Clean Architecture**: Follows best practices for maintainable code
- 🔧 **Configurable**: Easy to customize through AsyncAPI parameters

## Prerequisites

- Java 17 or later
- Maven 3.8+
- Quarkus CLI (optional)

## Usage

Install AsyncAPI CLI, for details follow the [guide](https://www.asyncapi.com/tools/cli).

```bash
npm install -g @asyncapi/cli
```

Generate using CLI.

```bash
asyncapi generate fromTemplate <asyncapi.yaml> @asyncapi/java-quarkus-template
```

You can replace `<asyncapi.yaml>` with local path or URL pointing to [any AsyncAPI document](https://raw.githubusercontent.com/asyncapi/java-quarkus-template/master/tests/mocks/kafka.yml).

### AsyncAPI definitions
To have correctly generated code, your AsyncAPI file MUST define `operationId` for every operation.

In order for the generator to know what names to use for some parameters [AsyncAPI specification bindings](https://www.asyncapi.com/docs/reference/specification/v2.0.0#operationBindingsObject) SHOULD be used.

It is RECOMMENDED to not use anonymous objects in payload and components definition, if changing of data model is not possible, you MAY use `$id` to set name of element.

### Supported parameters

|Name|Description| Required | Default                  |
|---|---|----------|--------------------------|
|javaPackage|The Java package of the generated classes. Alternatively you can set the specification extension `info.x-java-package`. If both extension and parameter are used, parameter has more priority.| No       | `com.asyncapi`           |
|listenerPollTimeout|Only for Kafka. Timeout in ms to use when polling the consumer.| No       | `3000`                   |
|listenerConcurrency|Only for Kafka. Number of threads to run in the listener containers.| No       | `3`                      |
|addTypeInfoHeader|Only for Kafka. Add type information to message header.| No       | `true`                   |
|connectionTimeout|Only for MQTT. This value, measured in seconds, defines the maximum time interval the client will wait for the network connection to the MQTT server to be established.| No       | `30`                     |
|disconnectionTimeout|Only for MQTT. The completion timeout in milliseconds when disconnecting.| No       | `5000`                   |
|completionTimeout|Only for MQTT. The completion timeout in milliseconds for operations.| No       | `30000`                  |
|mqttClientId| Only for MQTT. Provides the client identifier for the MQTT server.| No       |                          |
|asyncapiFileDir| Path where original AsyncAPI file will be stored.| No       | `src/main/resources/api/` |

### Examples

The shortest possible syntax:
```bash
asyncapi generate fromTemplate asyncapi.yaml @asyncapi/java-quarkus-template
```

Specify where to put the result with `-o` option and define parameter of poll timeout with `-p` option:
```bash
asyncapi generate fromTemplate asyncapi.yaml @asyncapi/java-quarkus-template -o ./src -p listenerPollTimeout=5000
```

## Run it

Go to the root folder of the generated code and run this command:
```bash
./mvnw quarkus:dev
```

## Development

1. Clone the repository:
   ```sh
   git clone https://github.com/asyncapi/java-quarkus-template
   cd java-quarkus-template
   ```
1. Download all template dependencies:
   ```sh
   npm install
   ```
1. Make required changes in the template.
2. Run snapshot tests:
   ```sh
   npm test
   ```
   If there falling tests examine diff report and make an appropriate changes in template files or snapshots.
1. Check output generation project. Install AsyncAPI Generator:
   ```
   npm install -g @asyncapi/cli
   ```
1. Run generation (assuming you are in template folder):
   ```bash
   # for MQTT protocol test with below
   asyncapi generate fromTemplate tests/mocks/mqtt.yml ./ -o output
   # for Kafka protocol test with below
   asyncapi generate fromTemplate tests/mocks/kafka.yml ./ -o output
   ```
1. Explore generated files in `output` directory. Generated project shouldn't contain syntax or compilation errors. 
Preferably generated tests should pass.

### Missing features

See the list of features that are still missing in the component:

- [ ] support of Kafka is done based on clear "smallrye-reactive-messaging-kafka" library
- [ ] generated code for protocol `amqp` could be out of date
- [ ] tests for protocol `amqp` are not provided
- [ ] [`parameters`](https://github.com/asyncapi/spec/blob/2.0.0/versions/2.0.0/asyncapi.md#parametersObject) for topics are not supported
- [ ] [`server variables`](https://github.com/asyncapi/spec/blob/2.0.0/versions/2.0.0/asyncapi.md#serverVariableObject) are not entirely supported 
- [ ] [`security schemas`](https://github.com/asyncapi/spec/blob/2.0.0/versions/2.0.0/asyncapi.md#securitySchemeObject) are not supported
- [ ] [`traits`](https://github.com/asyncapi/spec/blob/2.0.0/versions/2.0.0/asyncapi.md#operationTraitObject) are not supported
- [ ] Json serializer/deserializer is used always, without taking into account real [`content type`](https://github.com/asyncapi/spec/blob/2.0.0/versions/2.0.0/asyncapi.md#default-content-type)
- [ ] template generation of docker-compose depending on protocol of server

If you want to help us develop them, feel free to contribute.

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tr>
    <td align="center"><a href="https://github.com/yourusername"><img src="https://avatars.githubusercontent.com/u/yourid?v=4?s=100" width="100px;" alt=""/><br /><sub><b>Your Name</b></sub></a><br /><a href="https://github.com/asyncapi/java-quarkus-template/commits?author=yourusername" title="Code">💻</a></td>
  </tr>
</table>
<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->
<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification. Contributions of any kind welcome!

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- [AsyncAPI](https://www.asyncapi.com/)
- [Quarkus](https://quarkus.io/)
- [Eclipse MicroProfile](https://microprofile.io/)
