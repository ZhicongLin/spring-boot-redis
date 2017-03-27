# spring-boot-redis

#pom.xml添加依赖包

        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-redis</artifactId>
            </dependency>
        </dependencies>
        
#application.properties配置

        spring.redis.host=localhost
        spring.redis.port=6379

#java代码使用

        import org.springframework.data.redis.core.ListOperations;
        import org.springframework.data.redis.core.RedisTemplate;
        import org.springframework.stereotype.Service;
        
        import javax.annotation.Resource;
        import java.io.Serializable;
        
        @Service
        public class RedisService {
        
            @Resource
            private RedisTemplate<String, Object> redisTemplate;
        
            void set(String key, Serializable value) {
                this.redisTemplate.opsForValue().set(key, value);
            }
        
            String getStringValue(String key) {
                final Object value = this.redisTemplate.opsForValue().get(key);
                return value != null ? String.valueOf(value) : null;
        
            }
        
        
        }
