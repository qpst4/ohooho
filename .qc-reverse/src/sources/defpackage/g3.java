package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.canhub.cropper.CropImageView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class g3 extends FrameLayout implements View.OnTouchListener {
    public final WindowManager b;
    public LinearLayout c;
    public final /* synthetic */ int d;
    public final iy0 e;
    public final FloatingActionButton f;
    public final FloatingActionButton g;
    public final FloatingActionButton h;
    public final FloatingActionButton i;
    public final b61 j;
    public final Object k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g3(CursorAccessibilityService cursorAccessibilityService, iy0 iy0Var, int i) {
        this(cursorAccessibilityService);
        this.d = i;
        final int i2 = 3;
        final int i3 = 1;
        final int i4 = 2;
        final int i5 = 0;
        switch (i) {
            case 1:
                this(cursorAccessibilityService);
                this.k = cursorAccessibilityService;
                this.e = iy0Var;
                getContext().setTheme(R.style.AppTheme);
                LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.action_screenshot_clipboard_popup, (ViewGroup) null);
                this.f = (FloatingActionButton) linearLayout.findViewById(R.id.crop_button);
                this.g = (FloatingActionButton) linearLayout.findViewById(R.id.share_button);
                this.h = (FloatingActionButton) linearLayout.findViewById(R.id.save_button);
                this.i = (FloatingActionButton) linearLayout.findViewById(R.id.delete_button);
                this.f.setBackgroundTintList(ColorStateList.valueOf(-16777216));
                this.g.setBackgroundTintList(ColorStateList.valueOf(-16777216));
                this.h.setBackgroundTintList(ColorStateList.valueOf(-16777216));
                this.i.setBackgroundTintList(ColorStateList.valueOf(-16777216));
                this.f.setVisibility(iy0Var.c ? 0 : 8);
                this.g.setVisibility(iy0Var.d ? 0 : 8);
                this.h.setVisibility(iy0Var.e ? 0 : 8);
                this.i.setVisibility(iy0Var.f ? 0 : 8);
                a(linearLayout);
                setOnTouchListener(this);
                this.g.setOnClickListener(new View.OnClickListener(this) { // from class: h3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6 = i5;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                g3Var.c();
                                jy0.r();
                                break;
                            case 1:
                                g3Var.c();
                                new g3((CursorAccessibilityService) g3Var.k, g3Var.e, 0);
                                break;
                            case 2:
                                g3Var.c();
                                jy0.o(g3Var.e);
                                break;
                            default:
                                g3Var.c();
                                jy0.m(g3Var.e);
                                break;
                        }
                    }
                });
                this.f.setOnClickListener(new View.OnClickListener(this) { // from class: h3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6 = i3;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                g3Var.c();
                                jy0.r();
                                break;
                            case 1:
                                g3Var.c();
                                new g3((CursorAccessibilityService) g3Var.k, g3Var.e, 0);
                                break;
                            case 2:
                                g3Var.c();
                                jy0.o(g3Var.e);
                                break;
                            default:
                                g3Var.c();
                                jy0.m(g3Var.e);
                                break;
                        }
                    }
                });
                this.h.setOnClickListener(new View.OnClickListener(this) { // from class: h3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6 = i4;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                g3Var.c();
                                jy0.r();
                                break;
                            case 1:
                                g3Var.c();
                                new g3((CursorAccessibilityService) g3Var.k, g3Var.e, 0);
                                break;
                            case 2:
                                g3Var.c();
                                jy0.o(g3Var.e);
                                break;
                            default:
                                g3Var.c();
                                jy0.m(g3Var.e);
                                break;
                        }
                    }
                });
                this.i.setOnClickListener(new View.OnClickListener(this) { // from class: h3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6 = i2;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                g3Var.c();
                                jy0.r();
                                break;
                            case 1:
                                g3Var.c();
                                new g3((CursorAccessibilityService) g3Var.k, g3Var.e, 0);
                                break;
                            case 2:
                                g3Var.c();
                                jy0.o(g3Var.e);
                                break;
                            default:
                                g3Var.c();
                                jy0.m(g3Var.e);
                                break;
                        }
                    }
                });
                b61 b61Var = new b61(new c(4, this), 3000L);
                this.j = b61Var;
                b61Var.c();
                break;
            default:
                this.e = iy0Var;
                getContext().setTheme(R.style.AppTheme);
                LinearLayout linearLayout2 = (LinearLayout) ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.action_screenshot_clipboard_crop_popup, (ViewGroup) null);
                this.f = (FloatingActionButton) linearLayout2.findViewById(R.id.crop_button);
                this.g = (FloatingActionButton) linearLayout2.findViewById(R.id.share_button);
                this.h = (FloatingActionButton) linearLayout2.findViewById(R.id.save_button);
                this.i = (FloatingActionButton) linearLayout2.findViewById(R.id.delete_button);
                this.f.setBackgroundTintList(ColorStateList.valueOf(-16777216));
                this.g.setBackgroundTintList(ColorStateList.valueOf(-16777216));
                this.h.setBackgroundTintList(ColorStateList.valueOf(-16777216));
                this.i.setBackgroundTintList(ColorStateList.valueOf(-16777216));
                this.f.setVisibility(iy0Var.c ? 0 : 8);
                this.g.setVisibility(iy0Var.d ? 0 : 8);
                this.h.setVisibility(iy0Var.e ? 0 : 8);
                this.i.setVisibility(iy0Var.f ? 0 : 8);
                CropImageView cropImageView = (CropImageView) linearLayout2.findViewById(R.id.crop_image_view);
                this.k = cropImageView;
                cropImageView.setImageUriAsync(jy0.n());
                ViewGroup.LayoutParams layoutParams = ((CropImageView) this.k).getLayoutParams();
                layoutParams.width = ey0.c() / 2;
                ((CropImageView) this.k).setLayoutParams(layoutParams);
                cq cqVar = new cq(null, null, 0.0f, 0.0f, 0.0f, null, null, false, false, false, false, false, false, 0, 0.0f, false, 0, 0, 0.0f, 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, 0, 0, 0, 0, 0, 0, 0, 0, false, false, 0.0f, 0, null, -1, -1, 63);
                cqVar.h = ey0.a(16);
                cqVar.s = 6;
                cqVar.i = fq.b;
                ((CropImageView) this.k).setImageCropOptions(cqVar);
                b61.b(new Runnable(this) { // from class: e3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int i6 = i5;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                ImageView imageView = (ImageView) ((CropImageView) g3Var.k).getChildAt(0);
                                Matrix imageMatrix = imageView.getImageMatrix();
                                imageMatrix.setScale(0.9999f, 0.9999f);
                                imageView.setImageMatrix(imageMatrix);
                                break;
                            default:
                                g3Var.b();
                                break;
                        }
                    }
                }, 100L);
                a(linearLayout2);
                setOnTouchListener(this);
                this.g.setOnClickListener(new View.OnClickListener(this) { // from class: f3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6 = i5;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                g3Var.b();
                                g3Var.d();
                                jy0.r();
                                break;
                            case 1:
                                g3Var.d();
                                break;
                            case 2:
                                g3Var.b();
                                iy0 iy0Var2 = g3Var.e;
                                jy0.p(iy0Var2, ((CropImageView) g3Var.k).getCroppedImage());
                                jy0.o(iy0Var2);
                                break;
                            default:
                                g3Var.b();
                                iy0 iy0Var3 = g3Var.e;
                                jy0.p(iy0Var3, ((CropImageView) g3Var.k).getCroppedImage());
                                jy0.m(iy0Var3);
                                break;
                        }
                    }
                });
                this.f.setOnClickListener(new View.OnClickListener(this) { // from class: f3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6 = i3;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                g3Var.b();
                                g3Var.d();
                                jy0.r();
                                break;
                            case 1:
                                g3Var.d();
                                break;
                            case 2:
                                g3Var.b();
                                iy0 iy0Var2 = g3Var.e;
                                jy0.p(iy0Var2, ((CropImageView) g3Var.k).getCroppedImage());
                                jy0.o(iy0Var2);
                                break;
                            default:
                                g3Var.b();
                                iy0 iy0Var3 = g3Var.e;
                                jy0.p(iy0Var3, ((CropImageView) g3Var.k).getCroppedImage());
                                jy0.m(iy0Var3);
                                break;
                        }
                    }
                });
                this.h.setOnClickListener(new View.OnClickListener(this) { // from class: f3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6 = i4;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                g3Var.b();
                                g3Var.d();
                                jy0.r();
                                break;
                            case 1:
                                g3Var.d();
                                break;
                            case 2:
                                g3Var.b();
                                iy0 iy0Var2 = g3Var.e;
                                jy0.p(iy0Var2, ((CropImageView) g3Var.k).getCroppedImage());
                                jy0.o(iy0Var2);
                                break;
                            default:
                                g3Var.b();
                                iy0 iy0Var3 = g3Var.e;
                                jy0.p(iy0Var3, ((CropImageView) g3Var.k).getCroppedImage());
                                jy0.m(iy0Var3);
                                break;
                        }
                    }
                });
                this.i.setOnClickListener(new View.OnClickListener(this) { // from class: f3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        int i6 = i2;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                g3Var.b();
                                g3Var.d();
                                jy0.r();
                                break;
                            case 1:
                                g3Var.d();
                                break;
                            case 2:
                                g3Var.b();
                                iy0 iy0Var2 = g3Var.e;
                                jy0.p(iy0Var2, ((CropImageView) g3Var.k).getCroppedImage());
                                jy0.o(iy0Var2);
                                break;
                            default:
                                g3Var.b();
                                iy0 iy0Var3 = g3Var.e;
                                jy0.p(iy0Var3, ((CropImageView) g3Var.k).getCroppedImage());
                                jy0.m(iy0Var3);
                                break;
                        }
                    }
                });
                b61 b61Var2 = new b61(new Runnable(this) { // from class: e3
                    public final /* synthetic */ g3 c;

                    {
                        this.c = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        int i6 = i3;
                        g3 g3Var = this.c;
                        switch (i6) {
                            case 0:
                                ImageView imageView = (ImageView) ((CropImageView) g3Var.k).getChildAt(0);
                                Matrix imageMatrix = imageView.getImageMatrix();
                                imageMatrix.setScale(0.9999f, 0.9999f);
                                imageView.setImageMatrix(imageMatrix);
                                break;
                            default:
                                g3Var.b();
                                break;
                        }
                    }
                }, 3000L);
                this.j = b61Var2;
                b61Var2.c();
                ((CropImageView) this.k).setOnSetCropOverlayMovedListener(new r1(i4, this));
                break;
        }
    }

    public final void a(LinearLayout linearLayout) {
        this.c = linearLayout;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, 2032, 262952, -3);
        layoutParams.gravity = 85;
        layoutParams.y = yb0.l(CursorAccessibilityService.q);
        setLayoutParams(layoutParams);
        try {
            this.b.addView(this, layoutParams);
        } catch (Exception unused) {
        }
        addView(this.c);
        this.c.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fade_in));
    }

    public void b() {
        b61 b61Var = this.j;
        if (b61Var != null) {
            b61Var.d();
        }
        e();
    }

    public void c() {
        b61 b61Var = this.j;
        if (b61Var != null) {
            b61Var.d();
        }
        e();
    }

    public void d() {
        b();
        Bitmap croppedImage = ((CropImageView) this.k).getCroppedImage();
        iy0 iy0Var = this.e;
        jy0.p(iy0Var, croppedImage);
        if (iy0Var.a) {
            jy0.q();
        }
        if (iy0Var.b) {
            jy0.o(iy0Var);
        }
    }

    public final void e() {
        try {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
            animationLoadAnimation.setAnimationListener(new s0(this, 0));
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) getLayoutParams();
            layoutParams.flags |= 16;
            setLayoutParams(layoutParams);
            this.b.updateViewLayout(this, layoutParams);
            this.c.startAnimation(animationLoadAnimation);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (this.d) {
            case 0:
                if (motionEvent.getAction() == 4) {
                    b();
                }
                break;
            default:
                if (motionEvent.getAction() == 4) {
                    c();
                }
                break;
        }
        return true;
    }

    @Override // android.view.View
    public final boolean performClick() {
        switch (this.d) {
            case 0:
                super.performClick();
                break;
            default:
                super.performClick();
                break;
        }
        return true;
    }

    public g3(CursorAccessibilityService cursorAccessibilityService) {
        super(cursorAccessibilityService);
        f01.d(getContext());
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        this.b = (WindowManager) getContext().getSystemService("window");
    }
}
