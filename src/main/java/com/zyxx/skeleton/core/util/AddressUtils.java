package com.zyxx.skeleton.core.util;

import org.apache.commons.io.FileUtils;
import org.lionsoul.ip2region.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 根据IP查询详细的地址位置
 *
 * @author Tellsea
 * @date 2019/7/13
 * 使用开源的ip2region库，开源地址：https://github.com/lionsoul2014/ip2region
 */
public class AddressUtils {

    /**
     * 代码参考官方：https://github.com/lionsoul2014/ip2region/blob/master/binding/java/src/main/java/org/lionsoul/ip2region/test/TestSearcher.java
     *
     * @param ip
     * @return
     */
    public static String getAddress(String ip) {
        //db
        String dbPath = AddressUtils.class.getResource("/config/ip2region.db").getPath();

        File file = new File(dbPath);

        if (!file.exists()) {
            String tmpDir = System.getProperties().getProperty("java.io.tmpdir");
            dbPath = tmpDir + "ip.db";
            file = new File(dbPath);
            try {
                FileUtils.copyInputStreamToFile(AddressUtils.class.getClassLoader().getResourceAsStream("classpath:config/ip2region.db"), file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // B-tree
        int algorithm = DbSearcher.BTREE_ALGORITHM;

        try {
            DbConfig config = new DbConfig();
            DbSearcher searcher = new DbSearcher(config, file.getPath());
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // define the method
            Method method = null;
            switch (algorithm) {
                case DbSearcher.BTREE_ALGORITHM:
                    method = searcher.getClass().getMethod("btreeSearch", String.class);
                    break;
                case DbSearcher.BINARY_ALGORITHM:
                    method = searcher.getClass().getMethod("binarySearch", String.class);
                    break;
                case DbSearcher.MEMORY_ALGORITYM:
                    method = searcher.getClass().getMethod("memorySearch", String.class);
                    break;
                default:
            }

            DataBlock dataBlock = null;
            if (!Util.isIpAddress(ip)) {
                System.out.println("Error: Invalid ip address");
            }
            dataBlock = (DataBlock) method.invoke(searcher, ip);
            reader.close();
            searcher.close();
            return dataBlock.getRegion();
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (DbMakerConfigException e) {
            e.printStackTrace();
        }
        return "";
    }
}
