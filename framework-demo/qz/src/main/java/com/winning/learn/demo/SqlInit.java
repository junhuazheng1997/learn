package com.winning.learn.demo;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.type.classreading.ConcurrentReferenceCachingMetadataReaderFactory;

import javax.print.DocFlavor;
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SqlInit {

    public static Map<String, String> insertMap = new ConcurrentHashMap<>();


    public static String getSql(String tableName, String beginTime, String endTime) {
        ResourceBundle bundle = ResourceBundle.getBundle("sql");
        String s = bundle.getString(tableName);
        String selectSql = StrUtil.format(s, beginTime, endTime);

        return selectSql;
    }


    public static String buildSql(String beginTime, String endTime) {

//        Map<String, String> selectMap = new ConcurrentHashMap<>();


        StringBuilder builder = new StringBuilder();
        builder.append("SELECT random_string(32) AS OUTMED_DISE_RT_ID,")
                .append("random_string(32) AS RID,")
                .append("now() AS STT_TIME,")
                .append("now() AS CRTE_TIME,")
                .append("now() AS UPDT_TIME,")
                .append("T2.PROV_ADMDVS_ID AS PROV_ADMDVS,")
                .append("T2.PROV_ADMDVS_NAME AS PROV_ADMDVS_NAME,")
                .append("T1.DB_DISECODE AS DISECODE,")
                .append("T1.DB_DISENAME AS DISENAME,")
                .append("T1.DB_SETL_PSNTIME AS SETL_PSNTIME")
                .append(" FROM (")
                .append("SELECT S.INSU_ADMDVS AS DB_ADMDVS,")
                .append("A.DIAG_CODE AS DB_DISECODE,")
                .append("A.DISE_NAME AS DB_DISENAME,")
                .append("COUNT( S.SETL_ID ) AS DB_SETL_PSNTIME")
                .append(" FROM setl_d S")
                .append(" WHERE S.TIME>='{}' AND S.TIME<='{}' AND S.VALI_FLAG = '1'")
                .append(" AND substr(S.INSU_ADMDVS,1,2) <> substr(S.FIX_BLNG_ADMDVS,1,2)")
                .append(" LEFT JOIN setl_diag_list_d A ON  S.MDTRT_ID = A.MDTRT_ID")
                .append(" GROUP BY S.INSU_ADMDVS,A.DISE_NO,A.DISE_NAME")
                .append(") T1")
                .append(" LEFT JOIN tbds_adb.dim_pub_admdvs_ds T2 ON  T1.DB_ADMDVS = T2.ADMDVS;");

        String s1 = StrUtil.format(builder.toString(), beginTime, endTime);

        builder.delete(0, builder.lastIndexOf(";") + 1);




        System.out.println(builder.toString());

        return s1;
    }
    
    
    public void test() {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT random_string(32) AS OUTMED_FEE_STT_RT_ID,")
                .append("random_string(32) AS RID,")
                .append("now() AS STT_TIME,")
                .append("now() AS CRTE_TIME,")
                .append("now() AS UPDT_TIME,")
                .append("T2.PROV_ADMDVS_ID AS PROV_ADMDVS,")
                .append("T2.PROV_ADMDVS_NAME AS PROV_ADMDVS_NAME,")
                .append("T1.DB_INSUTYPE AS INSUTYPE,")
                .append("T1.DB_INSUTYPE_NAME AS INSUTYPE_NAME,")
                .append("T1.DB_SETL_PSNTIME AS SETL_PSNTIME,")
                .append("T1.DB_FUND_PAY AS FUND_PAY,")
                .append("T1.DB_MEDFEE_SUMAMT AS MEDFEE_SUMAMT,")
                .append("T1.DB_IPT_TOTL_DAYS AS IPT_TOTL_DAYS")
                .append(" FROM (")
                .append("SELECT S.INSU_ADMDVS AS DB_ADMDVS,")
                .append("S.INSUTYPE AS DB_INSUTYPE,")
                .append("CASE WHEN S.INSUTYPE IN ('310','320','330','340','350','360','370','399','510') THEN '城镇职工' WHEN S.INSUTYPE IN ('380','390','391','392') THEN '城乡居民' ELSE '' END AS DB_INSUTYPE_NAME,")
                .append("ROUND(COUNT(S.SETL_ID),2) AS DB_SETL_PSNTIME,")
                .append("SUM( S.FUND_PAY_SUMAMT ) AS DB_FUND_PAY,")
                .append("SUM( S.MEDFEE_SUMAMT ) AS DB_MEDFEE_SUMAMT,")
                .append("ROUND(SUM(DATEDIFF(S.ENDDATE,S.BEGNDATE)),2) AS DB_IPT_TOTL_DAYS")
                .append(" FROM setl_d S")
                .append(" WHERE S.TIME>='{}' and S.BIZ_DATE<='{}' and S.VALI_FLAG = '1' and substr(S.INSU_ADMDVS,1,2) <> substr(S.FIX_BLNG_ADMDVS,1,2)")
                .append(" GROUP BY S.INSU_ADMDVS,S.INSUTYPE")
                .append(") T1")
                .append(" LEFT JOIN dim_pub_admdvs_ds T2 ON  T1.DB_ADMDVS = T2.ADMDVS;");
    }


    public static Map<String, String> buildSelectSQL(String fileName) {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        String path1 = ClassLoader.getSystemClassLoader().getResource(fileName).getPath();
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path1), "UTF-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        String[] split = builder.toString().split(";");
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < split.length - 1; i++) {
            if ((i & 1) == 0) {
                map.put(split[i], split[i+1] + ";");
            }
        }
        return map;
    }
}
