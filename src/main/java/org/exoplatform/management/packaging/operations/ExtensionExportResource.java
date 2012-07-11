package org.exoplatform.management.packaging.operations;

import org.gatein.management.api.exceptions.OperationException;
import org.gatein.management.api.operation.OperationContext;
import org.gatein.management.api.operation.OperationHandler;
import org.gatein.management.api.operation.OperationNames;
import org.gatein.management.api.operation.OperationAttributes;
import org.gatein.management.api.operation.ResultHandler;
import org.exoplatform.management.packaging.task.PackageContent;
import org.exoplatform.management.packaging.task.PackageMop;
import org.gatein.management.api.operation.model.ExportResourceModel;



/**
 * Created with IntelliJ IDEA.
 * User: gregorysebert
 * Date: 11/07/12
 * Time: 10:34
 * To change this template use File | Settings | File Templates.
 */
public class ExtensionExportResource implements OperationHandler
{
    @Override
    public void execute(OperationContext operationContext, ResultHandler resultHandler) throws OperationException
    {
        try {

            OperationAttributes myAttributes = operationContext.getAttributes();
            String[] options = myAttributes.getValue("filter").split(",");

            for (int i=0; i<options.length;i++)
                {
                   String[] option = options[i].split(":");

                   if (option.length == 2)
                   {
                        if (option[0].equals("mop")) {PackageMop packageMop = new PackageMop(option[1],resultHandler);}
                        else if (option[0].equals("content"))   {PackageContent packageMop = new PackageContent(option[1],resultHandler);}
                        else throw new OperationException(OperationNames.EXPORT_RESOURCE, "Invalid option  : " + option.toString());
                   }
                   else throw new OperationException(OperationNames.EXPORT_RESOURCE, "Invalid option  : " + option.toString());
                   }

        } catch(Exception e) {
            throw new OperationException(OperationNames.EXPORT_RESOURCE, "Unable to create extension, options are missing or invalid");
        }
    }
}
