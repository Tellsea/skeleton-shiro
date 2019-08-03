package cn.tellsea.skeleton.business.controller;

import cn.tellsea.skeleton.core.util.CaptchaUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;

/**
 * 验证码控制器
 *
 * @author Tellsea
 * @Description Created on 2019/7/13
 */
@Controller
public class CaptchaController {

    public static final String KEY_CAPTCHA = "KEY_CAPTCHA";

    /**
     * 生成验证码
     *
     * @param request
     * @param response
     */
    @GetMapping("/Captcha.jpg")
    public void getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        // 设置相应类型,告诉浏览器输出的内容为图片
        response.setContentType("image/jpeg");
        // 不缓存此内容
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        try {

            HttpSession session = request.getSession();

            CaptchaUtils tool = new CaptchaUtils();
            StringBuffer code = new StringBuffer();
            BufferedImage image = tool.genRandomCodeImage(code);
            session.removeAttribute(KEY_CAPTCHA);
            session.setAttribute(KEY_CAPTCHA, code.toString());

            // 将内存中的图片通过流动形式输出到客户端
            ImageIO.write(image, "JPEG", response.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
