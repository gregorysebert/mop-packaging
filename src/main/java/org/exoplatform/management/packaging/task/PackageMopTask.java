package org.exoplatform.management.packaging.task;

import org.gatein.management.api.operation.model.ExportTask;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: gregorysebert
 * Date: 11/07/12
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public class PackageMopTask implements ExportTask {
    String FILE ="";

    @Override
    public String getEntry()
    {
        String siteType = "";

        String siteName = "";
        if (siteName.charAt(0) == '/') siteName = siteName.substring(1, siteName.length());

        return new StringBuilder().
                append(siteType).append("/").append(siteName).append("/").append(getXmlFileName()).toString();
    }

    protected String getXmlFileName()
    {
        return FILE;
    }


    @Override
    public void export(OutputStream outputStream) throws IOException
    {

    }

}
