package com.geccocrawler.gecco.listener;

import com.geccocrawler.gecco.GeccoEngine;

/**
 * 爬虫引擎生命周期监听器
 *
 * @author LiuJunGuang
 */
public interface EventListener {

    /**
     * 开始启动时，回调
     *
     * @param ge GeccoEngine
     */
    void onStart(GeccoEngine ge);

    /**
     * 暂停时，回调
     *
     * @param ge GeccoEngine
     */
    void onPause(GeccoEngine ge);

    /**
     * 恢复抓取时，回调
     *
     * @param ge GeccoEngine
     */
    void onRestart(GeccoEngine ge);

    /**
     * 引擎停止时，回调
     *
     * @param ge GeccoEngine
     */
    void onStop(GeccoEngine ge);
}
