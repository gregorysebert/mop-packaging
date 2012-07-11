/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2011, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.exoplatform.management.packaging;

import org.exoplatform.management.packaging.operations.PackagingSiteReadResource;
import org.exoplatform.management.packaging.operations.PackagingSiteExportResource;
import org.gatein.management.api.ComponentRegistration;
import org.gatein.management.api.ManagedDescription;
import org.gatein.management.api.ManagedResource;
import org.gatein.management.api.operation.OperationNames;
import org.gatein.management.spi.ExtensionContext;
import org.gatein.management.spi.ManagementExtension;

/**
 * @author <a href="mailto:thomas.delhomenie@exoplatform.com">Thomas Delhoménie</a>
 * @version $Revision$
 */
public class PackagingManagementExtension implements ManagementExtension
{
   @Override
   public void initialize(ExtensionContext context)
   {
	   	ComponentRegistration registration = context.registerManagedComponent("package");

	   	ManagedResource.Registration extension = registration.registerManagedResource(description("responsible for generating platform extension"));

	   	extension.registerOperationHandler(OperationNames.READ_RESOURCE, new PackagingSiteReadResource(), description("Hello World :-)"));

        extension.registerOperationHandler(OperationNames.EXPORT_RESOURCE, new PackagingSiteExportResource(), description("Export as platform extension"));
   }

   @Override
   public void destroy()
   {
   }

   private static ManagedDescription description(final String description)
   {
      return new ManagedDescription()
      {
         @Override
         public String getDescription()
         {
            return description;
         }
      };
   }
}
