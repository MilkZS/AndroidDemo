package com.milkz.demo.ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;

/**
 * Create by zuoqi@bhz.com.cn on 2019/3/28 17:34
 */
public class DialogHelper extends Dialog {

    private static DialogHelper dialogHelper = null;
    private Context mContext;

    public static DialogHelper getInstance(Context mContext) {
        if (dialogHelper == null) {
            dialogHelper = new DialogHelper(mContext);
        }
        return dialogHelper;
    }

    private DialogHelper(Context context) {
        super(context);
        this.mContext = context;
    }

    public AlertDialog showWithYesAndNo(String title, String msg, OnClickListener yesListener, OnClickListener nolistener) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setCancelable(false);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setPositiveButton("确定", yesListener);
        builder.setNegativeButton("取消", nolistener);
        return builder.create();
    }
}
