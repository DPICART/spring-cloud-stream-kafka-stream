package fr.daart.spring.cloud.stream.kafkastream.kafka;

import fr.daart.spring.cloud.stream.kafkastream.kafka.in.ItemA;
import fr.daart.spring.cloud.stream.kafkastream.kafka.in.ItemB;
import fr.daart.spring.cloud.stream.kafkastream.kafka.out.ItemC;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.ValueJoiner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.BiFunction;

@Configuration
public class KafkaStreamsConfig {
    @Bean
    public BiFunction<KTable<String, ItemA>, KTable<String, ItemB>, KStream<String, ItemC>> ourBinding() {

        ValueJoiner<ItemA, ItemB, ItemC> valueJoiner = (itemA, itemB) -> ItemC
                .builder()
                .itemA(itemA)
                .itemB(itemB)
                .aComputedValue(itemA.getValue().hashCode() + itemB.getValue().hashCode()) // dummy business
                .build();

        return (tableA, tableB) -> tableA
                .join(tableB, valueJoiner)
                .toStream();
    }
}
