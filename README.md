# spring-cloud-stream-kafka-streams

## 

Utilisation de spring-cloud-stream avec le binder dédié à kafka streams.

Spring cloud stream: https://docs.spring.io/spring-cloud-stream/docs/current/reference/html/

Matrice de correspondance des versions dispo ici:
https://github.com/spring-cloud/spring-cloud-release/wiki/Supported-Versions#releases

Exemple fourni par Spring de l'utilisation du binder kafka streams (date de 2021 et sous Java8):
https://github.com/spring-cloud/spring-cloud-stream-samples/tree/main/kafka-streams-samples


Les deux fichiers les plus importants:
---
[application.yml](src/main/resources/application.yml)

[KafkaStreamsConfig.java](src/main/java/fr/daart/spring/cloud/stream/kafkastream/kafka/KafkaStreamsConfig.java)


Les points positifs:
---
* Peu de code à écrire
* La connection au topic se fait exclusivement via configuration

Les points négatifs:
---
* Configuration yml peu triviale avec 4 sous arborescences critiques:
    * spring.cloud.stream.bindings
    * spring.cloud.stream.kafka.streams.binder
    * spring.cloud.stream.kafka.streams.default
    * spring.cloud.stream.kafka.streams.bindings
* Impossible de tester les changements sans démarrer l'application
* Documentation pas à jour 
  * ex: La doc recommande "serdeError" alors que déprécié dans le code au profit de "deserialization-exception-handler"
  * Liens morts un peu partout
* Le repo dédié aux exemples est peu mis à jour ( dernier exemple il y a 4 mois, dernier exemple kafka streams il y a 2 ans !)
* Montée de version compliquée ( cf: w*** )
* Les mises à jour des dépendances (module spring-kafka entre autre) arrivent avec un délai d'attente
* Dans le cas de Kafka streams l'abstraction permettant (selon Spring) de passer d'un binder à l'autre ne permet pas de passer d'un binder à l'autre. ( kafka store dans rabbitmq ?? )
* Exemples de la commu quasi inexistant ou pas à jour ( beaucoup d'exemple avec l'ancienne écriture sous forme d'annotations )