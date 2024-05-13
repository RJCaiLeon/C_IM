package top.nanachan.common.app;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class Fragment extends androidx.fragment.app.Fragment {
    protected View mRoot;
    protected Unbinder mRootUnbinder;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        // 初始化参数
        initArgs(getArguments());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            int layId = getContentLayoutId();
            // 初始化当前的根布局，但是不在创建时就添加到container里面
            View root = inflater.inflate(layId, container, false);
            initWidget(root);
            mRoot = root;
        } else {
            if (mRoot.getParent() != null) {
                // 把当前Root从其父控件中移除
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // 当View创建完成后初始化数据
        initData();
    }

    /**
     * 初始化相关参数
     *
     * @param bundle 参数Bundle
     * @return 如果参数正确就返回True，错误范围False
     */
    protected void initArgs(Bundle bundle) {
    }

    /**
     * 得到当前界面的资源文件Id
     * 在这个类中不实现，由子类实现，且子类必须实现
     *
     * @return 资源文件Id
     */
    protected abstract int getContentLayoutId();

    /**
     * 初始化控件
     *
     * @param root
     */
    protected void initWidget(View root) {
        mRootUnbinder = ButterKnife.bind(this, root);
    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 返回按键触发时调用
     *
     * @return 返回True时代表已经处理返回逻辑，Activity不用自己finish
     * 返回False代表没有处理，Activity自己走自己的逻辑
     */
    public boolean onBackPressed() {
        return false;
    }
}
