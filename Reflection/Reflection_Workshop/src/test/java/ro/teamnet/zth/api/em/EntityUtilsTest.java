package ro.teamnet.zth.api.em;

import org.junit.Test;
import org.w3c.dom.Entity;
import ro.teamnet.zth.appl.domain.Departament;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 7/8/2016.
 */
public class EntityUtilsTest {

    @Test
    public void testGetTableNameMethod(){
        String tableName = EntityUtils.getTableName(Departament.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testgetColumns(){
        List<ColumnInfo> columns = EntityUtils.getColumns(Departament.class);
        assertEquals("Department size should me 3!", "3",columns.size());
    }

    public void testcastFromSqlType(){
        //Object object = EntityUtils.castFromSqlType(Departament.class.);
    }

    // TO DO - Pentru toate.
}
