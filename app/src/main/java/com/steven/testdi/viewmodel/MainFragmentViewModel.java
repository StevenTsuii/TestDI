package com.steven.testdi.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.widget.Button;

import com.steven.testdi.BR;

/**
 * Created by steventsui on 14/3/2017.
 */
public class MainFragmentViewModel{
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> subtitle = new ObservableField<>();
    public final ObservableField<String> buttonName = new ObservableField<>();
}

//public class MainFragmentViewModel extends BaseObservable{
//
//    private String title;
//    private String subtitle;
//    private String buttonName;
//
//    public MainFragmentViewModel(String title, String subtitle, String buttonName) {
//        this.title = title;
//        this.subtitle = subtitle;
//        this.buttonName = buttonName;
//    }
//
//    @Bindable
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//        notifyPropertyChanged(BR.title);
//
//    }
//    @Bindable
//    public String getSubtitle() {
//        return subtitle;
//    }
//
//    public void setSubtitle(String subtitle) {
//        this.subtitle = subtitle;
//        notifyPropertyChanged(BR.subtitle);
//    }
//
//    @Bindable
//    public String getButtonName() {
//        return buttonName;
//    }
//
//    public void setButtonName(String buttonName) {
//        this.buttonName = buttonName;
//        notifyPropertyChanged(BR.buttonName);
//    }
//}
