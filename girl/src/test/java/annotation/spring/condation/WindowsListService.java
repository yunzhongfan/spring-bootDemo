package annotation.spring.condation;

import annotation.spring.condation.ListService;

/**
 * Created with IntelliJ IDEA.
 * User: 陈浩翔.
 * Date: 2016/12/7.
 * Time: 下午 7:41.
 * Explain:Windows下所要创建的Bean的类
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}