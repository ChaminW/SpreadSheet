
package Spread_Sheet;

// Import required libraries
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;



public class DTseparater {
        
    // data fields
    String userInput=null,
           calculatedValue=null;
    String strArr[];
    StringTokenizer tokenizer;
    cell cellData =new cell();   

    
    public void separater(String newData){
        //  method implementation for separate expressions
        // this method do both expression evaluation and separater process
        // its use String tokenizer to tokenize
        
        
        
        userInput=newData;
        if(userInput.startsWith("=")) {   // && !userInput.matches(".*[a-zA-Z?!@#$%&_]+.*")
            try{
                tokenize("=^*/+-(),",true); //tokenize by evaluation tokenz
                ArrayList<String> outputList=new ArrayList<>();
                Stack stackOperators=new Stack();
                String[] duplicateArr=new String[strArr.length-1];
                
                for(int i=0;i<duplicateArr.length;i++){
                    duplicateArr[i]=strArr[i+1];
                }
                for (String strArr1 : duplicateArr) {
                    if(strArr1.matches("-?\\d+(\\.\\d+)?"))

                    {
                        outputList.add(strArr1);
                    }else if(strArr1.equals("(")) {
                        stackOperators.push(strArr1);
                    }else if(strArr1.equals(")")) {
                        while(!(String.valueOf(stackOperators.peek()).equals("("))){
                            outputList.add(String.valueOf(stackOperators.pop()));
                        }
                        stackOperators.pop();
                    }else{
                        while(!stackOperators.empty() && (operaorPrecedence(String.valueOf(stackOperators.peek()))>operaorPrecedence(strArr1))){
                            outputList.add(String.valueOf(stackOperators.pop()));
                        }
                        stackOperators.push(strArr1);
                    }
                }
                while(!stackOperators.empty()){
                    outputList.add(String.valueOf(stackOperators.pop()));
                }
                int currentIndex=0;
                float a,b;
                while(1!=outputList.size()){
                    if(!outputList.get(currentIndex+2).matches("-?\\d+(\\.\\d+)?")){
                        a=Float.parseFloat(outputList.remove(currentIndex));
                        b=Float.parseFloat(outputList.remove(currentIndex));
                        switch(outputList.get(currentIndex)){
                            case "+":
                                outputList.set(currentIndex,String.valueOf(a+b));
                                break;
                            case "-":
                                outputList.set(currentIndex,String.valueOf(a-b));
                                break;
                            case "*":
                                outputList.set(currentIndex,String.valueOf(a*b));
                                break;
                            case "/":
                                outputList.set(currentIndex,String.valueOf(a/b));
                                break;
                            case "^":
                                outputList.set(currentIndex,String.valueOf(Math.pow(a,b)));
                                break;
                        }

                        if(outputList.size()-1<=currentIndex+2)
                            currentIndex--;
                    }else{
                        currentIndex++;
                    }
                }
                // separate the evaluated value is integer or float
                if(Float.valueOf(outputList.get(0))%1==0){
                    // find a number seaparately
                    cellData.setNumberDT((int)Math.ceil(Float.valueOf(outputList.get(0))));
                    cellData.setDataType("Number");
                    cellData.setFormulaDT(userInput);

                }
                else {
                    //find a float separately
                    cellData.setFloatDT(Float.valueOf(outputList.get(0)));
                    cellData.setDataType("Float");
                    cellData.setFormulaDT(userInput);


                }
            }
             // fomulas withh wrong expressin name as errors
            catch(NumberFormatException | ArrayIndexOutOfBoundsException e1){
               
                cellData.setTextDT("#Error");
                cellData.setDataType("Text");
                cellData.setFormulaDT(null);
            }
            catch(IndexOutOfBoundsException | EmptyStackException e2){
                
                cellData.setTextDT("#Error");
                cellData.setDataType("Text");
                cellData.setFormulaDT(null);
            }
        }
        else{
            cellData.setFormulaDT(null);
            if (userInput.matches("\\d{4}/\\d{1,2}/\\d{1,2}") || userInput.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
                //found a date DT
                
                cellData.setDateDT(userInput);
                cellData.setDataType("Date");
            }
            else if(userInput.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}\\ AM") || userInput.matches("\\d{1,2}:\\d{1,2}:\\d{1,2}\\ PM") ){
                //found a time time DT   
                
                cellData.setTimeDT(userInput);
                cellData.setDataType("Time");  
            
            }
            /*
            else if(userInput.matches("\\$\\d{1,2}") ){
                //found a time currency DT    
                cellData=new cell();
                cellData.setCurrencyDT(userInput);
                cellData.setDataType("Currency");  
            
            }*/
            else{
                try{
                    //found a number DT
                    
                    cellData.setNumberDT(Integer.parseInt(userInput));
                    cellData.setDataType("Number");
                   
                    
                }catch(NumberFormatException nfe1){
                    try{
                        //Found a float DT
                        
                        cellData.setFloatDT(Float.parseFloat(userInput));
                        cellData.setDataType("Float");
                       
                    }catch(NumberFormatException nfe2){
                        //Found a text DT
                        
                        cellData.setTextDT(userInput);
                        cellData.setDataType("Text");
                        
                    }
                }
            }
        }
    
    }
    // getters & setters
    public String getUserInput() {
        return userInput;
    }

    public void setCalculatedValue(String calculatedValue) {
        this.calculatedValue = calculatedValue;
    }

    public cell getCalculatedValue() {
        return cellData;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
    
   
    private void tokenize(String delimiter,boolean delimStatus) {
    // method implementation of tokenize   
        int j=0;
        tokenizer=new StringTokenizer(userInput, delimiter,delimStatus);
        strArr=new String[tokenizer.countTokens()];
        while(tokenizer.hasMoreTokens()){
            strArr[j]=tokenizer.nextToken();
            j++;
            }
    }
    
    private int operaorPrecedence(String Operator){
        // method implementation of operater precedence 
        switch(Operator){
            case "+":
                return 0;
            case "-":
                return 0;
            case "*":
                return 1;
            case "/":
                return 1;
            case "^":
                return 2;
            default:
                return -1;
        }
    }
     
}
