package com.singleview.db;


import com.cingleview.codechallenge.db.DAOFactory;
import com.cingleview.codechallenge.db.SchoolDAO;
import com.cingleview.codechallenge.db.data.SchoolData;
import com.cingleview.codechallenge.db.impl.DBFactory;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;

/**
 * Test case to test the Data insertion in the MongoDB
 */
public class TestSchoolDAO extends TestNG
{


   @Test
   public void testFindBySubject()
   {
     try
     {
       final DAOFactory daoFactory = DBFactory.getDAOFactory();
       final SchoolDAO dao = daoFactory.getSchoolDAO();
       final Collection<SchoolData> dataList = dao.findBySubject("numeracy");
       System.out.println(dataList);
     }
     catch (Exception e)
     {
       e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
     }
   }
}
