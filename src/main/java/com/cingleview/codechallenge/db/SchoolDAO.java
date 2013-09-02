package com.cingleview.codechallenge.db;

import com.cingleview.codechallenge.db.data.SchoolData;

import java.util.Collection;
import java.util.List;

/**
 * Parent class of the SchoolDAO. The common features related to the school dao is kept here.
 * There would be a different implementation of this class for each database.
 */
public abstract class SchoolDAO
{

  /**
   * Returns the List of SchoolData matching the given subject
   * @param subject
   * @return
   */
   public abstract Collection<SchoolData> findBySubject(final String subject);


  /**
   * Saves the SchoolData object
   * @param data
   */
  public abstract void save(final SchoolData data);
}
