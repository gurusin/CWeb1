package com.cingleview.codechallenge.beans;


import com.cingleview.codechallenge.db.DAOFactory;
import com.cingleview.codechallenge.db.SchoolDAO;
import com.cingleview.codechallenge.db.data.SchoolData;
import com.cingleview.codechallenge.db.impl.DBFactory;
import com.cingleview.codechallenge.service.SchoolDataService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This holds the data for the presentation layer of the school list JSF.
 * This provides all the information for
 * The UI logic should be handled here
 * @author  : Sudarshana Gurusinghe
 * @since : 02 -09-2013
 */

@ManagedBean (name ="schoolBean")
@SessionScoped
public class SchoolBean
{
   private List<String> subjectList = new ArrayList();

   private Collection<SchoolData> selectedSchoolData = new ArrayList();

   private String filterBySubject ="";

   public SchoolBean()
   {
      populateSubjectList();
   }

   public List<String> getSubjectList()
   {
     return subjectList;
   }

   private void populateSubjectList()
   {
        subjectList.add("Grammar & Punctuation");
        subjectList.add("numeracy");
        subjectList.add("Persuasive Writing");
        subjectList.add("Reading");
        subjectList.add("Spelling");
   }

  public String getFilterBySubject()
  {
    return filterBySubject;
  }

  public void setFilterBySubject(String filterBySubject)
  {
    this.filterBySubject = filterBySubject;
  }

  public String updateFiler()
  {
    selectedSchoolData = SchoolDataService.getInstance().findBySubject(filterBySubject);
    return "";
  }

  public Collection<SchoolData> getSelectedSchoolData()
  {
    return selectedSchoolData;
  }
}
