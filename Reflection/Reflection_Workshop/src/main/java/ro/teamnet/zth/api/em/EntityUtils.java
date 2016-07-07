package ro.teamnet.zth.api.em;

import javafx.scene.control.Tab;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.api.annotations.Table;

import java.lang.annotation.Annotation;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user *on 7/7/2016.
 */
public class EntityUtils {

    private static Annotation annotation;

    private EntityUtils(){

        throw new UnsupportedOperationException();
    }

    public static String  getTableName(Class entity){

        return entity.getAnnotation(Table.class).toString();
    }

    public static List<ColumnInfo> getColumns(Class entity){
        List<ColumnInfo> columnInfo = new ArrayList<ColumnInfo>();
        for(Field field : entity.getFields()){
            ColumnInfo columnInfo1 = new ColumnInfo();
            columnInfo1.setColumnName(field.getName());
            //columnInfo1.setColumnName(field);
            Column c = field.getAnnotation(Column.class);

            //Id id = field.getAnnotations(Id.class);

        }
        return columnInfo;
    }

    public static Object castFromSqlType(Object value, Class wantedType){
        if(value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Integer.class)){
            return (Integer)value;  /// VEZI CA O SA CRAPE !!  Daca DA  foloseste (BigDecimal)value.instanceOf(Integer);
        }
        if(value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Long.class)){
            return (Long)value;
        }
        if(value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Float.class)){
            return (Float)value;
        }
        if(value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Double.class)){

            return (Double) value;
        }
        if(!value.getClass().equals(BigDecimal.class) && wantedType.getClass().equals(Double.class)){
            return value;
        }
        return null;
    }

    public static List<Field> getFieldsByAnnotations(Class clazz, Class annotation){
        List<Field> list = new ArrayList<Field>();
        for(Field field : clazz.getFields()){
            if(field.getAnnotations().equals(annotation)){
                list.add(field);
            }
        }

        return list;
    }

    public static Object getSqlValue(Object object) throws IllegalAccessException {
        if(object.getClass().getAnnotation(Table.class)!=null){
            Field isFiled = getFieldsByAnnotations(object.getClass(),Id.class).get(0);
            isFiled.setAccessible(true);
            return isFiled.get(object);
        }
        return object;
    }


}
