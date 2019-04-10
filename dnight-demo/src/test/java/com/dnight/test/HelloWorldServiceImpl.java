package com.dnight.test;

/**
 * @author ZHONGPENG769
 * @date 2019/3/28
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    private String text;
    private OutputService outputService;

    @Override
    public void helloWorld() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OutputService outputService) {
        this.outputService = outputService;
    }
}
