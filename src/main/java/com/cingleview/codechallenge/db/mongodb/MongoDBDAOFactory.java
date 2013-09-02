package com.cingleview.codechallenge.db.mongodb;

import com.cingleview.codechallenge.db.DAOFactory;
import com.cingleview.codechallenge.db.SchoolDAO;

/**
 * DAOFactory implementation for MongoDB
 * @author : Sudarshana Gurusinghe
 * @since : 29-08-2013
 */
public class MongoDBDAOFactory implements DAOFactory
{
  @Override
  public SchoolDAO getSchoolDAO()
  {
    return SchoolDAOMongoDB.getInstance();
  }
}
