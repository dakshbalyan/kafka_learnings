package consumerElastic;

import java.io.IOException;

public class ConsumerElasticV1 {
//    public static RestHighLevelClient createClient(){
//        String hostname = "kafka-udemy-course-7915439929.ap-southeast-2.bonsaisearch.net";
//        String username = "86ompdo2h6";
//        String password = "s8544fgr2u";
//
////        connecting client to the elasticSearch cloud service bonsai
////      setting the endpoint
//        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//        credentialsProvider.setCredentials(AuthScope.ANY,
//                new UsernamePasswordCredentials(username, password));
////      specifying the hostname, port and communication protocol
//        RestClientBuilder builder = RestClient.builder(new HttpHost(hostname, 443, "https"))
//                .setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
//                    @Override
//                    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
//                        return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
//                    }
//                });
//        RestHighLevelClient client = new RestHighLevelClient(builder);
//        return client;
//    }
//
//    public static KafkaConsumer<String, KsqlDataSourceSchema> createConsumer(String topic){
//        String bootstrapID = "127.0.0.1:29092";
//        String groupID = "kafka-elastic-search";
//
////      creating consumer config
//        Properties propertiesConsumer = new Properties();
//        propertiesConsumer.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapID);
//        propertiesConsumer.setProperty(ConsumerConfig.GROUP_ID_CONFIG, groupID);
//        propertiesConsumer.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
//        propertiesConsumer.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false"); // disable auto commit of offsets
//
//        propertiesConsumer.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//        propertiesConsumer.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
//        propertiesConsumer.setProperty("schema.registry.url", "http://127.0.0.1:8081");
//        propertiesConsumer.setProperty("specific.avro.reader", "true");
////        propertiesConsumer.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, "2");
//
////        creating consumer
//        KafkaConsumer<String, KsqlDataSourceSchema> consumer = new KafkaConsumer<>(propertiesConsumer);
//        consumer.subscribe(Collections.singletonList(topic));
//
//        return consumer;
//    }
    public static void main(String[] args) throws IOException {
//        RestHighLevelClient client = createClient();
//        String topic = "avro_output";
//        KafkaConsumer<String, KsqlDataSourceSchema> consumer = createConsumer(topic);
//
//        while(true){
////            polling data from the kafka broker to records
//            ConsumerRecords<String, KsqlDataSourceSchema> records = consumer.poll(100);
//
////            int recordsCount = records.count();
////          bulk request created to increase throughput
////            BulkRequest bulkRequest = new BulkRequest();
//            for(ConsumerRecord<String, KsqlDataSourceSchema> record : records){
//                try{
//                    System.out.println(record.value());
//                    IndexRequest indexRequest = new IndexRequest("kafka", "ksql")
//                            .source(record.value());
//                    IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
//                    consumer.commitAsync();
////                    bulkRequest.add(indexRequest);
//                }
//                catch (NullPointerException e){
//                    e.printStackTrace();
//                }
//            }
//            the bulk request is sent to the elastic search in one go
//            if(recordsCount > 0) { // the if condition is there to skip cases where there are no records
//                BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
//                consumer.commitAsync(); // manually committing offsets here
//                try {
//                    Thread.sleep(1000);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
