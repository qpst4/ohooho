package com.yalantis.ucrop.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.quickcursor.R;
import defpackage.ps0;
import defpackage.yc1;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class UCropView extends FrameLayout {
    public final GestureCropImageView b;
    public final OverlayView c;

    public UCropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        LayoutInflater.from(context).inflate(R.layout.ucrop_view, (ViewGroup) this, true);
        GestureCropImageView gestureCropImageView = (GestureCropImageView) findViewById(R.id.image_view_crop);
        this.b = gestureCropImageView;
        OverlayView overlayView = (OverlayView) findViewById(R.id.view_overlay);
        this.c = overlayView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ps0.b);
        overlayView.getClass();
        overlayView.m = typedArrayObtainStyledAttributes.getBoolean(2, false);
        int color = typedArrayObtainStyledAttributes.getColor(3, overlayView.getResources().getColor(R.color.ucrop_color_default_dimmed));
        overlayView.n = color;
        Paint paint = overlayView.p;
        paint.setColor(color);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(1.0f);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(5, overlayView.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width));
        int color2 = typedArrayObtainStyledAttributes.getColor(4, overlayView.getResources().getColor(R.color.ucrop_color_default_crop_frame));
        Paint paint2 = overlayView.r;
        paint2.setStrokeWidth(dimensionPixelSize);
        paint2.setColor(color2);
        paint2.setStyle(style);
        Paint paint3 = overlayView.s;
        paint3.setStrokeWidth(dimensionPixelSize * 3);
        paint3.setColor(color2);
        paint3.setStyle(style);
        overlayView.k = typedArrayObtainStyledAttributes.getBoolean(10, true);
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(9, overlayView.getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width));
        int color3 = typedArrayObtainStyledAttributes.getColor(6, overlayView.getResources().getColor(R.color.ucrop_color_default_crop_grid));
        Paint paint4 = overlayView.q;
        paint4.setStrokeWidth(dimensionPixelSize2);
        paint4.setColor(color3);
        overlayView.g = typedArrayObtainStyledAttributes.getInt(8, 2);
        overlayView.h = typedArrayObtainStyledAttributes.getInt(7, 2);
        overlayView.l = typedArrayObtainStyledAttributes.getBoolean(11, true);
        gestureCropImageView.getClass();
        float fAbs = Math.abs(typedArrayObtainStyledAttributes.getFloat(0, 0.0f));
        float fAbs2 = Math.abs(typedArrayObtainStyledAttributes.getFloat(1, 0.0f));
        if (fAbs == 0.0f || fAbs2 == 0.0f) {
            gestureCropImageView.v = 0.0f;
        } else {
            gestureCropImageView.v = fAbs / fAbs2;
        }
        typedArrayObtainStyledAttributes.recycle();
        gestureCropImageView.setCropBoundsChangeListener(new yc1(this));
        overlayView.setOverlayViewChangeListener(new yc1(this));
    }

    public GestureCropImageView getCropImageView() {
        return this.b;
    }

    public OverlayView getOverlayView() {
        return this.c;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
