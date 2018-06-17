package com.example.vedcomputech.bitmapeg;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

/**
 * Created by Ved Computech on 09-02-2018.
 */

public class Sample extends View {

    //Medium listener;
    Context mContext;
    Canvas c,c1,c2,c3,c4,c5;

    public Sample(Context context) {
        super(context);
        this.mContext=context;
        setFocusable(true);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        canvas.drawColor(Color.GRAY);

        Bitmap bmap = Bitmap.createBitmap(1500,1000,Bitmap.Config.ALPHA_8);
        c = new Canvas(bmap);c1 = new Canvas(bmap);
        c2 = new Canvas(bmap);c3 = new Canvas(bmap);
        c4 = new Canvas(bmap);c5 = new Canvas(bmap);

        c.drawRect(0,0,1000,100,paint);c1.drawRect(1001,0,1500,500,paint);
        c2.drawRect(0,100,1000,200,paint);c3.drawRect(0,200,1000,300,paint);
        c4.drawRect(0,300,1000,400,paint);c5.drawRect(0,400,1000,500,paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setTextSize(20);
        paint.setTextScaleX(2.0f);
        //paint.setElegantTextHeight(true);
        paint.setAlpha(0);
        paint.setAntiAlias(true);

        c.drawText("Dr. Ravindra Narula",50,60,paint);c1.drawText("Image",1200,250,paint);
        c2.drawText("MBBS,DDDH,M.D.",50,160,paint);c3.drawText("Orthopedic Specialist",50,260,paint);
        c4.drawText("123, XYZ Road,Kharghar",50,360,paint);c5.drawText("Emai:abc@doctor.com   MOB:9875693218",50,460,paint);

        paint.setColor(Color.WHITE);

        canvas.drawBitmap(bmap,5,5,paint);

        //listener.dataListenernow(bmap);
    }

       /* public void setListener(Medium listener){
            this.listener=listener;
        }*/

}










