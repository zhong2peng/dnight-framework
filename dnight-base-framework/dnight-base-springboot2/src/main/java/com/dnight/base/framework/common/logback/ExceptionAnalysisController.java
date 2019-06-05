package com.dnight.base.framework.common.logback;

import com.dnight.base.framework.common.logback.EARollingFileAppender.ExceptionReport;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author huhailiang937
 * @date 2017年8月7日下午3:53:55
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/logback")
public class ExceptionAnalysisController {

    private static final String[] COLORS_TOP10 = { "#FF0000", "#9F35FF", "#F75000", "#F9F900", "#0000C6", "#00DB00",
            "#808040", "#02C874", "#BB5E00", "#C4E1E1" };

    private static final String E_INFO = "<li><span><p></p>%s</span><ul>%s</ul></li>";

    private static String exceptionHtml = "";

    static {
        try {
            InputStream in = ExceptionAnalysisController.class.getResourceAsStream("/exception.html");
            byte[] buffer = new byte[1024];
            int readBytes = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((readBytes = in.read(buffer)) > 0) {
                stringBuilder.append(new String(buffer, 0, readBytes));
            }
            exceptionHtml = stringBuilder.toString();
        } catch (IOException e) {
        }
    }

    @RequestMapping(value = "/exceptionAnalysis.html")
    public void htmlView(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Map<String, Integer> infoMaps = new HashMap<String, Integer>();
        Integer totalNum = 0;
        for (Map.Entry<String, Map<ExceptionReport, Integer>> entry : EARollingFileAppender.lruCache.entrySet()) {
            String exceptionName = entry.getKey();
            Integer num = 0;
            for (Map.Entry<ExceptionReport, Integer> temp : entry.getValue().entrySet()) {
                num += temp.getValue();
            }
            totalNum += num;
            infoMaps.put(exceptionName, num);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(infoMaps.entrySet());
        // 对list排序,实现新的比较器
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        ArrayList<Float> dataPrect = new ArrayList<Float>();
        ArrayList<String> dataColor = new ArrayList<String>();
        ArrayList<String> dataExcpeptionName = new ArrayList<String>();


        StringBuilder exceptionDetailInfonBuilder = new StringBuilder(1024);
        for (int i = 0; i < (list.size() > 10 ? 10 : list.size()); i++) {
            Map.Entry<String, Integer> top10Temp = list.get(i);
            dataExcpeptionName.add(top10Temp.getKey());
            dataColor.add(COLORS_TOP10[i%10]);
            dataPrect.add((float)(top10Temp.getValue()*1.0) / totalNum );
            String exceptionIfo = String.format("%s : 总数%d", top10Temp.getKey(),top10Temp.getValue());
            Map<ExceptionReport, Integer>  exceptionMap = EARollingFileAppender.lruCache.get(top10Temp.getKey());
            StringBuilder subException = new StringBuilder(512);
            for(Map.Entry<ExceptionReport, Integer> entry : exceptionMap.entrySet()){
                subException.append("<li>"+entry.getKey().exceptionThrowline+": 总数"+entry.getValue()+"</li>");
            }
            exceptionDetailInfonBuilder.append(String.format(E_INFO,exceptionIfo,subException.toString()));
        }

        StringBuffer drawCircleArg = new StringBuffer();
        ObjectMapper mapper = new ObjectMapper();
        drawCircleArg.append(String.format("var dataPrect = %s;", mapper.writeValueAsString(dataPrect)));
        drawCircleArg.append(String.format("var dataColor = %s;", mapper.writeValueAsString(dataColor)));
        drawCircleArg.append(String.format("var dataTitle = %s;", mapper.writeValueAsString(dataExcpeptionName)));

        String html = exceptionHtml.replace("#INIT_DATA#", drawCircleArg.toString()).replace("#INIT_SUB_DATA#", exceptionDetailInfonBuilder.toString());

        response.setHeader("Content-type", "text/html;charset=UTF-8");
        response.getWriter().println(html);
    }

}
