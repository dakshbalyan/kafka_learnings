package producerV1;

import com.example.*;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class NestedAvroSchemaProducer {
    public static void main(String[] args) {
        Properties properties = new Properties();
//        normal producer configs
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"127.0.0.1:9092");
        properties.setProperty(ProducerConfig.ACKS_CONFIG, "all");
        properties.setProperty(ProducerConfig.RETRIES_CONFIG, "10");

//        avro config
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");

        Producer<String, EmpValue> producer = new KafkaProducer<String, EmpValue>(properties);

        String topic = "EMP";

        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                System.out.println("Flushing values......");
                producer.flush();
                System.out.println("Closing producer.....");
                producer.close();
                System.out.println("------ Successfully exiting -------");
            }
        });

        while(true){
            try{
                EmpValue empValue = createMsg();
                ProducerRecord<String, EmpValue> producerRecord = new
                        ProducerRecord<>(topic, empValue);

                System.out.println(empValue);
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
            catch (Exception e){
                e.printStackTrace();
            }

            try {
                Thread.sleep(15000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static EmpValue createMsg(){

        Random rand = new Random();
        FAMILY_MEMBERS familyMembers1 = FAMILY_MEMBERS.newBuilder()
                .setNAME(randomStringGenerator(5))
                .setAGE(rand.nextInt(50 - 10) + 10)
                .setRELATION(randomStringGenerator(5))
                .build();
        FAMILY_MEMBERS familyMembers2 = FAMILY_MEMBERS.newBuilder()
                .setNAME(randomStringGenerator(5))
                .setAGE(rand.nextInt(50 - 10) + 10)
                .setRELATION(randomStringGenerator(5))
                .build();
        ArrayList<FAMILY_MEMBERS> familyMembers = new ArrayList<>();
        familyMembers.add(familyMembers1);
        familyMembers.add(familyMembers2);
        EmpValue empValue = EmpValue.newBuilder()
                .setEmpID(String.valueOf(rand.nextInt(999 - 100) + 100))
                .setNAME(FULL_NAME.newBuilder()
                        .setFIRSTNAME(randomStringGenerator(5))
                        .setLASTNAME(randomStringGenerator(5))
                        .build())
                .setADDRESS(PERSONAL_ADDRESS.newBuilder()
                        .setSTREET("ABC5 street")
                        .setCITY("GURGAON")
                        .setSTATE("HARYANA")
                        .build())
                .setSALARY(SALARY.newBuilder()
                        .setBASESALARY(100)
                        .setBONUS(6000)
                        .setINCENTIVES(false)
                        .build())
                .setCOMPANY(COMPANY_INFO.newBuilder()
                        .setCOMPANYNAME("XYZ3")
                        .setDEPARTMENT("IT")
                        .setPOST("System Support").build())
                .setFAMILY(familyMembers)
                .build();

        return empValue;
    }

    private static String randomStringGenerator(int stringSize){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = stringSize;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }
}


/*
1.
SELECT
    empid AS EMP_ID,
    NAME->FIRST_NAME AS EMP_FIRST_NAME,
    NAME->LAST_NAME AS EMP_LAST_NAME,
    ADDRESS->STREET AS EMP_ADDR_STREET,
    ADDRESS->CITY AS EMP_ADDR_CITY,
    ADDRESS->STATE AS EMP_ADDR_STATE,
    SALARY->BASE_SALARY AS EMP_BASE_SALARY,
    SALARY->BONUS AS EMP_BONUS,
    COMPANY->COMPANY_NAME AS COMPANY_NAME,
    COMPANY->DEPARTMENT AS EMP_DEPARTMENT,
    COMPANY->POST AS EMP_POST

FROM EMP EMIT CHANGES;
2.
CREATE STREAM flattened_emp AS
SELECT
    empid AS EMP_ID,
    NAME->FIRST_NAME AS EMP_FIRST_NAME,
    NAME->LAST_NAME AS EMP_LAST_NAME,
    ADDRESS->STREET AS EMP_ADDR_STREET,
    ADDRESS->CITY AS EMP_ADDR_CITY,
    ADDRESS->STATE AS EMP_ADDR_STATE,
    SALARY->BASE_SALARY AS EMP_BASE_SALARY,
    SALARY->BONUS AS EMP_BONUS,
    COMPANY->COMPANY_NAME AS COMPANY_NAME,
    COMPANY->DEPARTMENT AS EMP_DEPARTMENT,
    COMPANY->POST AS EMP_POST

FROM EMP;
3.
*/