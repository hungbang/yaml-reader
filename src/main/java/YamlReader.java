import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


public class YamlReader {

    public static Map<String, Object> getMapByRoot(String rootKey, String rootValue , String filePath) throws IOException {
        Map<String, Object> mapObj = null;
        try (InputStream inputStream = new FileInputStream(filePath)) {
            Yaml yaml = new Yaml();
            for(Object obj : yaml.loadAll(inputStream)){
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String,Object> map = objectMapper.convertValue(obj, Map.class);
                Object entry = map.getOrDefault(rootKey, null);
                if (entry instanceof String && rootValue.equalsIgnoreCase(entry.toString())){
                    mapObj = map;
                }
            }
        }
        return mapObj;
    }
}
