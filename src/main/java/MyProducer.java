import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyProducer {

    public MyProducer() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers","localhost:9092");
        properties.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");

        //Sending data to kafka - on specipic topic
        ProducerRecord producerRecord = new ProducerRecord("channel","name","mylearning");

        KafkaProducer kafkaProducer = new KafkaProducer(properties);

        //send data to kafka producer
        kafkaProducer.send(producerRecord);
        kafkaProducer.close();
    }

}
