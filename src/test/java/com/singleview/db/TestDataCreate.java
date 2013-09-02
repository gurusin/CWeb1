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
      SchoolData data = createSchoolData("St. Aaron College","Numeracy",413.55,494.25,0.0,0.0,61.4917,69.81,113.52757826,-7.0);
      dao.save(data);

      data = createSchoolData("St. Alan College","Numeracy",380.5125,469.9,510.85,0.0,61.4917,69.81,113.52757826,0.0);
      dao.save(data);


      data = createSchoolData("St. Aaron College 2","Spelling",413.55,494.25,0.0,0.0,61.4917,69.81,113.52757826,-7.0);
      dao.save(data);

      data = createSchoolData("St. Alan College 3 ","Reading",380.5125,469.9,510.85,0.0,61.4917,69.81,113.52757826,0.0);
      dao.save(data);
    }

    catch (Exception e)
    {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
  }

  private SchoolData createSchoolData(String name, String subject, double y3,double y5,
                                      double y7, double y9, double rawGain1, double factoredGain,
                                      double glg, double latestGain)
  {
    SchoolData data = new SchoolData();
    data.setSchoolName(name);
    data.setSubject(subject);
    data.setLatestYear3(y3);
    data.setLatestYear5(y5);
    data.setLatestYear7(y7);
    data.setLatestYear9(y9);
    data.setRawGain(rawGain1);
    data.setFactoredGain(factoredGain);
    data.setGlg(glg);
    data.setLatestGain(latestGain);
    return data;

  }
}
