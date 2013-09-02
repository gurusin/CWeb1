package com.cingleview.codechallenge.db.impl;

import com.cingleview.codechallenge.db.DAOFactory;
import com.cingleview.codechallenge.db.mongodb.MongoDBDAOFactory;

/**
 * This factory returns the correct DAOFactory according to the selected database.
 * Abstract Factory Pattern is used here to obtain the correct DAOFactory implementation.
 * @author :Sudarshana Gurusinghe
 * @since : 29-08-2013
 */
public class DBFactory
{
  /* For this test it's hardcoded here, but in the actual implementation this should be read from a property file
  * or from an environment  variable*/
  private static final String DB_TYPE ="MONGO";
  private static DBFactory instance;


  private DBFactory()
  {

  }


  public static synchronized DBFactory getInstance()
  {
     if (instance == null)
     {
       instance = new DBFactory();
     }
     return instance;
  }


  /**
   * Returns the correct DAOFactory according to the selected database.
   * @return
   */
  public static DAOFactory getDAOFactory()
  {
     if ("MONGO".equals(DB_TYPE))
     {
       return new MongoDBDAOFactory();
     }else
     {
        throw new RuntimeException("Unsupported database type");
     }
  }
}
