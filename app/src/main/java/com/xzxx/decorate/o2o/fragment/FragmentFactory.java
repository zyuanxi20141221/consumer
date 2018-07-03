package com.xzxx.decorate.o2o.fragment;

import java.util.HashMap;

public class FragmentFactory {

    private static HashMap<Integer, BaseFragment> mBaseFragments = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int pos) {
        BaseFragment baseFragment = mBaseFragments.get(pos);

        if (baseFragment == null) {
            switch (pos) {
                case 0:
                    baseFragment = new AllOrderFragment();
                    break;
                case 1:
                    baseFragment = new ToBeEvaluateFragment();
                    break;
                case 2:
                    baseFragment = new AfterSaleServiceFragment();
                    break;
            }
            mBaseFragments.put(pos, baseFragment);
        }
        return baseFragment;
    }
}
