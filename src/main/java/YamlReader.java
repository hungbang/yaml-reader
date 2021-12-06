import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;


public class YamlReader {

    public static Object readByKey(String key, String filePath) throws IOException {
        Object object = null;
        try (InputStream inputStream = new FileInputStream(filePath)) {
            Yaml yaml = new Yaml();
            for(Object obj : yaml.loadAll(inputStream)){
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String,Object> map = objectMapper.convertValue(obj, Map.class);
                object = map.getOrDefault(key, null);
            }
        }
        return object;
    }

}
