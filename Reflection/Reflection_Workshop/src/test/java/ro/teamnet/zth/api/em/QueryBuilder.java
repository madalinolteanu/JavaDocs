package ro.teamnet.zth.api.em;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 7/8/2016.
 */
public class QueryBuilder {

    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public String getValueForQuery(Object value){
        if(value.getClass().equals(String.class)){
            return "'" + value.toString() + "'";
        }

        if(value.getClass().equals(Date.class)){
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            return "TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'";

        }
        return null;
    }

    public QueryBuilder addConditions(Condition condition){
        if(conditions.isEmpty()){
            conditions = new ArrayList<Condition>();
            conditions.add(condition);
        }
        else conditions.add(condition);
        return this;
    }

    public QueryBuilder setTableName(Object tableName){
        this.tableName = tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo> queryColumns){
        for(int i=0; i < queryColumns.size();i++){
            this.queryColumns.add(queryColumns.set(i,queryColumns.get(i)));

        }
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType){
        this.queryType = queryType;
        return this;
    }

    public String createSelectQuery(){
        StringBuilder str = new StringBuilder();
        String columns ="";
        String condition = "";
        str.append("SELECT ");
        if(!queryColumns.isEmpty()) {
            for (int i = 0; i < queryColumns.size(); i++) {

                str.append(queryColumns.get(i).getDbName());
                if (i < queryColumns.size() - 1) {
                    columns = columns.toString() + ",";
                }
            }
            str.append(" FROM " + tableName.toString());
        }
        else str.append("SELECT * FROM " + tableName.toString() );

        if(!conditions.isEmpty()){
            str.append(" WHERE ");
            for(int i = 0; i <conditions.size(); i++){
                str.append(conditions.get(i).getColumnName() + " = " + conditions.get(i).getValue());
                if(i< conditions.size()-1){
                    condition = condition.toString() +" AND ";
                }
            }

        }
        return str.toString();
    }

    public String createDeleteQuery(){
        StringBuilder str = new StringBuilder();
        str.append("DELETE FROM " + tableName +" WHERE");
        if(!conditions.isEmpty()) {
            for (int i = 0; i < conditions.size(); i++) {

                str.append( conditions.get(i).getColumnName() + " = " + conditions.get(i).getValue());
                if (i < conditions.size() - 1) {
                    str.append(" AND ");
                }
            }

        }
        else str.append("DELETE FROM " + tableName + " ;");

        return str.toString();
    }

    public String createUpdateQuery(){
        StringBuilder str = new StringBuilder();
        String update = "";
        update = "UPDATE " + tableName + " SET ";
        str.append(update);
        if(!queryColumns.isEmpty()) {
            for (int i = 0; i < queryColumns.size(); i++) {

                update = update.toString() + ((ColumnInfo) queryColumns.get(i)).getDbName() + " = " + ((ColumnInfo) queryColumns.get(i)).getValue();
                if (i < queryColumns.size() - 1) {
                    update = update.toString() + ",";
                }
            }
            str.append(update);
        }
        return str.toString();
    }
    public String createInsertQuery(){
        StringBuilder str = new StringBuilder();
        str.append("INSERT INTO "+tableName +" VALUES (");
        boolean isfirstvalue = true;
        if(!queryColumns.isEmpty())
            for(ColumnInfo columinfo : queryColumns){
                if(!isfirstvalue)
                    str.append(",");
                str.append(getValueForQuery(columinfo.getValue()));
                isfirstvalue = false;
            }
        str.append(")");
        return str.toString();
    }

    public void createQuery(){
        if(this.queryType.equals(QueryType.SELECT)){
            createSelectQuery();
        }
        if(this.queryType.equals(QueryType.INSERT)){
            createInsertQuery();
        }
        if(this.queryType.equals(QueryType.DELETE)){
            createDeleteQuery();
        }
        if(this.queryType.equals(QueryType.UPDATE)){
            createUpdateQuery();
        }
    }

}
