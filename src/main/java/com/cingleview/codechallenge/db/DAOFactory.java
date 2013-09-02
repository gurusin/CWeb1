package com.cingleview.codechallenge.db;

/**
 * Interface to DAO Factory. Each specific DB should have an implementation of this
 * @author :Sudarshana Gurusinghe
 * @since  : 29-08-2013
 */
public interface DAOFactory
{
  /**
   * Returns the SchoolDAO for the selected DB Type
   * @return
   */
    public SchoolDAO getSchoolDAO();
}
