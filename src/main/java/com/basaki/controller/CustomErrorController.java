package com.basaki.controller;

import com.basaki.error.ErrorInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * {@code CustomErrorController} used for showing error messages.
 * <p/>
 *
 * @author Indra Basak
 * @since 12/27/17
 */
@RestController
@ApiIgnore
public class CustomErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Value("${debug:true}")
    private boolean debug;

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    ErrorInfo error(HttpServletRequest request, HttpServletResponse response) {
        ErrorInfo info = new ErrorInfo();
        info.setCode(response.getStatus());
//        Map<String, Object> attributes = getErrorAttributes(request, debug);
//        info.setMessage((String) attributes.get("message"));
//        System.out.println((String) attributes.get("error"));
        return info;
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

//    private Map<String, Object> getErrorAttributes(HttpServletRequest request,
//            boolean includeStackTrace) {
//        RequestAttributes requestAttributes =
//                new ServletRequestAttributes(request);
//        return errorAttributes.getErrorAttributes(requestAttributes,
//                includeStackTrace);
//    }
}
