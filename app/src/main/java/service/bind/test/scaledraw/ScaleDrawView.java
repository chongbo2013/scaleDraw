package service.bind.test.scaledraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2016/8/10.
 */
public class ScaleDrawView extends View {

    Bitmap iamge;
    public ScaleDrawView(Context context) {
        super(context);
        init();
    }

    public ScaleDrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ScaleDrawView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    Paint mPaint=new Paint();
    public void init(){
        mPaint.setColor(Color.BLUE);
        iamge= BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
    }
    float radio=0f;
    final float radioMax=3f;
    @Override
    protected void onDraw(Canvas canvas) {
        int with=getWidth();
        int height=getHeight();
        //
        if(radio>=radioMax){
            radio=0;
        }
        canvas.save();
        canvas.drawRect(getPaddingLeft(),getPaddingTop(),getWidth()-getPaddingRight(),getHeight()-getPaddingBottom(),mPaint);
        int srcWidth=iamge.getWidth();
        int srcHeight=iamge.getHeight();

        int dstWidth= (int) (srcWidth*radio);
        int dstHeight= (int) (srcHeight*radio);
        Matrix matrix = new Matrix();
        //
        matrix.preScale(radio,radio);
        matrix.postTranslate((with-dstWidth)/2,(height-dstHeight)/2);

        canvas.drawBitmap(iamge,matrix,null);

        canvas.restore();
        radio+=0.01f;
        invalidate();
    }


}
