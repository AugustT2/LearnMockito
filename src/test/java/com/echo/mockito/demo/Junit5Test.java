package com.echo.mockito.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Spring test 可以参考视频教程：E:\百度云下载\尚硅谷SpringBoot2核心技术与响应式编程\视频
 *
 * Mockito可以参考一下的笔记和视频：
 * 深入解析与实践Mockito：Java单元测试的强大助手：CSDN
 * https://blog.csdn.net/zouliping123456/article/details/137790079
 * https://blog.csdn.net/Nuan_Feng/article/details/134320386?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-4-134320386-blog-128551507.235%5Ev43%5Epc_blog_bottom_relevance_base8&spm=1001.2101.3001.4242.3&utm_relevant_index=5
 * Mockito视频：基于Java的Mock利器-Mockito
 * https://www.bilibili.com/video/BV1YN411f7wo/?spm_id_from=333.788.recommend_more_video.-1&vd_source=d1e68c232a0f84c687af021efd60e960
 */
public class Junit5Test {

    int add(int a, int b) {
        return a + b;
    }

    @Test
    void testSimpleAssertions() {
//        Assertions.assertEquals(2, add(1, 0));
        Assertions.assertEquals(3, add(1, 1), "1 + 1 should equal 2");
    }
}
