package com.simba.util;

import java.io.InputStream;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;

import com.simba.framework.util.common.XmlUtil;
import com.simba.framework.util.zip.ZipUtil;

import util.AxmlUtil;

/**
 * Created by shuoGG on 2018/8/8
 */
public class ApkUtil {
	
    private ApkUtil() {
    }

    public static String getApkVersion(InputStream in) throws Exception {
        byte[] zipBytes = IOUtils.toByteArray(in);
        Map<String, byte[]> map = ZipUtil.unzip(zipBytes);
        byte[] amxlText = map.get("AndroidManifest.xml");
        String xmlStr = AxmlUtil.parse(amxlText);
        Document doc = XmlUtil.parseXMLContent(xmlStr);
        return doc.getElementsByTagName("manifest").item(0)
                .getAttributes().getNamedItem("android:versionCode").getTextContent();
    }
}
