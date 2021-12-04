import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerTest {
    public ProducerTest() {
        Properties props = new Properties();
        //bootstrap.servers is the IP addresses of Kafka cluster. If you have more than 1 broker, you can put all separated by commas. For ex: 192.168.33.10:9092, 192.168.33.10:9093
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        //Kafka message sent to Kafka cluster is combined with key(optional) and value which can be any data type. However,
        // we will need to specify how Kafka producer should serialize those data types into binary before sending to Kafka cluster.
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = null;
        try {
            producer = new KafkaProducer<>(props);
            for (int i = 0; i < 100; i++) {
                String msg = "Message " + i;
                //Above source code will produce 100 messages which value are “Message 1”, “Message 2”,… “Message 99” to the mytopic topic.
                producer.send(new ProducerRecord<String, String>("mytopic", msg));
                System.out.println("Sent:" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            producer.close();
        }
    }
}
