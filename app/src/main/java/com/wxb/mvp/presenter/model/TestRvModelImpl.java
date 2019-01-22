package com.wxb.mvp.presenter.model;

import com.wxb.mvp.base.BaseSrcModel;
import com.wxb.mvp.contract.TestRvContract;
import com.wxb.mvp.model.api.MallApiService;
import com.wxb.mvp.model.api.TrtApiService;
import com.wxb.mvp.presenter.model.proxy.IProxy;
import com.wxb.mvp.presenter.model.strategy.AliStrategy;
import com.wxb.mvp.presenter.model.strategy.IBMStrategy;
import com.wxb.mvp.presenter.model.strategy.IStrategy;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.observers.DisposableObserver;

public class TestRvModelImpl extends BaseSrcModel implements IProxy {

//    private MallApiService mallApiService;
//    private TrtApiService trtApiService;

    private IStrategy mStrategy;//api接口策略

    @Inject
    TestRvModelImpl(MallApiService mallApiService, TrtApiService trtApiService) {
//        this.mallApiService = mallApiService;
//        this.trtApiService = trtApiService;

        //通过配置判断 具体的策略实现
        if (isAli()) {
            mStrategy = new AliStrategy(mallApiService);
        } else {
            mStrategy = new IBMStrategy(trtApiService);
        }

    }

    public DisposableObserver getToken(Map<String, String> map, TestRvContract.TestRvCallback callback) {
//        IProxy iProxy;
//        if (isAli()) {
//            iProxy = new TestAliProxy();
//        } else {
//            iProxy = new TestIbmProxy();
//        }
//        //        IProxy iProxy = new TestAliProxy();
//        //我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
//        InvocationHandler handler = new DynamicProxy(iProxy);
//        /*
//         * 通过Proxy的newProxyInstance方法来创建我们的代理对象，我们来看看其三个参数
//         * 第一个参数 handler.getClass().getClassLoader() ，我们这里使用handler这个类的ClassLoader对象来加载我们的代理对象
//         * 第二个参数customer.getClass().getInterfaces()，我们这里为代理对象提供的接口是真实对象所实行的接口，表示我要代理的是该真实对象，这样我就能调用这组接口中的方法了
//         * 第三个参数handler， 我们这里将这个代理对象关联到了上方的 InvocationHandler 这个对象上
//         */
//        IProxy proxy = (IProxy) Proxy.newProxyInstance(handler.getClass().getClassLoader(), iProxy.getClass().getInterfaces(), handler);
//        return proxy.getToken(map, callback);

        return mStrategy.getToken(map, callback);
    }
}
