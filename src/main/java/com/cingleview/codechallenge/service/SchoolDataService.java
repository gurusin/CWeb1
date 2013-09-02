package com.cingleview.codechallenge.service;

import com.cingleview.codechallenge.db.DAOFactory;
import com.cingleview.codechallenge.db.SchoolDAO;
import com.cingleview.codechallenge.db.data.SchoolData;
import com.cingleview.codechallenge.db.impl.DBFactory;

import java.util.Collection;

/**
 * Service class for the SchoolData. The business logic related to
 * SchoolData should come here.
 * @author : Sudarshana Gurusinghe
 * @since : 02-09-2013
 */
public class SchoolDataService
{

   private static SchoolDataService instance;

   public static synchronized  SchoolDataService getInstance()
   {
      if (instance == null)
      {
         instance = new SchoolDataService();
      }
      return instance;
   }

   private SchoolDataService()
   {

   }

   /* Business methods*/

  /**
   * Returns a Collection of SchoolData containing the matching SchoolData records.
   * @param subject
   * @return
   */
   public Collection<SchoolData> findBySubject(final String subject)
   {
     final DAOFactory daoFactory = DBFactory.getDAOFactory();
     final SchoolDAO dao = daoFactory.getSchoolDAO();
     return dao.findBySubject(subject);
   }
}
