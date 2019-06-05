package com.dnight.base.framework.common.logback;

import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggingEvent;
import ch.qos.logback.classic.spi.StackTraceElementProxy;
import ch.qos.logback.core.rolling.RollingFileAppender;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author huhailiang937
 * @date 2017年8月4日下午3:34:11
 * @since 1.0.0
 */
public class EARollingFileAppender<E> extends RollingFileAppender<E> {

    public static LRULinkedHashMap<String, Map<ExceptionReport, Integer>> lruCache = new LRULinkedHashMap<String, Map<ExceptionReport, Integer>>(
            1024);

    public EARollingFileAppender() {
        System.out.println(" ---> EARollingFileAppender Inited -- ");
    }

    @Override
    protected void append(E eventObject) {
        super.append(eventObject);
        if (eventObject instanceof LoggingEvent) {
            LoggingEvent loggingEvent = (LoggingEvent) eventObject;
            processExceptionReport(loggingEvent);
            return;
        }
    }

    private void processExceptionReport(LoggingEvent loggingEvent) {
        try {
            IThrowableProxy throwableProxy = loggingEvent.getThrowableProxy();
            if (null != throwableProxy) {
                ExceptionReport exceptionReport = new ExceptionReport(throwableProxy);
                Map<ExceptionReport, Integer> exceptionReportMap = lruCache.get(exceptionReport.exceptionName);
                if (null == exceptionReportMap) {
                    exceptionReportMap = new HashMap<ExceptionReport, Integer>();
                    lruCache.put(exceptionReport.exceptionName, exceptionReportMap);
                }
                Integer num = exceptionReportMap.get(exceptionReport);
                exceptionReportMap.put(exceptionReport, (null == num) ? 1 : num + 1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }


    public static class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private int capacity;
        private static final long serialVersionUID = 1L;

        LRULinkedHashMap(int capacity) {
            super(16, 0.75f, true);
            this.capacity = capacity;
        }

        // 实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
        @Override
        public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public static class ExceptionReport {

        public ExceptionReport(IThrowableProxy throwableProxy) {
            String exceptionClassName = throwableProxy.getClassName();
            exceptionName = exceptionClassName.substring(exceptionClassName.lastIndexOf(".") + 1);
            StackTraceElementProxy[] stackTraceElementProxys = throwableProxy.getStackTraceElementProxyArray();
            if (null != stackTraceElementProxys) {
                StackTraceElementProxy topStrace = stackTraceElementProxys[0];
                exceptionThrowline = topStrace.getSTEAsString().substring(topStrace.getSTEAsString().indexOf("(") + 1,
                        topStrace.getSTEAsString().length() - 1);
                exceptionThrowClass = exceptionThrowline.split(":")[0];
            }
        }

        public String exceptionName;

        public String exceptionThrowline = "";

        public String exceptionThrowClass = "";

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((exceptionName == null) ? 0 : exceptionName.hashCode());
            result = prime * result + ((exceptionThrowline == null) ? 0 : exceptionThrowline.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            ExceptionReport other = (ExceptionReport) obj;
            if (exceptionName == null) {
                if (other.exceptionName != null)
                    return false;
            } else if (!exceptionName.equals(other.exceptionName))
                return false;
            if (exceptionThrowline == null) {
                if (other.exceptionThrowline != null)
                    return false;
            } else if (!exceptionThrowline.equals(other.exceptionThrowline))
                return false;
            return true;
        }

    }

}
