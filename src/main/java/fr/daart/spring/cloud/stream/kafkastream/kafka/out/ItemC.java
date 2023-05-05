package fr.daart.spring.cloud.stream.kafkastream.kafka.out;

import fr.daart.spring.cloud.stream.kafkastream.kafka.in.ItemA;
import fr.daart.spring.cloud.stream.kafkastream.kafka.in.ItemB;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemC {

    private ItemA itemA;
    private ItemB itemB;
    private long aComputedValue;

}
