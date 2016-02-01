package br.com.radar.helper;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

public class ImageHelper {

    public ImageHelper() {
    }

    public Bitmap getRoundedShape(Bitmap scaleBitmapImage, int targetWidth , int targetHeight) {

        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth, targetHeight,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(targetBitmap);

        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2, ((float) targetHeight - 1) / 2, (Math.min(((float) targetWidth),   ((float) targetHeight)) / 2), Path.Direction.CCW);

        canvas.clipPath(path);

        canvas.drawBitmap(scaleBitmapImage,

            new Rect(0, 0, scaleBitmapImage.getWidth(), scaleBitmapImage.getHeight()),
            new Rect(0, 0, targetWidth, targetHeight), null);

        return targetBitmap;
    }


}
