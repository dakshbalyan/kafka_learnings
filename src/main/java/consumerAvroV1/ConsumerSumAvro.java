package consumerAvroV1;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.ksql.avro_schemas.KsqlDataSourceSchema;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

public class ConsumerSumAvro {
    public static void main(String[] args) {
        Properties properties = new Properties();
        // normal consumer
        properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "customer-consumer-group_1");
        properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
        properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        // avro part (deserializer)
        properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");
        properties.setProperty("specific.avro.reader", "true");

        KafkaConsumer<String, KsqlDataSourceSchema> kafkaConsumer = new KafkaConsumer<>(properties);
        String topic = "SUMOUT";
        kafkaConsumer.subscribe(Collections.singleton(topic));


        System.out.println("Waiting for data...");
        while (true) {
            try {
                ConsumerRecords<String, KsqlDataSourceSchema> records = kafkaConsumer.poll(1000);
                for (ConsumerRecord<String, KsqlDataSourceSchema> record : records) {
                    KsqlDataSourceSchema ksqlDataSourceSchema = record.value();
                    System.out.println(record.partition()+"@"+record.offset());
                    System.out.println(ksqlDataSourceSchema);
                }

                kafkaConsumer.commitSync();
            }catch (SerializationException e){
                e.getMessage();
            }
        }
    }
}
