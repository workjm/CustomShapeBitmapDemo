package com.ape.customshapedemo;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;

public class Utils {
	
	/**
	 * Drawable change to bitmap
	 * @param drawable
	 * @return
	 */
	public static Bitmap drawable2Bitmap(Drawable drawable) {
		Bitmap bitmap = Bitmap
				.createBitmap(
						drawable.getIntrinsicWidth(),
						drawable.getIntrinsicHeight(),
						Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(bitmap);
		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
				drawable.getIntrinsicHeight());
		drawable.draw(canvas);
		return bitmap;
	}
	
	
	/**
	 * Get subset of bitmap fill into shapeBitmap
	 * @param context
	 * @param src:bitmap
	 * @param shape:shapeBitmap
	 * @param pixels
	 * @return
	 */
	static Bitmap getShapedBitmap(Context context, Bitmap bitmap, Bitmap shapeBitmap,
			int pixels) {
		try {
			Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
					bitmap.getHeight(), Config.ARGB_8888);
			Canvas canvas = new Canvas(output);
			final Paint paint = new Paint();
			final Rect rectIcon = new Rect(0, 0, bitmap.getWidth(),
					bitmap.getHeight());
//			final RectF rectF = new RectF(rect);
			final float roundPx = pixels;
			final Rect rectShape = new Rect(0,0,shapeBitmap.getWidth(), shapeBitmap.getHeight());

			paint.setAntiAlias(true);
			canvas.drawARGB(0, 0, 0, 0);
//			paint.setColor(Color.BLACK);
//			 canvas.drawRoundRect(rectF, roundPx, roundPx,paint);//若想切成圆角矩形，则用这句话
			canvas.drawBitmap(shapeBitmap, rectIcon, rectShape, paint);// 切成特定的形状
			paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
			canvas.drawBitmap(bitmap, rectIcon, rectIcon, paint);
			return output;
		} catch (Exception e) {
			return null;
		}
	}
	
	
    /**
     * Get shape bitmap 
     * @return
     */
	static Bitmap getShape(int width, int height, Context context, int resourceId) {
		Bitmap bitmapShape = BitmapFactory.decodeResource(
				context.getResources(), resourceId);
		
		Bitmap output = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		canvas.drawARGB(0,0, 0, 0);
		canvas.drawBitmap(output, 0, 0, paint);
		int left = width/2 - bitmapShape.getWidth()/2;
		int top = height/2 - bitmapShape.getHeight()/2;
		canvas.drawBitmap(bitmapShape, left, top, paint);
		
		return output;
	}
	
}
