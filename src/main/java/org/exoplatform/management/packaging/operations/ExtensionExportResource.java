package org.exoplatform.management.packaging.operations;

import org.gatein.management.api.exceptions.OperationException;
import org.gatein.management.api.operation.OperationContext;
import org.gatein.management.api.operation.OperationHandler;
import org.gatein.management.api.operation.OperationNames;
import org.gatein.management.api.operation.OperationAttributes;
import org.gatein.management.api.operation.ResultHandler;


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
            System.out.println(myAttributes.getValues("modes").toString());

        } catch(Exception e) {
            throw new OperationException(OperationNames.EXPORT_RESOURCE, "Unable to create extension : " + e.getMessage());
        }
    }
}
