package org.exoplatform.management.packaging.task;

import org.gatein.management.api.operation.model.ExportTask;

import java.io.IOException;
import java.io.OutputStream;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: gregorysebert
 * Date: 11/07/12
 * Time: 16:11
 * To change this template use File | Settings | File Templates.
 */
public class Task implements ExportTask {
    private File file = null;
    private String pathExtension = null;

    public Task(File fileXml, String pathExtension)
    {
       this.file = fileXml;
       this.pathExtension = pathExtension;
    }

    @Override
    public String getEntry()
    {
      return this.pathExtension;
    }

    protected String getXmlFileName()
    {
        return this.file.getName();
    }


    @Override
    public void export(OutputStream outputStream) throws IOException
    {

    }

}
