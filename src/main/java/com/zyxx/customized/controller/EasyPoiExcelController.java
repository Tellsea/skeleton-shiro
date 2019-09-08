package com.zyxx.customized.controller;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.zyxx.common.entity.UserInfo;
import com.zyxx.common.service.UserInfoService;
import com.zyxx.skeleton.assembly.easypoi.util.EasyPoiExcelUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Excel 导入导出
 *
 * @author: Tellsea
 * @date: 2019/09/04
 */
@Slf4j
@Controller
@RequestMapping("excel")
public class EasyPoiExcelController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("export")
    public void export(HttpServletResponse response) {
        List<UserInfo> list = userInfoService.selectAll();
        EasyPoiExcelUtils.exportExcel(list, "easypoi导出功能", "导出sheet1", UserInfo.class, "系统用户表.xls", response);
    }

    @PostMapping("import")
    public String importTest(@RequestParam("file") MultipartFile file) {
        ImportParams importParams = new ImportParams();
        // 数据处理
        importParams.setHeadRows(1);
        importParams.setTitleRows(1);
        // 需要验证
        importParams.setNeedVerify(false);
        try {
            ExcelImportResult<UserInfo> result = ExcelImportUtil.importExcelMore(file.getInputStream(), UserInfo.class, importParams);
            List<UserInfo> list = result.getList();
            list.forEach(userInfo -> {
                log.info("从Excel导入数据到数据库的详细为 ：{}", JSONObject.toJSONString(userInfo));
            });
            log.info("从Excel导入数据一共 {} 行 ", list.size());
        } catch (IOException e) {
            log.error("导入失败：{}", e.getMessage());
        } catch (Exception e1) {
            log.error("导入失败：{}", e1.getMessage());
        }
        return "导入成功";
    }
}
