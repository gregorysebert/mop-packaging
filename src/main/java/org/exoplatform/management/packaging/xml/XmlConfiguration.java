package org.exoplatform.management.packaging.xml;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.exoplatform.container.xml.Component;
import org.exoplatform.container.xml.Configuration;
import org.exoplatform.container.xml.ComponentPlugin;
import org.exoplatform.container.xml.InitParams;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created with IntelliJ IDEA.
 * User: gregorysebert
 * Date: 12/07/12
 * Time: 19:09
 * To change this template use File | Settings | File Templates.
 */
public class XmlConfiguration {


    private static final String KERNEL_CONFIGURATION_1_1_URI = "<configuration xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.exoplaform.org/xml/ns/kernel_1_2.xsd http://www.exoplaform.org/xml/ns/kernel_1_2.xsd\" xmlns=\"http://www.exoplaform.org/xml/ns/kernel_1_2.xsd\">";

    private static final String EMPTY_FIELD_REGULAR_EXPRESSION = "<field name=\"([a-z|A-Z]*)\"/>";

    public void XmlConfiguration()
    {

    }

    public void addPortalConfiguration(FileOutputStream zos)
    {
        Component component = new Component();
        component.setKey("portal-configuration");
        component.setType("org.exoplatform.portal.config.UserPortalConfigService");

        ComponentPlugin componentPlugin = new ComponentPlugin();
        componentPlugin.setName("default.portal.config.user.listener");
        componentPlugin.setType("org.exoplatform.portal.config.NewPortalConfigListener");
        componentPlugin.setSetMethod("initListener");
        componentPlugin.setDescription("this listener init the portal configuration");

        ArrayList componentPluginsList = new ArrayList();
        componentPluginsList.add(componentPlugin);

        component.setComponentPlugins(componentPluginsList);

        Configuration configuration = new Configuration();
        configuration.addComponent(component);

        try{
        //zos.putNextEntry(new ZipEntry(path+"/"+ component.getKey() + ".xml"));
        zos.write(toXML(configuration));
        //zos.closeEntry();
        }catch (Exception e) {}

    }

    protected byte[] toXML(Object obj) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            IBindingFactory bfact = BindingDirectory.getFactory(obj.getClass());
            IMarshallingContext mctx = bfact.createMarshallingContext();
            mctx.setIndent(2);
            mctx.marshalDocument(obj, "UTF-8", null, out);
            String outConf = new String(out.toByteArray());
            outConf = outConf.replace("<configuration>", KERNEL_CONFIGURATION_1_1_URI).replaceAll(EMPTY_FIELD_REGULAR_EXPRESSION, "");
            return outConf.getBytes();
        } catch (Exception ie) {
            throw ie;
        }
    }

}
