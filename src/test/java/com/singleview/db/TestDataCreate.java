package com.singleview.db;

import com.cingleview.codechallenge.db.DAOFactory;
import com.cingleview.codechallenge.db.SchoolDAO;
import com.cingleview.codechallenge.db.data.SchoolData;
import com.cingleview.codechallenge.db.impl.DBFactory;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.Collection;

/**
 * This testcase is used to create some testdata to test the actual web application
 *
 */
public class TestDataCreate  extends TestNG
{

  @Test
  public void testCreateTestData()
  {
    try
    {
      final DAOFactory daoFactory = DBFactory.getDAOFactory();
      final SchoolDAO dao = daoFactory.getSchoolDAO();

      // Create the TestData
      SchoolData data = new SchoolData();

    }
    catch (Exception e)
    {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }

  private SchoolData createSchoolData(String name, String subject, double y3,double y5,)
  {
    SchoolData data = new SchoolData();

  }
}
