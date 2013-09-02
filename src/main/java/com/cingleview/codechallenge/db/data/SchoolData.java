package com.cingleview.codechallenge.db.data;

import com.cingleview.codechallenge.db.util.StorageUtility.DBColumn;

/**
 * Data object to hold school data.
 * @author : Sudarshana Gurusinghe
 * @since : 02- Sep -2013
 */
public class SchoolData
{
   @DBColumn( name ="schoolName")
   private String schoolName;

   @DBColumn( name="subject")
   private String subject;

   @DBColumn(name ="latestYear3")
   private double latestYear3;

   @DBColumn(name ="latestYear5")
   private double latestYear5;

   @DBColumn(name="latestYear7")
   private double latestYear7;

   @DBColumn(name="latestYear9")
   private double latestYear9;

   @DBColumn(name="rawGain")
   private double rawGain;

   @DBColumn(name="factoredGain")
   private double factoredGain;

   @DBColumn(name ="glg")
   private double glg;

   @DBColumn(name ="latestGain")
   private double latestGain;

  public String getSchoolName()
  {
    return schoolName;
  }

  public void setSchoolName(String schoolName)
  {
    this.schoolName = schoolName;
  }

  public String getSubject()
  {
    return subject;
  }

  public void setSubject(String subject)
  {
    this.subject = subject;
  }

  public double getLatestYear3()
  {
    return latestYear3;
  }

  public void setLatestYear3(double latestYear3)
  {
    this.latestYear3 = latestYear3;
  }

  public double getLatestYear5()
  {
    return latestYear5;
  }

  public void setLatestYear5(double latestYear5)
  {
    this.latestYear5 = latestYear5;
  }

  public double getLatestYear7()
  {
    return latestYear7;
  }

  public void setLatestYear7(double latestYear7)
  {
    this.latestYear7 = latestYear7;
  }

  public double getLatestYear9()
  {
    return latestYear9;
  }

  public void setLatestYear9(double latestYear9)
  {
    this.latestYear9 = latestYear9;
  }

  public double getRawGain()
  {
    return rawGain;
  }

  public void setRawGain(double rawGain)
  {
    this.rawGain = rawGain;
  }

  public double getFactoredGain()
  {
    return factoredGain;
  }

  public void setFactoredGain(double factoredGain)
  {
    this.factoredGain = factoredGain;
  }

  public double getGlg()
  {
    return glg;
  }

  public void setGlg(double glg)
  {
    this.glg = glg;
  }

  public double getLatestGain()
  {
    return latestGain;
  }

  public void setLatestGain(double latestGain)
  {
    this.latestGain = latestGain;
  }
}
