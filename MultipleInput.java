import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class KafkaConsumerService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final BlockingQueue<String> hourlyQueue = new LinkedBlockingQueue<>();
    private final BlockingQueue<String> dailyQueue = new LinkedBlockingQueue<>();

    @KafkaListener(topics = "your-topic", groupId = "group_id")
    public void consume(String message) {
        try {
            JsonNode jsonNode = objectMapper.readTree(message);
            if (jsonNode.has("hourly")) {
                hourlyQueue.add(jsonNode.get("hourly").toString());
            } else if (jsonNode.has("daily")) {
                dailyQueue.add(jsonNode.get("daily").toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BlockingQueue<String> getHourlyQueue() {
        return hourlyQueue;
    }

    public BlockingQueue<String> getDailyQueue() {
        return dailyQueue;
    }
}
