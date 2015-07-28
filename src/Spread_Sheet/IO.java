
package Spread_Sheet;

//import requre libraries

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;





public class IO {
    
    //class include static methds of file saving and loading by serialize
    //We use method call sarializing. It save a object to file bit wise
    //It is very easy to save and load data
    
    public static void fileSave (cell[][] cellArr,int row,int column,String savefile) throws IOException{
        //satatic method implementation for file saving
        
        FileOutputStream fileout =new FileOutputStream(savefile);
        ObjectOutputStream out = new ObjectOutputStream(fileout);
        out.writeObject(cellArr);                                  //write object to the file
        out.close();
        fileout.close();   
    }   
    
    public static cell[][] fileLoad (int row,int column,String openfile) throws Exception{
        // sattic method implementation for file loading
        
        cell cellArr[][];
        FileInputStream filein =new FileInputStream(openfile);
        ObjectInputStream in = new ObjectInputStream(filein);
        cellArr=(cell[][])in.readObject();                        //read and cast object from the file
        in.close();
        filein.close();
        
        return cellArr;//return the serialized object


    }
        
}
