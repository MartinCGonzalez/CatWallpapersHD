package com.catswallpapershd.catswallpapershd;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import static java.security.AccessController.getContext;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public Integer[] mThumbIds = {
            R.drawable.image_1, R.drawable.image_2,
            R.drawable.image_3, R.drawable.image_4,
            R.drawable.image_5, R.drawable.image_6,
            R.drawable.image_7, R.drawable.image_8,
            R.drawable.image_9, R.drawable.image_10,
            R.drawable.image_11, R.drawable.image_12,
            R.drawable.image_13, R.drawable.image_14,
            R.drawable.image_15, R.drawable.image_16,
            R.drawable.image_17, R.drawable.image_18,
            R.drawable.image_19, R.drawable.image_20,
            R.drawable.image_21, R.drawable.image_22,
            R.drawable.image_23, R.drawable.image_24,
            R.drawable.image_25, R.drawable.image_26,
            R.drawable.image_27, R.drawable.image_28,
            R.drawable.image_29, R.drawable.image_30,
            R.drawable.image_31, R.drawable.image_32,
            R.drawable.image_33, R.drawable.image_34,
            R.drawable.image_35, R.drawable.image_36,
            R.drawable.image_37, R.drawable.image_38,
            R.drawable.image_39, R.drawable.image_40,
            R.drawable.image_41, R.drawable.image_42,
            R.drawable.image_43, R.drawable.image_44,
            R.drawable.image_45, R.drawable.image_46,
            R.drawable.image_47, R.drawable.image_48,
            R.drawable.image_49, R.drawable.image_50,
            R.drawable.image_51,
            R.drawable.image_53, R.drawable.image_54,
            R.drawable.image_55, R.drawable.image_56,
            R.drawable.image_58,
            R.drawable.image_59, R.drawable.image_60,
            R.drawable.image_61, R.drawable.image_62,
            R.drawable.image_63, R.drawable.image_64,
            R.drawable.image_65, R.drawable.image_66,
            R.drawable.image_67, R.drawable.image_68,
            };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(decodeSampledBitmapFromResource(mContext.getResources(), mThumbIds[position], 100, 100));

        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        int width = metrics.widthPixels/3;
        int height = metrics.heightPixels/3;

        imageView.setLayoutParams(new GridView.LayoutParams(width, height));

        return imageView;
    }

    private Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                   int reqWidth, int reqHeight) {

        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    private int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {

        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 2;

        if (height > reqHeight || width > reqWidth) {

            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }
}
