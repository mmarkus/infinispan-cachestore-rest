package org.infinispan.loaders.rest.metadata;

import java.util.concurrent.TimeUnit;

import org.infinispan.metadata.InternalMetadataImpl;
import org.infinispan.metadata.Metadata;
import org.infinispan.persistence.spi.MarshalledEntry;
import org.infinispan.rest.MimeMetadata;

public class MimeMetadataHelper implements MetadataHelper {

   @Override
   public String getContentType(MarshalledEntry entry) {
      //ugly, to be solved together with ISPN-3460
      InternalMetadataImpl mei = (InternalMetadataImpl) entry.getMetadata();
      MimeMetadata metadata = (MimeMetadata) mei.actual();
      return metadata.contentType();
   }

   @Override
   public Metadata buildMetadata(String contentType, long lifespan, TimeUnit lifespanUnit, long maxIdle, TimeUnit maxIdleUnit) {
      return MimeMetadata.apply(contentType, lifespan, lifespanUnit, maxIdle, maxIdleUnit);
   }

}
