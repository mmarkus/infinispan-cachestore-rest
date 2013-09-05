package org.infinispan.loaders.rest.configuration;

import org.infinispan.configuration.cache.AbstractStoreConfigurationChildBuilder;
import org.infinispan.loaders.rest.metadata.MetadataHelper;
import org.infinispan.persistence.keymappers.MarshallingTwoWayKey2StringMapper;

/**
 * AbstractRestCacheStoreConfigurationChildBuilder.
 *
 * @author Tristan Tarrant
 * @since 6.0
 */
public abstract class AbstractRestCacheStoreConfigurationChildBuilder<S> extends AbstractStoreConfigurationChildBuilder<S> implements RestCacheStoreConfigurationChildBuilder<S> {
   private final RestCacheStoreConfigurationBuilder builder;

   protected AbstractRestCacheStoreConfigurationChildBuilder(RestCacheStoreConfigurationBuilder builder) {
      super(builder);
      this.builder = builder;
   }

   @Override
   public ConnectionPoolConfigurationBuilder connectionPool() {
      return builder.connectionPool();
   }

   @Override
   public RestCacheStoreConfigurationBuilder key2StringMapper(String key2StringMapper) {
      return builder.key2StringMapper(key2StringMapper);
   }

   @Override
   public RestCacheStoreConfigurationBuilder key2StringMapper(Class<? extends MarshallingTwoWayKey2StringMapper> klass) {
      return builder.key2StringMapper(klass);
   }

   @Override
   public RestCacheStoreConfigurationBuilder metadataHelper(String metadataHelper) {
      return builder.metadataHelper(metadataHelper);
   }

   @Override
   public RestCacheStoreConfigurationBuilder metadataHelper(Class<? extends MetadataHelper> metadataHelper) {
      return builder.metadataHelper(metadataHelper);
   }

   @Override
   public RestCacheStoreConfigurationBuilder host(String host) {
      return builder.host(host);
   }

   @Override
   public RestCacheStoreConfigurationBuilder port(int port) {
      return builder.port(port);
   }

   @Override
   public RestCacheStoreConfigurationBuilder path(String path) {
      return builder.path(path);
   }

   @Override
   public RestCacheStoreConfigurationBuilder appendCacheNameToPath(boolean appendCacheNameToPath) {
      return builder.appendCacheNameToPath(appendCacheNameToPath);
   }
}
