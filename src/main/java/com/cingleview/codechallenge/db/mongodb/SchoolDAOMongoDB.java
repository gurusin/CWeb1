package com.cingleview.codechallenge.db.mongodb;

import com.cingleview.codechallenge.db.SchoolDAO;
import com.cingleview.codechallenge.db.data.SchoolData;
import com.cingleview.codechallenge.db.util.StorageUtility;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Implementation of SchoolDAO for MongoDB
 * @author : Sudarshana Gurusinghe
 * @since  : 29-08-2013
 */
public class SchoolDAOMongoDB  extends SchoolDAO
{

  private static  SchoolDAOMongoDB instance;

  private SchoolDAOMongoDB()
  {

  }

  public static synchronized  SchoolDAOMongoDB getInstance()
  {
    if (instance == null)
    {
       instance = new SchoolDAOMongoDB();
    }
    return instance;
  }
  @Override
  public Collection<SchoolData> findBySubject(final String subject)
  {
    DBCursor dbCursor = null;

    try
    {
      final DB db = MongoDBAdapter.connect();
      final DBCollection collection = db.getCollection("Schools");
      final BasicDBObject query = new BasicDBObject("subject",subject);
      dbCursor = collection.find(query);
      return StorageUtility.findByClass(SchoolData.class,dbCursor);
    }
    catch (Exception e)
    {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    finally
    {
      dbCursor.close();
      MongoDBAdapter.disconnect();
    }
    return null;  //To change body of implemented methods use File | Settings | File Templates.
  }

  @Override
  public void save(SchoolData data)
  {
    try
    {
      final DB db = MongoDBAdapter.connect();
      final DBCollection collection = db.getCollection("Schools");
      final BasicDBObject school = new BasicDBObject(
        "schoolName", data.getSchoolName())
        .append("subject",data.getSubject())
        .append("latestYear3",data.getLatestYear3())
        .append("latestYear5",data.getLatestYear5())
        .append("latestYear7",data.getLatestYear7())
        .append("latestYear9",data.getLatestYear9())
        .append("rawGain",data.getRawGain())
        .append("factoredGain",data.getFactoredGain())
        .append("glg",data.getGlg())
        .append("latestGain",data.getLatestGain());

      collection.insert(school);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    finally
    {
      MongoDBAdapter.disconnect();
    }

  }
}
