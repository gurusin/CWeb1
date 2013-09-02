package com.cingleview.codechallenge.db.mongodb;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 * The database adapter class for the MongoDB. This provides the connection to
 * the mongo database.
 * @author : Sudarshana Gurusinghe
 * @since : 02- 09- 2013
 */
public class MongoDBAdapter
{

   /* These properties are hardcoded for the moment to keep it simple. But they should be retrieved  from a properties file */
   private final static String DB_SERVER = "127.0.0.1";
   private final static String DB_NAME="School";
   private final static int DB_PORT=27017;

   private static final ThreadLocal<DB> connections = new ThreadLocal<DB>();

  /**
   * Connects to the DB and returns the database instance for the thread.
   * @return
   * @throws Exception
   */
  public static DB connect()throws Exception
  {
     DB db = connections.get();
     if (db == null)
     {
       final MongoClient client = new MongoClient(DB_SERVER,DB_PORT);
       db = client.getDB(DB_NAME);
       connections.set(db);
     }
     return db;
  }

  /**
   * Clears the database connection opened for this thread.
   */
  public static void disconnect()
  {
       final DB db = connections.get();
       if (db != null)
       {
          db.cleanCursors(true);
          connections.remove();
       }
  }



}
