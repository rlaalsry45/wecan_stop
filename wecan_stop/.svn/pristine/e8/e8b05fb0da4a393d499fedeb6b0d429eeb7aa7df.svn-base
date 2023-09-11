package com.z5.zcms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import net.sf.jazzlib.ZipEntry;
import net.sf.jazzlib.ZipOutputStream;

public class ZipFileDown {

	public static void fileCopy(String oldDirectory, String newDirectory) throws IOException{

		 

		 BufferedReader in = null;

		 OutputStreamWriter out = null;

		 

		 FileInputStream fis = null;

		 FileOutputStream fos = null;

		 

		 byte buffer[] = new byte[1024];

		 

		 try{

			 

			//zipFiles 경로에도 폴더 생성

			File file = new File(newDirectory);

			File dir = new File(file.getParent());

			

			if(!dir.exists()){

				dir.mkdirs();

			}

			

			//확장자 구하기

			int position = oldDirectory.lastIndexOf("."); //int position = StringUtils.substringAfterLast(oldDirectory, ".");

			String ext = oldDirectory.substring(position + 1);

			

			if(isImageOrFont(ext)){

				int data = 0;

				

				fis = new FileInputStream(oldDirectory);

				fos = new FileOutputStream(file);

				

				while((data=fis.read(buffer))!=-1){

					fos.write(buffer,0,data);

					fos.flush();

				}	

			}else{

				in = new BufferedReader(new InputStreamReader(new FileInputStream(oldDirectory), "UTF-8"));

				out = new OutputStreamWriter(new FileOutputStream(newDirectory), "UTF-8");

				int data = 0;

				 

				while((data = in.read())!= -1){

					out.write(data);

				}

			}

		 }catch(IOException e){

			 //e.printStackTrace();

		 }finally{

			 if(fis!=null) fis.close();

			 if(fos!=null) fos.close();

			 if(in!=null) in.close();

			 if(out!=null) out.close();

		 }

	 }
	
	public static boolean isImageOrFont(String requestType){

		boolean bool = false;

		

		String[] values = {"png","jpg","jpeg","gif","psd","eot","woff"};

		for(String value : values){

			if( value.equals(requestType.toLowerCase()) ){

				bool = true;

			}

		}

		return bool;

	}



	
    /**
     * @param filenames       압출할 파일명
     * @param filepathes      압축할 파일경로
     * @param outFileFullPath 압축파일명
     *                        <p>
     *                        by issuettl
     */
    public static boolean createZipFile(List<String> filenames, List<String> filepathes, String outFileFullPath) {

        // Create a buffer for reading the files
        byte[] buf = new byte[1024];

        try {
            // Create the ZIP file
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFileFullPath));

            if (filenames == null || filepathes == null)
                throw new NullPointerException();

            if (filenames.size() != filepathes.size())
                throw new Exception();

            // Compress the files
            for (int i = 0; i < filenames.size(); i++) {
                Object objFilename = filenames.get(i);
                Object objFilepath = filepathes.get(i);

                if (objFilename instanceof String && objFilepath instanceof String) {
                    String filename = (String) objFilename;
                    String filepath = (String) objFilepath;

                    FileInputStream in = new FileInputStream(filepath);

                    // Add ZIP entry to output stream.
                    out.putNextEntry(new ZipEntry(filename));

                    // Transfer bytes from the file to the ZIP file
                    int len;
                    while ((len = in.read(buf)) > 0) {
                        out.write(buf, 0, len);
                    }

                    // Complete the entry
                    out.closeEntry();
                    in.close();
                }
            }

            // Complete the ZIP file
            out.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
