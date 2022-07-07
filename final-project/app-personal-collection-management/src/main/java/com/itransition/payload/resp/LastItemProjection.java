package com.itransition.payload.resp;

import java.sql.Timestamp;

/**
 * @author Bekjon Bakhromov
 * @since 27.06.2022
 */
public interface LastItemProjection {
     String getItemName();

     String getCollectionName();

     String getAuthor();

     Timestamp getCreatedTime();
}
