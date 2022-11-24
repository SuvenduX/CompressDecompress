/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CodeFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class Compress {
    public static void method(File file) throws FileNotFoundException, IOException{  //FNFE to catch the error If the file address not found
            
           String fileDirectory=file.getParent(); //getting parent address of the file
            System.out.print(fileDirectory); 
            FileInputStream fis =new FileInputStream(file); //FileInputStream object to read the content of the file 'Path'
            FileOutputStream fos=new FileOutputStream(fileDirectory + "\\NewCompressedFile.gz"); //This class object used to write data/stream/content in a new file
            GZIPOutputStream gzipOS=new GZIPOutputStream(fos);  //This class object helps to write compressed version data of input file in GZIP file format"  and store it in NewCompressedFile.gz" using fos obj
            
            
            byte[] buffer = new byte[1024]; // size can be anything , but we are storing  1024 byte data in each iteration 
            int len;
            
            while((len=fis.read(buffer))!=-1 )  //   Now we are reading the data of input file(fis) and storing it in buffer array & fis.read()is returning the 
             {                                                               // length&it's stored in len variable. Once we completely read the file then remain length is -1. 
               gzipOS.write(buffer, 0, len); //  In every iteration,takes the input from buffer,write compressed data in 
             }                                                           // newCompressedzdile.gz file using gzipOS object.len is length of read data in buffer & 0 is offset  
            
            fis.close();  // InputStream will not read object any further
            gzipOS.close();   //will not write any compressed data & write this before losing fos as this takes fos as parameter
            fos.close();  //will not write any data 
    }
   
    public static void main(String[] args) throws FileNotFoundException, IOException{
         File path =new File("D:\\Accio Projects\\CompressDecompress\\comdecomtestfile.txt");
         method(path);
         
    }
    
}
