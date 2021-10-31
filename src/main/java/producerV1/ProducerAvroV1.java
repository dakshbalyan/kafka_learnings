package producerV1;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import kafkaLearning_employee.Employee;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.Random;

public class ProducerAvroV1 {
//    Connecting through landoop to kafka cluster
    public static void main(String[] args) {
        Properties properties = new Properties();

        // normal producer
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty("acks", "all");
        properties.setProperty("retries", "10");

        // avro part
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");

        Producer<String, Employee> producer = new KafkaProducer<String, Employee>(properties);

        String topic = "avro_inp";
        Random random = new Random();

        // copied from avro examples
        for(int i = 50; i < 100; i++){
            Employee employee = Employee.newBuilder()
                    .setId(i+1)
                    .setValue1(random.nextInt() % 100000000)
                    .setValue2(random.nextInt() % 100000000)
                    .build();

            ProducerRecord<String, Employee> producerRecord = new ProducerRecord<>(
                    topic, employee
            );

            System.out.println(employee);
            producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {
                        System.out.println(recordMetadata);
                    } else {
                        e.printStackTrace();
                    }
                }
            });
        }

        producer.flush();
        producer.close();

    }
}

