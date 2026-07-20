package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import defpackage.d61;
import defpackage.f9;
import defpackage.m4;
import defpackage.n51;
import defpackage.zm;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageView extends ImageView {
    public final m4 b;
    public final f9 c;
    public boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d61.a(context);
        this.d = false;
        n51.a(this, getContext());
        m4 m4Var = new m4(this);
        this.b = m4Var;
        m4Var.k(attributeSet, i);
        f9 f9Var = new f9(this);
        this.c = f9Var;
        f9Var.e(attributeSet, i);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.a();
        }
        f9 f9Var = this.c;
        if (f9Var != null) {
            f9Var.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        m4 m4Var = this.b;
        if (m4Var != null) {
            return m4Var.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        m4 m4Var = this.b;
        if (m4Var != null) {
            return m4Var.i();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        zm zmVar;
        f9 f9Var = this.c;
        if (f9Var == null || (zmVar = (zm) f9Var.d) == null) {
            return null;
        }
        return (ColorStateList) zmVar.c;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        zm zmVar;
        f9 f9Var = this.c;
        if (f9Var == null || (zmVar = (zm) f9Var.d) == null) {
            return null;
        }
        return (PorterDuff.Mode) zmVar.d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return !(((ImageView) this.c.c).getBackground() instanceof RippleDrawable) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.n(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        f9 f9Var = this.c;
        if (f9Var != null) {
            f9Var.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        f9 f9Var = this.c;
        if (f9Var != null && drawable != null && !this.d) {
            f9Var.b = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (f9Var != null) {
            f9Var.a();
            if (this.d) {
                return;
            }
            ImageView imageView = (ImageView) f9Var.c;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(f9Var.b);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i) {
        super.setImageLevel(i);
        this.d = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        f9 f9Var = this.c;
        if (f9Var != null) {
            f9Var.h(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        f9 f9Var = this.c;
        if (f9Var != null) {
            f9Var.a();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        m4 m4Var = this.b;
        if (m4Var != null) {
            m4Var.t(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        f9 f9Var = this.c;
        if (f9Var != null) {
            if (((zm) f9Var.d) == null) {
                f9Var.d = new zm();
            }
            zm zmVar = (zm) f9Var.d;
            zmVar.c = colorStateList;
            zmVar.b = true;
            f9Var.a();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        f9 f9Var = this.c;
        if (f9Var != null) {
            if (((zm) f9Var.d) == null) {
                f9Var.d = new zm();
            }
            zm zmVar = (zm) f9Var.d;
            zmVar.d = mode;
            zmVar.a = true;
            f9Var.a();
        }
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
