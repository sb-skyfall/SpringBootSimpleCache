#SpringBoot Caching

###Steps to be followed:

* Add EnableCaching annotation with a configuration class
* Add a bean of Type CacheManager in the config class
* Use Cacheable,CacheEvict,CachePut in the service layer methods

##Simple Cache Integration:
### Properties to add
* spring.cache.cache-names=ticketsCache
* spring.cache.type=simple