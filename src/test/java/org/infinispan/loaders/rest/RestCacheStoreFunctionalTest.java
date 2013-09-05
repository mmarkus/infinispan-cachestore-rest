package org.infinispan.loaders.rest;

import org.infinispan.commons.api.BasicCacheContainer;
import org.infinispan.configuration.cache.PersistenceConfigurationBuilder;
import org.infinispan.loaders.rest.configuration.RestCacheStoreConfigurationBuilder;
import org.infinispan.manager.EmbeddedCacheManager;
import org.infinispan.persistence.BaseCacheStoreFunctionalTest;
import org.infinispan.rest.EmbeddedRestServer;
import org.infinispan.rest.RestTestingUtil;
import org.infinispan.test.TestingUtil;
import org.infinispan.test.fwk.TestCacheManagerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @author Tristan Tarrant
 * @since 6.0
 */
@Test(testName = "loaders.remote.RestCacheStoreFunctionalTest", groups = "functional")
public class RestCacheStoreFunctionalTest extends BaseCacheStoreFunctionalTest {
   private EmbeddedCacheManager localCacheManager;
   private EmbeddedRestServer restServer;




   @Override
   protected PersistenceConfigurationBuilder createCacheStoreConfig(PersistenceConfigurationBuilder loaders, boolean preload) {
      localCacheManager = TestCacheManagerFactory.createCacheManager();
      restServer = RestTestingUtil.startRestServer(localCacheManager);
      loaders.addStore(RestCacheStoreConfigurationBuilder.class)
            .host("localhost")
            .port(restServer.getPort())
            .path("/rest/"+BasicCacheContainer.DEFAULT_CACHE_NAME)
            .preload(preload);
      return loaders;
   }

   @AfterMethod
   public void tearDown() throws Exception {
      RestTestingUtil.killServers(restServer);
      TestingUtil.killCacheManagers(localCacheManager);
   }

   @Override
   public void testPreloadAndExpiry() {
      // No-op, since remote cache store does not support preload
   }

   @Override
   public void testPreloadStoredAsBinary() {
      // No-op, remote cache store does not support store as binary
      // since Hot Rod already stores them as binary
   }

   @Override
   public void testTwoCachesSameCacheStore() {
      //not applicable
   }
}
