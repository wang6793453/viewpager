package com.fanwe.library.viewpager.indicator.adapter;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

import com.fanwe.library.viewpager.indicator.IPagerIndicatorItemView;

/**
 * Created by Administrator on 2017/8/25.
 */

public abstract class PagerIndicatorAdapter
{
    private final DataSetObservable mDataSetObservable = new DataSetObservable();

    public final void registerDataSetObserver(DataSetObserver observer)
    {
        mDataSetObservable.registerObserver(observer);
    }

    public final void unregisterDataSetObserver(DataSetObserver observer)
    {
        mDataSetObservable.unregisterObserver(observer);
    }

    public final void notifyDataSetChanged()
    {
        mDataSetObservable.notifyChanged();
    }

    /**
     * 创建ItemView
     *
     * @param position
     * @param viewParent
     * @return
     */
    public final View createView(int position, ViewGroup viewParent)
    {
        IPagerIndicatorItemView itemView = onCreateView(position, viewParent);
        if (itemView instanceof View)
        {
            return (View) itemView;
        } else
        {
            throw new IllegalArgumentException("onCreateView must return instance of View");
        }
    }

    /**
     * 创建ItemView
     *
     * @param position
     * @param viewParent
     * @return
     */
    protected abstract IPagerIndicatorItemView onCreateView(int position, ViewGroup viewParent);

}