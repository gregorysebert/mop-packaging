package org.exoplatform.management.packaging.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.gatein.management.api.operation.ResultHandler;
import org.exoplatform.management.packaging.Util.PackagingUtil;

/**
 * Created with IntelliJ IDEA. User: gregorysebert Date: 11/07/12 Time: 15:38 To
 * change this template use File | Settings | File Templates.
 */
public class PackageMop {

	public PackageMop(String zipPath, ResultHandler resultHandler) {
		try {
			String tempFolder = System.getProperty("java.io.tmpdir");
			File temp = new File(tempFolder + "/exploded-extension");
			temp.mkdir();
            PackagingUtil.extractZip(zipPath, temp);


		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
