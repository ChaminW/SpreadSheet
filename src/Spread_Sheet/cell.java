package Spread_Sheet;

import java.io.Serializable;



public class cell implements Serializable
{
    //Class implementation of cell
    //This class can serializable 
    
    // fields for datat types
    int numberDT;
    float floatDT;
    String textDT;
    String dateDT;
    String timeDT;
    String currencyDT;
    
    // fied for formula
    String formulaDT;
    // field for keep data type of cell
    String dataType;
    
    // fields for keep raw and columns
    int rowId;
    int columnId;

    public cell() {
        // constructor implementation
        
        this.textDT = null;
        this.dateDT = null;
        this.timeDT = null;
        this.currencyDT = null;
        this.formulaDT = null;
        
    }
    
    
    // setters and getters 
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setRowId(int rowId) {
        this.rowId = rowId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public String getDataType() {
        return dataType;
    }

    public int getRowId() {
        return rowId;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setNumberDT(int numberDT) {
        this.numberDT = numberDT;
    }

    public void setFloatDT(float floatDT) {
        this.floatDT = floatDT;
    }

    public void setTextDT(String textDT) {
        this.textDT = textDT;
    }

    public void setDateDT(String dateDT) {
        this.dateDT = dateDT;
    }

    public void setTimeDT(String timeDT) {
        this.timeDT = timeDT;
    }

    public void setCurrencyDT(String currencyDT) {
        this.currencyDT = currencyDT;
    }

    public void setFormulaDT(String formulaDT) {
        this.formulaDT = formulaDT;
    }

    public int getNumberDT() {
        return numberDT;
    }

    public float getFloatDT() {
        return floatDT;
    }

    public String getTextDT() {
        return textDT;
    }

    public String getDateDT() {
        return dateDT;
    }

    public String getTimeDT() {
        return timeDT;
    }

    public String getCurrencyDT() {
        return currencyDT;
    }

    public String getFormulaDT() {
        return formulaDT;
    }
    
    
    
    
        
}

