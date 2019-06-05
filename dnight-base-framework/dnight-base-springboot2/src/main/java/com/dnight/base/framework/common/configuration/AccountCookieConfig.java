package com.dnight.base.framework.common.configuration;

/**
 * @author LIHONGSHENG451
 * @date 2018/11/12
 * @since 1.0.0
 */
//@Configuration
//public class AccountCookieConfig {
//
//    @Autowired
//    private AccountProperties accountProperties;
//
//    @Bean
//    @ConditionalOnMissingBean
//    public DefaultCookieSerializer defaultCookieSerializer() {
//        DefaultCookieSerializer serializer = new DefaultCookieSerializer();
//        serializer.setCookieName(accountProperties.cookieName);
//        if (!StringUtils.isEmpty(accountProperties.cookieDomain)) {
//            serializer.setDomainName(accountProperties.cookieDomain);
//        }
//
//        if (Objects.nonNull(accountProperties.cookieExpiredTime) && accountProperties.cookieExpiredTime > 0) {
//            serializer.setCookieMaxAge(accountProperties.sessionExpiredTime * 60);
//        }
//        serializer.setUseBase64Encoding(false);
//        return serializer;
//    }
//
//
//    @Bean(value = "springSessionDefaultRedisSerializer")
//    public RedisSerializer<Object> getDefaultRedisSerializer() {
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        ObjectMapper om = new ObjectMapper();
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        return jackson2JsonRedisSerializer;
//    }
//
//}
