package cn.com.analysys.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.apache.log4j.Logger;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: 自定义序列化程序通常通过一个模块注册到Jackson
 * <br/>
 *
 * @author litaiqing
 * @version 1.0
 * @date: ${date} ${time}
 * @since JDK 1.8
 */
@JsonComponent
public class JsonSerializerConfig {

    private static final Logger logger = Logger.getLogger(JsonSerializerConfig.class);


    /**
     * JSON 自定义序列化
     */
    /*public static class Serializer extends JsonSerializer<Map> {
        @Override
        public void serialize(Map map, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            logger.info("map run serialize...");
        }
    }*/


    /**
     * JSON 自定义反序列化
     */
    /*public static class Deserializer extends JsonDeserializer<Map> {
        @Override
        public Map deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            logger.info("map run deserializer...");
            Map<String, Object> map = new HashMap(1);
            map.put("test", true);
            return map;
        }
    }*/

}
