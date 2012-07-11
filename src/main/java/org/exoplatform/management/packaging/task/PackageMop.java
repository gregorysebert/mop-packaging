package org.exoplatform.management.packaging.task;


import org.gatein.management.api.operation.model.ExportResourceModel;
import org.gatein.management.api.operation.ResultHandler;

/**
 * Created with IntelliJ IDEA.
 * User: gregorysebert
 * Date: 11/07/12
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
public class PackageMop {

    public PackageMop(String zipPath, ResultHandler resultHandler)
    {

        readzip

        for each file in zip
        {
        PackageMopTask mopTask = new PackageMopTask(File file, String path);
        resultHandler.completed(new ExportResourceModel(mopTask));
        }
    }

}
