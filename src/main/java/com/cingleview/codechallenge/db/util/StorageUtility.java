package com.cingleview.codechallenge.db.util;

import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import javax.swing.text.TabExpander;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * This is a utility class that runs through the annotations in a data class
 * and sets the attributes dynamically by inspecting the annotated fields.
 *
 * @author : Sudarshana Gurusinghe
 * @since  : 02 -09-2013
 */
public class StorageUtility
{

  /**##############################################
     Available Annotations.
     ##############################################*/

  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target(ElementType.FIELD)
  public @interface DBColumn
  {
    String name();
  }

  private static Hashtable<Class<?>, Map<String, TableColumn>> classFieldsMap = new Hashtable<Class<?>, Map<String, TableColumn>>();


  private static class TableColumn
  {

    private final String columnName;

    private final Class<?> columnType;

    private final String fieldName;

    private Field field;

    private TableColumn(final String colName, final Class<?> colType, final String fieldName)
    {
        columnName = colName;
        columnType = colType;
        this.fieldName = fieldName;
    }

    /**
     * @return the columnName
     */
    private String getColumnName()
    {
      return columnName;
    }

    /**
     * @return the columnType
     */
    private Class<?> getColumnType()
    {
      return columnType;
    }

    private String getFieldName()
    {
      return fieldName;
    }

    private Field getField()
    {
      return field;
    }

    private void setField(Field field)
    {
      this.field = field;
    }
  }


  /**
   * Returns a Collection of Objects of a particular class with the annotated attributes filled with
   * matching values from the database fields.
   * @param aClass
   * @param dbCursor
   * @return
   * @throws Exception
   */
  public static  <T extends Object> Collection<T> findByClass(Class<T> aClass,DBCursor dbCursor) throws Exception
  {
    final Collection<T> results = new ArrayList();
    final Map<String,TableColumn> attributeMap = getFieldNameWithTheirColumnAttributes(aClass);

    while (dbCursor.hasNext())
    {
       final DBObject dbObject = dbCursor.next();
       final T myObject = aClass.newInstance();
      for (Map.Entry<String, TableColumn> entry : attributeMap.entrySet())
      {
        setValue(dbObject,myObject,entry.getValue());
      }
      results.add(myObject);
    }
    return results;
  }

  private static void setValue(final DBObject dbObject,final Object object, final TableColumn tableColumn)
  {
    try
    {
      final Field field = tableColumn.getField();
      final Object targetObj = dbObject.get(tableColumn.getColumnName());
      field.set(object,targetObj);
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
    }
    finally
    {
    }
  }

   /**
   * Returns a map with the annotated field  and it's column type as a TableColumn object
   * @param clazz
   * @return
   */
  private static Map<String, TableColumn> getFieldNameWithTheirColumnAttributes(final Class clazz)
  {
    final Map<String, TableColumn> fieldNameWithTheirColumnAttributes = new HashMap<String, TableColumn>();
    final Field[] fields = clazz.getDeclaredFields();
    for (final Field field : fields)
    {
      final DBColumn dbColumn = field.getAnnotation(DBColumn.class);
      if (dbColumn != null)
      {
        final TableColumn tableColumn = new TableColumn(dbColumn.name(), field.getType(), field.getName());
        field.setAccessible(true);
        tableColumn.setField(field);
        fieldNameWithTheirColumnAttributes.put(field.getName(),tableColumn );
      }
    }
    return fieldNameWithTheirColumnAttributes;
  }








}