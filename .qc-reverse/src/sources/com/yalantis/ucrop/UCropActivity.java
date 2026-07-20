package com.yalantis.ucrop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.quickcursor.R;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import defpackage.ag;
import defpackage.az0;
import defpackage.i8;
import defpackage.j1;
import defpackage.k8;
import defpackage.qb;
import defpackage.rc;
import defpackage.re1;
import defpackage.tb0;
import defpackage.tf;
import defpackage.tq;
import defpackage.ua0;
import defpackage.wc1;
import defpackage.x81;
import defpackage.xc1;
import defpackage.xr;
import defpackage.z7;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class UCropActivity extends z7 {
    public static final Bitmap.CompressFormat e0 = Bitmap.CompressFormat.JPEG;
    public String A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public boolean J;
    public UCropView L;
    public GestureCropImageView M;
    public OverlayView N;
    public ViewGroup O;
    public ViewGroup P;
    public ViewGroup Q;
    public ViewGroup R;
    public ViewGroup S;
    public ViewGroup T;
    public TextView V;
    public TextView W;
    public View X;
    public rc Y;
    public boolean K = true;
    public final ArrayList U = new ArrayList();
    public Bitmap.CompressFormat Z = e0;
    public int a0 = 90;
    public int[] b0 = {1, 2, 3};
    public final wc1 c0 = new wc1(this, 0);
    public final xc1 d0 = new xc1(this, 3);

    static {
        i8 i8Var = k8.b;
        int i = re1.a;
    }

    public final void E(int i) {
        GestureCropImageView gestureCropImageView = this.M;
        int i2 = this.b0[i];
        gestureCropImageView.setScaleEnabled(i2 == 3 || i2 == 1);
        GestureCropImageView gestureCropImageView2 = this.M;
        int i3 = this.b0[i];
        gestureCropImageView2.setRotateEnabled(i3 == 3 || i3 == 2);
    }

    public final void F(Throwable th) {
        setResult(96, new Intent().putExtra("com.yalantis.ucrop.Error", th));
    }

    public final void G(int i) {
        if (this.J) {
            this.O.setSelected(i == R.id.state_aspect_ratio);
            this.P.setSelected(i == R.id.state_rotate);
            this.Q.setSelected(i == R.id.state_scale);
            this.R.setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
            this.S.setVisibility(i == R.id.state_rotate ? 0 : 8);
            this.T.setVisibility(i == R.id.state_scale ? 0 : 8);
            x81.a((ViewGroup) findViewById(R.id.ucrop_photobox), this.Y);
            this.Q.findViewById(R.id.text_view_scale).setVisibility(i == R.id.state_scale ? 0 : 8);
            this.O.findViewById(R.id.text_view_crop).setVisibility(i == R.id.state_aspect_ratio ? 0 : 8);
            this.P.findViewById(R.id.text_view_rotate).setVisibility(i == R.id.state_rotate ? 0 : 8);
            if (i == R.id.state_scale) {
                E(0);
            } else if (i == R.id.state_rotate) {
                E(1);
            } else {
                E(2);
            }
        }
    }

    @Override // defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public final void onCreate(Bundle bundle) {
        ArrayList arrayList;
        super.onCreate(bundle);
        setContentView(R.layout.ucrop_activity_photobox);
        Intent intent = getIntent();
        this.C = intent.getIntExtra("com.yalantis.ucrop.StatusBarColor", getColor(R.color.ucrop_color_statusbar));
        this.B = intent.getIntExtra("com.yalantis.ucrop.ToolbarColor", getColor(R.color.ucrop_color_toolbar));
        this.D = intent.getIntExtra("com.yalantis.ucrop.UcropColorControlsWidgetActive", getColor(R.color.ucrop_color_active_controls_color));
        this.E = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarWidgetColor", getColor(R.color.ucrop_color_toolbar_widget));
        this.G = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCancelDrawable", R.drawable.ucrop_ic_cross);
        this.H = intent.getIntExtra("com.yalantis.ucrop.UcropToolbarCropDrawable", R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra("com.yalantis.ucrop.UcropToolbarTitleText");
        this.A = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.A = stringExtra;
        this.I = intent.getIntExtra("com.yalantis.ucrop.UcropLogoColor", getColor(R.color.ucrop_color_default_logo));
        int i = 0;
        this.J = !intent.getBooleanExtra("com.yalantis.ucrop.HideBottomControls", false);
        this.F = intent.getIntExtra("com.yalantis.ucrop.UcropRootViewBackgroundColor", getColor(R.color.ucrop_color_crop_background));
        int i2 = this.C;
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i2);
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.B);
        toolbar.setTitleTextColor(this.E);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.E);
        textView.setText(this.A);
        Drawable drawableMutate = getDrawable(this.G).mutate();
        int i3 = this.E;
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_ATOP;
        drawableMutate.setColorFilter(i3, mode);
        toolbar.setNavigationIcon(drawableMutate);
        D(toolbar);
        j1 j1VarV = v();
        if (j1VarV != null) {
            j1VarV.q();
        }
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.L = uCropView;
        this.M = uCropView.getCropImageView();
        this.N = this.L.getOverlayView();
        this.M.setTransformImageListener(this.c0);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.I, mode);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.F);
        if (!this.J) {
            ((RelativeLayout.LayoutParams) findViewById(R.id.ucrop_frame).getLayoutParams()).bottomMargin = 0;
            findViewById(R.id.ucrop_frame).requestLayout();
        }
        ViewGroup viewGroup = null;
        if (this.J) {
            ViewGroup viewGroup2 = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup2.setVisibility(0);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup2, true);
            rc rcVar = new rc();
            this.Y = rcVar;
            rcVar.A(50L);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.O = viewGroup3;
            xc1 xc1Var = this.d0;
            viewGroup3.setOnClickListener(xc1Var);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_rotate);
            this.P = viewGroup4;
            viewGroup4.setOnClickListener(xc1Var);
            ViewGroup viewGroup5 = (ViewGroup) findViewById(R.id.state_scale);
            this.Q = viewGroup5;
            viewGroup5.setOnClickListener(xc1Var);
            this.R = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.S = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.T = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            int intExtra = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
            if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
                parcelableArrayListExtra = new ArrayList();
                parcelableArrayListExtra.add(new qb(null, 1.0f, 1.0f));
                parcelableArrayListExtra.add(new qb(null, 3.0f, 4.0f));
                parcelableArrayListExtra.add(new qb(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
                parcelableArrayListExtra.add(new qb(null, 3.0f, 2.0f));
                parcelableArrayListExtra.add(new qb(null, 16.0f, 9.0f));
                intExtra = 2;
            }
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
            layoutParams.weight = 1.0f;
            int size = parcelableArrayListExtra.size();
            int i4 = 0;
            while (true) {
                arrayList = this.U;
                if (i4 >= size) {
                    break;
                }
                Object obj = parcelableArrayListExtra.get(i4);
                i4++;
                FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, viewGroup);
                frameLayout.setLayoutParams(layoutParams);
                AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
                aspectRatioTextView.setActiveColor(this.D);
                aspectRatioTextView.setAspectRatio((qb) obj);
                linearLayout.addView(frameLayout);
                arrayList.add(frameLayout);
                viewGroup = null;
            }
            ((ViewGroup) arrayList.get(intExtra)).setSelected(true);
            int size2 = arrayList.size();
            int i5 = 0;
            while (i5 < size2) {
                Object obj2 = arrayList.get(i5);
                i5++;
                ((ViewGroup) obj2).setOnClickListener(new xc1(this, i));
            }
            this.V = (TextView) findViewById(R.id.text_view_rotate);
            int i6 = 1;
            ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setScrollingListener(new wc1(this, i6));
            ((HorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel)).setMiddleLineColor(this.D);
            findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new xc1(this, i6));
            findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new xc1(this, 2));
            int i7 = this.D;
            TextView textView2 = this.V;
            if (textView2 != null) {
                textView2.setTextColor(i7);
            }
            this.W = (TextView) findViewById(R.id.text_view_scale);
            ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new wc1(this, 2));
            ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.D);
            int i8 = this.D;
            TextView textView3 = this.W;
            if (textView3 != null) {
                textView3.setTextColor(i8);
            }
            ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
            ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
            ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
            imageView.setImageDrawable(new az0(imageView.getDrawable(), this.D));
            imageView2.setImageDrawable(new az0(imageView2.getDrawable(), this.D));
            imageView3.setImageDrawable(new az0(imageView3.getDrawable(), this.D));
        }
        Uri uri = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.InputUri");
        Uri uri2 = (Uri) intent.getParcelableExtra("com.yalantis.ucrop.OutputUri");
        String stringExtra2 = intent.getStringExtra("com.yalantis.ucrop.CompressionFormatName");
        Bitmap.CompressFormat compressFormatValueOf = !TextUtils.isEmpty(stringExtra2) ? Bitmap.CompressFormat.valueOf(stringExtra2) : null;
        if (compressFormatValueOf == null) {
            compressFormatValueOf = e0;
        }
        this.Z = compressFormatValueOf;
        this.a0 = intent.getIntExtra("com.yalantis.ucrop.CompressionQuality", 90);
        int[] intArrayExtra = intent.getIntArrayExtra("com.yalantis.ucrop.AllowedGestures");
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.b0 = intArrayExtra;
        }
        this.M.setMaxBitmapSize(intent.getIntExtra("com.yalantis.ucrop.MaxBitmapSize", 0));
        this.M.setMaxScaleMultiplier(intent.getFloatExtra("com.yalantis.ucrop.MaxScaleMultiplier", 10.0f));
        this.M.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra("com.yalantis.ucrop.ImageToCropBoundsAnimDuration", 500));
        this.N.setFreestyleCropEnabled(intent.getBooleanExtra("com.yalantis.ucrop.FreeStyleCrop", false));
        this.N.setDimmedColor(intent.getIntExtra("com.yalantis.ucrop.DimmedLayerColor", getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.N.setCircleDimmedLayer(intent.getBooleanExtra("com.yalantis.ucrop.CircleDimmedLayer", false));
        this.N.setShowCropFrame(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropFrame", true));
        this.N.setCropFrameColor(intent.getIntExtra("com.yalantis.ucrop.CropFrameColor", getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.N.setCropFrameStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropFrameStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.N.setShowCropGrid(intent.getBooleanExtra("com.yalantis.ucrop.ShowCropGrid", true));
        this.N.setCropGridRowCount(intent.getIntExtra("com.yalantis.ucrop.CropGridRowCount", 2));
        this.N.setCropGridColumnCount(intent.getIntExtra("com.yalantis.ucrop.CropGridColumnCount", 2));
        this.N.setCropGridColor(intent.getIntExtra("com.yalantis.ucrop.CropGridColor", getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.N.setCropGridStrokeWidth(intent.getIntExtra("com.yalantis.ucrop.CropGridStrokeWidth", getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioX", 0.0f);
        float floatExtra2 = intent.getFloatExtra("com.yalantis.ucrop.AspectRatioY", 0.0f);
        int intExtra2 = intent.getIntExtra("com.yalantis.ucrop.AspectRatioSelectedByDefault", 0);
        ArrayList parcelableArrayListExtra2 = intent.getParcelableArrayListExtra("com.yalantis.ucrop.AspectRatioOptions");
        if (floatExtra > 0.0f && floatExtra2 > 0.0f) {
            ViewGroup viewGroup6 = this.O;
            if (viewGroup6 != null) {
                viewGroup6.setVisibility(8);
            }
            this.M.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra2 == null || intExtra2 >= parcelableArrayListExtra2.size()) {
            this.M.setTargetAspectRatio(0.0f);
        } else {
            this.M.setTargetAspectRatio(((qb) parcelableArrayListExtra2.get(intExtra2)).c / ((qb) parcelableArrayListExtra2.get(intExtra2)).d);
        }
        int intExtra3 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeX", 0);
        int intExtra4 = intent.getIntExtra("com.yalantis.ucrop.MaxSizeY", 0);
        if (intExtra3 > 0 && intExtra4 > 0) {
            this.M.setMaxResultImageSizeX(intExtra3);
            this.M.setMaxResultImageSizeY(intExtra4);
        }
        if (uri == null || uri2 == null) {
            F(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
            finish();
        } else {
            try {
                GestureCropImageView gestureCropImageView = this.M;
                int maxBitmapSize = gestureCropImageView.getMaxBitmapSize();
                new ag(gestureCropImageView.getContext(), uri, uri2, maxBitmapSize, maxBitmapSize, new tb0(19, gestureCropImageView)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } catch (Exception e) {
                F(e);
                finish();
            }
        }
        if (!this.J) {
            E(0);
        } else if (this.O.getVisibility() == 0) {
            G(R.id.state_aspect_ratio);
        } else {
            G(R.id.state_scale);
        }
        if (this.X == null) {
            this.X = new View(this);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(3, R.id.toolbar);
            this.X.setLayoutParams(layoutParams2);
            this.X.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.X);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_loader);
        Drawable icon = menuItemFindItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.E, PorterDuff.Mode.SRC_ATOP);
                menuItemFindItem.setIcon(icon);
            } catch (IllegalStateException e) {
                Log.i("UCropActivity", e.getMessage() + " - " + getString(R.string.ucrop_mutate_exception_hint));
            }
            ((Animatable) menuItemFindItem.getIcon()).start();
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawable = getDrawable(this.H);
        if (drawable == null) {
            return true;
        }
        drawable.mutate();
        drawable.setColorFilter(this.E, PorterDuff.Mode.SRC_ATOP);
        menuItemFindItem2.setIcon(drawable);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.menu_crop) {
            if (menuItem.getItemId() != 16908332) {
                return super.onOptionsItemSelected(menuItem);
            }
            onBackPressed();
            return true;
        }
        this.X.setClickable(true);
        this.K = true;
        u().b();
        GestureCropImageView gestureCropImageView = this.M;
        Bitmap.CompressFormat compressFormat = this.Z;
        int i = this.a0;
        wc1 wc1Var = new wc1(this, 3);
        gestureCropImageView.f();
        gestureCropImageView.setImageToWrapCropBounds(false);
        RectF rectF = gestureCropImageView.t;
        RectF rectFO = xr.O(gestureCropImageView.e);
        float currentScale = gestureCropImageView.getCurrentScale();
        float currentAngle = gestureCropImageView.getCurrentAngle();
        ua0 ua0Var = new ua0();
        ua0Var.a = rectF;
        ua0Var.b = rectFO;
        ua0Var.c = currentScale;
        ua0Var.d = currentAngle;
        int i2 = gestureCropImageView.C;
        int i3 = gestureCropImageView.D;
        String imageInputPath = gestureCropImageView.getImageInputPath();
        String imageOutputPath = gestureCropImageView.getImageOutputPath();
        gestureCropImageView.getExifInfo();
        tq tqVar = new tq();
        tqVar.a = i2;
        tqVar.b = i3;
        tqVar.d = compressFormat;
        tqVar.c = i;
        tqVar.e = imageInputPath;
        tqVar.f = imageOutputPath;
        new tf(gestureCropImageView.getContext(), gestureCropImageView.getViewBitmap(), ua0Var, tqVar, wc1Var).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.K);
        menu.findItem(R.id.menu_loader).setVisible(this.K);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // defpackage.z7, android.app.Activity
    public final void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.M;
        if (gestureCropImageView != null) {
            gestureCropImageView.f();
        }
    }
}
